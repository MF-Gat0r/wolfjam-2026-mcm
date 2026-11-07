/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.wolfjammod.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.Block;

import net.mcreator.wolfjammod.block.RoomResetBlock;
import net.mcreator.wolfjammod.block.CustomColorBlockBlock;
import net.mcreator.wolfjammod.block.CounterLavaBlockBlock;
import net.mcreator.wolfjammod.WolfjammodMod;

public class WolfjammodModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(WolfjammodMod.MODID);
	public static final DeferredBlock<Block> ROOM_RESET;
	public static final DeferredBlock<Block> COUNTER_LAVA_BLOCK;
	public static final DeferredBlock<Block> CUSTOM_COLOR_BLOCK;
	static {
		ROOM_RESET = REGISTRY.register("room_reset", RoomResetBlock::new);
		COUNTER_LAVA_BLOCK = REGISTRY.register("counter_lava_block", CounterLavaBlockBlock::new);
		CUSTOM_COLOR_BLOCK = REGISTRY.register("custom_color_block", CustomColorBlockBlock::new);
	}
	// Start of user code block custom blocks
	// End of user code block custom blocks
}