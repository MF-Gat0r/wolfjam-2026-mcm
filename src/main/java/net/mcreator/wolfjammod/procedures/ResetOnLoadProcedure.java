package net.mcreator.wolfjammod.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.Entity;

import net.mcreator.wolfjammod.network.WolfjammodModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class ResetOnLoadProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		{
			WolfjammodModVariables.PlayerVariables _vars = entity.getData(WolfjammodModVariables.PLAYER_VARIABLES);
			_vars.levelName = "";
			_vars.playerErrors = 0;
			_vars.room_count = 0;
			_vars.redResults = false;
			_vars.greenResults = false;
			_vars.yellowResults = false;
			_vars.markSyncDirty();
		}
	}
}