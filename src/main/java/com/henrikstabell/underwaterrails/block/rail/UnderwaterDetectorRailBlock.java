package com.henrikstabell.underwaterrails.block.rail;

import com.henrikstabell.underwaterrails.block.rail.api.IUnderwaterRail;
import net.minecraft.world.level.block.DetectorRailBlock;
import net.minecraft.world.level.block.LiquidBlockContainer;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;

public class UnderwaterDetectorRailBlock extends DetectorRailBlock implements LiquidBlockContainer, IUnderwaterRail {

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public UnderwaterDetectorRailBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(WATERLOGGED, Boolean.valueOf(false)));
    }
    public FluidState getFluidState(BlockState p_54336_) {
        return Fluids.WATER.getSource(false);
    }

    @Override
    public boolean waterBreathingWhenOnRail() {
        return true;
    }
}
