package com.henrikstabell.underwaterrails.handler;

import com.henrikstabell.underwaterrails.block.rail.api.IUnderwaterRail;
import dev.architectury.event.EventResult;
import dev.architectury.event.events.common.EntityEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.vehicle.Minecart;

public class EventHandler {

    public static void initEvents() {
        // Prevent drown damage when on underwater rail.
        EntityEvent.LIVING_HURT.register((entity, source, amount) -> {
            if (source == DamageSource.DROWN) {
                if (entity.getRootVehicle() instanceof Minecart) {
                    if (entity.level.getBlockState(new BlockPos(Mth.floor(entity.getX()), Mth.floor(entity.getY()), Mth.floor(entity.getZ())).above()).getBlock() instanceof IUnderwaterRail) {
                        if (((IUnderwaterRail) entity.level.getBlockState((new BlockPos(Mth.floor(entity.getX()), Mth.floor(entity.getY()), Mth.floor(entity.getZ()))).above()).getBlock()).waterBreathingWhenOnRail()) {
                            entity.setAirSupply(300);
                            return EventResult.interruptFalse();
                        }
                    }
                }
            } return EventResult.pass();
        });

    }
}
