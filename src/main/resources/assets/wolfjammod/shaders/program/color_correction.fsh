
#version 150

uniform sampler2D DiffuseSampler;

in vec2 texCoord;

out vec4 fragColor;

// Custom accessibility color matrix
const mat3 COLOR_MATRIX = mat3(
    1.15, -0.05, -0.05,
   -0.10,  1.10, -0.10,
   -0.05, -0.05,  1.15
);

void main() {

    // Get the original rendered pixel
    vec4 originalColor = texture(DiffuseSampler, texCoord);

    // Apply color transformation
    vec3 correctedColor =
        COLOR_MATRIX * originalColor.rgb;

    // Keep RGB values within valid range
    correctedColor = clamp(correctedColor, 0.0, 1.0);

    // Preserve transparency
    fragColor = vec4(correctedColor, originalColor.a);
}
