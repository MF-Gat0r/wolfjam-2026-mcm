/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.wolfjammod.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.Block;

import net.mcreator.wolfjammod.block.RoomResetBlock;
import net.mcreator.wolfjammod.block.RoomAssignerBlock;
import net.mcreator.wolfjammod.block.LavaBlockBlock;
import net.mcreator.wolfjammod.block.CustomColorBlockBlock;
import net.mcreator.wolfjammod.WolfjammodMod;

public class WolfjammodModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(WolfjammodMod.MODID);
	public static final DeferredBlock<Block> ROOM_RESET;
	public static final DeferredBlock<Block> CUSTOM_COLOR_BLOCK;
	public static final DeferredBlock<Block> ROOM_ASSIGNER;
	public static final DeferredBlock<Block> LAVA_BLOCK;
	static {
		ROOM_RESET = REGISTRY.register("room_reset", RoomResetBlock::new);
		CUSTOM_COLOR_BLOCK = REGISTRY.register("custom_color_block", CustomColorBlockBlock::new);
		ROOM_ASSIGNER = REGISTRY.register("room_assigner", RoomAssignerBlock::new);
		LAVA_BLOCK = REGISTRY.register("lava_block", LavaBlockBlock::new);
	}
	// Start of user code block custom blocks
	// End of user code block custom blocks
}