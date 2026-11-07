
#version 150

uniform sampler2D DiffuseSampler;
uniform float Mode; // 0 = off, 1 = protan, 2 = deutan, 3 = tritan

in vec2 texCoord;

out vec4 fragColor;

// Colorblindness simulation matrices (Machado 2009, linear RGB), written row by row
const mat3 PROTAN = transpose(mat3(
    0.152286, 1.052583, -0.204868,
    0.114503, 0.786281,  0.099216,
   -0.003882, -0.048116, 1.051998));

const mat3 DEUTAN = transpose(mat3(
    0.367322, 0.860646, -0.227968,
    0.280085, 0.672501,  0.047413,
   -0.011820, 0.042940,  0.968881));

const mat3 TRITAN = transpose(mat3(
    1.255528, -0.076749, -0.178779,
   -0.078411,  0.930809,  0.147602,
    0.004733,  0.691367,  0.303900));

void main() {
    vec4 originalColor = texture(DiffuseSampler, texCoord);
    int mode = int(Mode + 0.5);

    if (mode == 0) {
        fragColor = originalColor;
        return;
    }

    vec3 linear = pow(originalColor.rgb, vec3(2.2));

    vec3 simulated;
    if (mode == 1) simulated = PROTAN * linear;
    else if (mode == 2) simulated = DEUTAN * linear;
    else simulated = TRITAN * linear;

    // Color information the viewer cannot see
    vec3 err = linear - simulated;

    // Move the lost information into channels the viewer can distinguish
    vec3 shift;
    if (mode == 3) {
        shift = vec3(err.r + 0.7 * err.b, err.g + 0.7 * err.b, 0.0);
    } else {
        shift = vec3(0.0, 0.7 * err.r + err.g, 0.7 * err.r + err.b);
    }

    // Strength > 1 exaggerates the shift so it is clearly visible when testing
    const float STRENGTH = 2.5;
    vec3 corrected = clamp(linear + shift * STRENGTH, 0.0, 1.0);
    fragColor = vec4(pow(corrected, vec3(1.0 / 2.2)), originalColor.a);
}
