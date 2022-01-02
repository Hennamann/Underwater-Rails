package com.henrikstabell.underwaterrails.block.rail.basic;

import com.henrikstabell.underwaterrails.block.rail.IUnderwaterRail;
import net.minecraft.block.*;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.Property;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.RailShape;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockBasicPoweredUnderwaterRail extends PoweredRailBlock implements IWaterLoggable, IUnderwaterRail {

    public static final EnumProperty<RailShape> SHAPE = BlockStateProperties.RAIL_SHAPE_STRAIGHT;
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
    private final boolean isActivator;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public BlockBasicPoweredUnderwaterRail(AbstractBlock.Properties p_i48349_1_) {
        this(p_i48349_1_, false);
    }

    public BlockBasicPoweredUnderwaterRail(AbstractBlock.Properties properties, boolean isPoweredRail) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(SHAPE, RailShape.NORTH_SOUTH).setValue(POWERED, Boolean.valueOf(false)).setValue(WATERLOGGED, Boolean.valueOf(false)));
        this.isActivator = !isPoweredRail;
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> state) {
        state.add(SHAPE, WATERLOGGED, POWERED);
    }

    public boolean isActivatorRail() {
        return isActivator;
    }

    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    public boolean waterBreathingWhenOnRail() {
        return false;
    }
}
