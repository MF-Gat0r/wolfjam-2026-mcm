
package net.mcreator.wolfjammod;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.PostChain;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import org.lwjgl.glfw.GLFW;

@EventBusSubscriber(modid = "wolfjammod", value = Dist.CLIENT)
public class TintBlocks {

    // Color modes: 0 = off, 1 = protan (red), 2 = deutan (green), 3 = tritan (blue-yellow)
    public static final int MODE_OFF = 0;
    public static final int MODE_PROTAN = 1;
    public static final int MODE_DEUTAN = 2;
    public static final int MODE_TRITAN = 3;

    // Key used to cycle color modes (K), handy for testing
    private static final KeyMapping TOGGLE_COLOR_CORRECTION =
            new KeyMapping(
                    "key.wolfjammod.toggle_color_correction",
                    InputConstants.Type.KEYSYM,
                    GLFW.GLFW_KEY_K,
                    "key.categories.misc"
            );

    private static int colorMode = MODE_OFF;

    // Call this at the end of the test to give the player their mode
    public static void setColorMode(int mode) {
        colorMode = Math.floorMod(mode, 4);
        Minecraft mc = Minecraft.getInstance();

        if (colorMode == MODE_OFF) {
            mc.gameRenderer.shutdownEffect();
        } else if (mc.gameRenderer.currentEffect() == null) {
            mc.gameRenderer.loadEffect(
                    ResourceLocation.fromNamespaceAndPath(
                            "wolfjammod",
                            "shaders/post/color_correction.json"
                    )
            );
        }
    }

    public static int getColorMode() {
        return colorMode;
    }

    @SubscribeEvent
    public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
        event.register(TOGGLE_COLOR_CORRECTION);
    }

    @SubscribeEvent
    public static void onClientTick(ClientTickEvent.Post event) {

        while (TOGGLE_COLOR_CORRECTION.consumeClick()) {
            setColorMode(colorMode + 1);
        }

        // Keep the shader uniform in sync with the selected mode
        PostChain chain = Minecraft.getInstance().gameRenderer.currentEffect();
        if (chain != null && colorMode != MODE_OFF) {
            chain.setUniform("Mode", colorMode);
        }
    }
}
