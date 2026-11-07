/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.wolfjammod.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.mcreator.wolfjammod.WolfjammodMod;

public class WolfjammodModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(WolfjammodMod.MODID);
	public static final DeferredItem<Item> ROOM_RESET;
	public static final DeferredItem<Item> COUNTER_LAVA_BLOCK;
	public static final DeferredItem<Item> CUSTOM_COLOR_BLOCK;
	static {
		ROOM_RESET = block(WolfjammodModBlocks.ROOM_RESET);
		COUNTER_LAVA_BLOCK = block(WolfjammodModBlocks.COUNTER_LAVA_BLOCK);
		CUSTOM_COLOR_BLOCK = block(WolfjammodModBlocks.CUSTOM_COLOR_BLOCK);
	}

	// Start of user code block custom items
	// End of user code block custom items
	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return block(block, new Item.Properties());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block, Item.Properties properties) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), properties));
	}
}