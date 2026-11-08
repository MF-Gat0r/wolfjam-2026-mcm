package net.mcreator.wolfjammod.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.mcreator.wolfjammod.network.WolfjammodModVariables;
import net.mcreator.wolfjammod.WolfjammodMod;

public class RoomAssignerEntityWalksOnTheBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "occupied") == false) {
			{
				WolfjammodModVariables.PlayerVariables _vars = entity.getData(WolfjammodModVariables.PLAYER_VARIABLES);
				_vars.room_count = entity.getData(WolfjammodModVariables.PLAYER_VARIABLES).room_count + 1;
				_vars.markSyncDirty();
			}
			if (entity.getData(WolfjammodModVariables.PLAYER_VARIABLES).room_count == 1) {
				{
					WolfjammodModVariables.PlayerVariables _vars = entity.getData(WolfjammodModVariables.PLAYER_VARIABLES);
					_vars.levelName = "normal";
					_vars.markSyncDirty();
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("normal level"), false);
			} else if (entity.getData(WolfjammodModVariables.PLAYER_VARIABLES).room_count == 2) {
				{
					WolfjammodModVariables.PlayerVariables _vars = entity.getData(WolfjammodModVariables.PLAYER_VARIABLES);
					_vars.levelName = "pro";
					_vars.markSyncDirty();
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("pro level"), false);
			} else if (entity.getData(WolfjammodModVariables.PLAYER_VARIABLES).room_count == 3) {
				{
					WolfjammodModVariables.PlayerVariables _vars = entity.getData(WolfjammodModVariables.PLAYER_VARIABLES);
					_vars.levelName = "deut";
					_vars.markSyncDirty();
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("deut lvl"), false);
			} else if (entity.getData(WolfjammodModVariables.PLAYER_VARIABLES).room_count == 4) {
				{
					WolfjammodModVariables.PlayerVariables _vars = entity.getData(WolfjammodModVariables.PLAYER_VARIABLES);
					_vars.levelName = "tri";
					_vars.markSyncDirty();
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("tri lvl"), false);
			} else if (entity.getData(WolfjammodModVariables.PLAYER_VARIABLES).room_count == 5) {
				{
					WolfjammodModVariables.PlayerVariables _vars = entity.getData(WolfjammodModVariables.PLAYER_VARIABLES);
					_vars.levelName = "END";
					_vars.markSyncDirty();
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Results: "), false);
			}
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putBoolean("occupied", true);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		WolfjammodMod.LOGGER.info(entity.getData(WolfjammodModVariables.PLAYER_VARIABLES).levelName);
		WolfjammodMod.LOGGER.info(entity.getData(WolfjammodModVariables.PLAYER_VARIABLES).playerErrors);
	}

	private static boolean getBlockNBTLogic(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getBoolean(tag);
		return false;
	}
}