package com.henrikstabell.underwaterrails.block.rail.advanced;

import com.henrikstabell.underwaterrails.block.rail.IUnderwaterRail;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.DetectorRailBlock;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;

public class BlockAdvancedDetectorUnderwaterRail extends DetectorRailBlock implements IWaterLoggable, IUnderwaterRail {

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public BlockAdvancedDetectorUnderwaterRail(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(WATERLOGGED, Boolean.valueOf(false)));
    }

    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> state) {
        state.add(SHAPE, WATERLOGGED, POWERED);
    }

    @Override
    public boolean waterBreathingWhenOnRail() {
        return true;
    }
}
