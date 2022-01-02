package com.henrikstabell.underwaterrails.block.rail;

/**
 * Used on Underwater capable RailBlocks {@link net.minecraft.block.AbstractRailBlock}
 * Currently only used to distinguish between basic and advanced rails.
 * {@see com.henrikstabell.underwaterrails.handler.EventHandler.onMinecartDrownDamage} for current usage.
 */
public interface IUnderwaterRail {

    boolean waterBreathingWhenOnRail();

}
