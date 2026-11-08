package net.mcreator.wolfjammod.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.wolfjammod.network.WolfjammodModVariables;

public class RoomResetEntityWalksOnTheBlockProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getData(WolfjammodModVariables.PLAYER_VARIABLES).levelName).equals("pro") && entity.getData(WolfjammodModVariables.PLAYER_VARIABLES).playerErrors >= 20) {
			{
				WolfjammodModVariables.PlayerVariables _vars = entity.getData(WolfjammodModVariables.PLAYER_VARIABLES);
				_vars.redResults = true;
				_vars.markSyncDirty();
			}
		} else if ((entity.getData(WolfjammodModVariables.PLAYER_VARIABLES).levelName).equals("deut") && entity.getData(WolfjammodModVariables.PLAYER_VARIABLES).playerErrors >= 20) {
			{
				WolfjammodModVariables.PlayerVariables _vars = entity.getData(WolfjammodModVariables.PLAYER_VARIABLES);
				_vars.greenResults = true;
				_vars.markSyncDirty();
			}
		} else if ((entity.getData(WolfjammodModVariables.PLAYER_VARIABLES).levelName).equals("tri") && entity.getData(WolfjammodModVariables.PLAYER_VARIABLES).playerErrors >= 20) {
			{
				WolfjammodModVariables.PlayerVariables _vars = entity.getData(WolfjammodModVariables.PLAYER_VARIABLES);
				_vars.yellowResults = true;
				_vars.markSyncDirty();
			}
		} else if ((entity.getData(WolfjammodModVariables.PLAYER_VARIABLES).levelName).equals("END")) {
			if (entity.getData(WolfjammodModVariables.PLAYER_VARIABLES).redResults) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("press [k] once to apply the colorblind filter for you"), false);
			} else if (entity.getData(WolfjammodModVariables.PLAYER_VARIABLES).greenResults) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("press [k] twice to apply the colorblind filter for you"), false);
			} else if (entity.getData(WolfjammodModVariables.PLAYER_VARIABLES).yellowResults) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("press [k] thrice to apply the colorblind filter for you"), false);
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("You're not colorblind!"), false);
			}
		}
		{
			WolfjammodModVariables.PlayerVariables _vars = entity.getData(WolfjammodModVariables.PLAYER_VARIABLES);
			_vars.playerErrors = 0;
			_vars.markSyncDirty();
		}
	}
}