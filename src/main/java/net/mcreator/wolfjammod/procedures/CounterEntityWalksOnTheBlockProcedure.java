package net.mcreator.wolfjammod.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.wolfjammod.network.WolfjammodModVariables;

public class CounterEntityWalksOnTheBlockProcedure {

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return;

        BlockPos currentPos = BlockPos.containing(x, y, z);

        if (entity.getData(WolfjammodModVariables.PLAYER_VARIABLES).lastX != currentPos.getX()
                || entity.getData(WolfjammodModVariables.PLAYER_VARIABLES).lastY != currentPos.getY()
                || entity.getData(WolfjammodModVariables.PLAYER_VARIABLES).lastZ != currentPos.getZ()) {

            {
                WolfjammodModVariables.PlayerVariables _vars =
                        entity.getData(WolfjammodModVariables.PLAYER_VARIABLES);

                _vars.playerErrors =
                        entity.getData(WolfjammodModVariables.PLAYER_VARIABLES).playerErrors + 1;

                _vars.lastX = currentPos.getX();
                _vars.lastY = currentPos.getY();
                _vars.lastZ = currentPos.getZ();

                _vars.markSyncDirty();
            }

            if (entity instanceof Player _player && !_player.level().isClientSide())
                _player.displayClientMessage(Component.literal("mistake made"), false);
        }
    }
}