/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.wolfjammod.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.core.registries.Registries;

import net.mcreator.wolfjammod.WolfjammodMod;

@EventBusSubscriber
public class WolfjammodModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, WolfjammodMod.MODID);

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
			tabData.accept(WolfjammodModBlocks.ROOM_RESET.get().asItem());
			tabData.accept(WolfjammodModBlocks.CUSTOM_COLOR_BLOCK.get().asItem());
			tabData.accept(WolfjammodModBlocks.ROOM_ASSIGNER.get().asItem());
			tabData.accept(WolfjammodModBlocks.LAVA_BLOCK.get().asItem());
		} else if (tabData.getTabKey() == CreativeModeTabs.COLORED_BLOCKS) {
			tabData.accept(WolfjammodModBlocks.ROOM_RESET.get().asItem());
			tabData.accept(WolfjammodModBlocks.CUSTOM_COLOR_BLOCK.get().asItem());
			tabData.accept(WolfjammodModBlocks.ROOM_ASSIGNER.get().asItem());
			tabData.accept(WolfjammodModBlocks.LAVA_BLOCK.get().asItem());
		}
	}
}