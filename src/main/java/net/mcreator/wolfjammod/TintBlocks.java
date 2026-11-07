
package net.mcreator.wolfjammod;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import org.lwjgl.glfw.GLFW;

@EventBusSubscriber(modid = "wolfjammod", value = Dist.CLIENT)
public class TintBlocks {

    // Key used to toggle color correction (K)
    private static final KeyMapping TOGGLE_COLOR_CORRECTION =
            new KeyMapping(
                    "key.wolfjammod.toggle_color_correction",
                    InputConstants.Type.KEYSYM,
                    GLFW.GLFW_KEY_K,
                    "key.categories.misc"
            );

    // Tracks whether the color correction effect is enabled
    private static boolean colorCorrectionEnabled = false;

    // Registers the keybind in Minecraft's Controls menu
    @SubscribeEvent
    public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
        event.register(TOGGLE_COLOR_CORRECTION);
    }

    // Checks for the keybind every client tick
    @SubscribeEvent
    public static void onClientTick(ClientTickEvent.Post event) {

        while (TOGGLE_COLOR_CORRECTION.consumeClick()) {

            // Turn color correction on
            if (!colorCorrectionEnabled) {

                Minecraft.getInstance().gameRenderer.loadEffect(
                        ResourceLocation.fromNamespaceAndPath(
                                "wolfjammod",
                                "shaders/post/color_correction.json"
                        )
                );

                colorCorrectionEnabled = true;
            }

            // Turn color correction off
            else {

                Minecraft.getInstance().gameRenderer.shutdownEffect();

                colorCorrectionEnabled = false;
            }
        }
    }
}
