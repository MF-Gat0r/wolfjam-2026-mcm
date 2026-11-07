package net.mcreator.wolfjammod.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.wolfjammod.network.WolfjammodModVariables;

public class RoomResetEntityWalksOnTheBlockProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getData(WolfjammodModVariables.PLAYER_VARIABLES).levelName).equals("redblind") && entity.getData(WolfjammodModVariables.PLAYER_VARIABLES).playerErrors >= 20) {
			{
				WolfjammodModVariables.PlayerVariables _vars = entity.getData(WolfjammodModVariables.PLAYER_VARIABLES);
				_vars.redResults = true;
				_vars.markSyncDirty();
			}
		} else if ((entity.getData(WolfjammodModVariables.PLAYER_VARIABLES).levelName).equals("greenblind") && entity.getData(WolfjammodModVariables.PLAYER_VARIABLES).playerErrors >= 20) {
			{
				WolfjammodModVariables.PlayerVariables _vars = entity.getData(WolfjammodModVariables.PLAYER_VARIABLES);
				_vars.greenResults = true;
				_vars.markSyncDirty();
			}
		} else if ((entity.getData(WolfjammodModVariables.PLAYER_VARIABLES).levelName).equals("yellowblind") && entity.getData(WolfjammodModVariables.PLAYER_VARIABLES).playerErrors >= 20) {
			{
				WolfjammodModVariables.PlayerVariables _vars = entity.getData(WolfjammodModVariables.PLAYER_VARIABLES);
				_vars.yellowResults = true;
				_vars.markSyncDirty();
			}
		}
		{
			WolfjammodModVariables.PlayerVariables _vars = entity.getData(WolfjammodModVariables.PLAYER_VARIABLES);
			_vars.playerErrors = 0;
			_vars.markSyncDirty();
		}
	}
}