package com.henrikstabell.underwaterrails.block.rail;

import com.henrikstabell.underwaterrails.block.rail.api.IUnderwaterRail;
import net.minecraft.world.level.block.LiquidBlockContainer;
import net.minecraft.world.level.block.RailBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.RailShape;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;

/**
 * See The repos LICENSE.MD file for what you can and can't do with the code.
 * Created by Hennamann(Ole Henrik Stabell) on 30/03/2018.
 */
public class UnderwaterRailBlock extends RailBlock implements LiquidBlockContainer, IUnderwaterRail {

    private static final EnumProperty<RailShape> SHAPE = BlockStateProperties.RAIL_SHAPE;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public UnderwaterRailBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(SHAPE, RailShape.NORTH_SOUTH).setValue(WATERLOGGED, Boolean.valueOf(false)));
    }

    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    public boolean waterBreathingWhenOnRail() {
        return true;
    }
}
