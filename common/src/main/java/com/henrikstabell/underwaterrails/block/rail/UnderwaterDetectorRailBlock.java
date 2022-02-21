package com.henrikstabell.underwaterrails.block.rail;

import com.henrikstabell.underwaterrails.block.rail.api.IUnderwaterRail;
import net.minecraft.world.level.block.DetectorRailBlock;
import net.minecraft.world.level.block.LiquidBlockContainer;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class UnderwaterDetectorRailBlock extends DetectorRailBlock implements LiquidBlockContainer, IUnderwaterRail {

    public UnderwaterDetectorRailBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(WATERLOGGED, Boolean.valueOf(false)));
    }

    @Override
    public boolean waterBreathingWhenOnRail() {
        return true;
    }
}
