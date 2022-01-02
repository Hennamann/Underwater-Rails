package com.henrikstabell.underwaterrails.block.rail.advanced;

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
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * See The repos LICENSE.MD file for what you can and can't do with the code.
 * Created by Hennamann(Ole Henrik Stabell) on 30/03/2018.
 */
public class BlockAdvancedUnderwaterRail extends RailBlock implements IWaterLoggable, IUnderwaterRail {

    private static final EnumProperty<RailShape> SHAPE = BlockStateProperties.RAIL_SHAPE;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public BlockAdvancedUnderwaterRail(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(SHAPE, RailShape.NORTH_SOUTH).setValue(WATERLOGGED, Boolean.valueOf(false)));
    }

    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(SHAPE, WATERLOGGED);
    }

    @Override
    public boolean waterBreathingWhenOnRail() {
        return true;
    }
}
