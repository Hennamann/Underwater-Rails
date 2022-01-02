package com.henrikstabell.underwaterrails.block.rail.api;

/**
 * Used on Underwater capable RailBlocks {@link net.minecraft.world.level.block.BaseRailBlock}
 * Currently only used to consolidate all non-vanilla underwater capable rails..
 * {@see com.henrikstabell.underwaterrails.handler.EventHandler.onMinecartDrownDamage} for current usage.
 */
public interface IUnderwaterRail {

    boolean waterBreathingWhenOnRail();

}
