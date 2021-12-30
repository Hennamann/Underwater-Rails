package com.henrikstabell.underwaterrails.block.rail;

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
public class BlockAdvancedUnderwaterRail extends AbstractRailBlock implements  IWaterLoggable {

    private static final EnumProperty<RailShape> SHAPE = BlockStateProperties.RAIL_SHAPE;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public BlockAdvancedUnderwaterRail(Properties properties) {
        super(false, properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(SHAPE, RailShape.NORTH_SOUTH).setValue(WATERLOGGED, Boolean.valueOf(false)));
    }

    protected void updateState(BlockState blockState, World world, BlockPos blockPos, Block block) {
        if (block.defaultBlockState().isSignalSource() && (new RailState(world, blockPos, blockState)).countPotentialConnections() == 3) {
            this.updateDir(world, blockPos, blockState, false);
        }
    }

    public Property<RailShape> getShapeProperty() {
        return SHAPE;
    }

    public BlockState rotate(BlockState blockState, Rotation rotation) {
        switch(rotation) {
            case CLOCKWISE_180:
                switch((RailShape)blockState.getValue(SHAPE)) {
                    case ASCENDING_EAST:
                        return blockState.setValue(SHAPE, RailShape.ASCENDING_WEST);
                    case ASCENDING_WEST:
                        return blockState.setValue(SHAPE, RailShape.ASCENDING_EAST);
                    case ASCENDING_NORTH:
                        return blockState.setValue(SHAPE, RailShape.ASCENDING_SOUTH);
                    case ASCENDING_SOUTH:
                        return blockState.setValue(SHAPE, RailShape.ASCENDING_NORTH);
                    case SOUTH_EAST:
                        return blockState.setValue(SHAPE, RailShape.NORTH_WEST);
                    case SOUTH_WEST:
                        return blockState.setValue(SHAPE, RailShape.NORTH_EAST);
                    case NORTH_WEST:
                        return blockState.setValue(SHAPE, RailShape.SOUTH_EAST);
                    case NORTH_EAST:
                        return blockState.setValue(SHAPE, RailShape.SOUTH_WEST);
                    case NORTH_SOUTH: //Forge fix: MC-196102
                    case EAST_WEST:
                        return blockState;
                }
            case COUNTERCLOCKWISE_90:
                switch((RailShape)blockState.getValue(SHAPE)) {
                    case ASCENDING_EAST:
                        return blockState.setValue(SHAPE, RailShape.ASCENDING_NORTH);
                    case ASCENDING_WEST:
                        return blockState.setValue(SHAPE, RailShape.ASCENDING_SOUTH);
                    case ASCENDING_NORTH:
                        return blockState.setValue(SHAPE, RailShape.ASCENDING_WEST);
                    case ASCENDING_SOUTH:
                        return blockState.setValue(SHAPE, RailShape.ASCENDING_EAST);
                    case SOUTH_EAST:
                        return blockState.setValue(SHAPE, RailShape.NORTH_EAST);
                    case SOUTH_WEST:
                        return blockState.setValue(SHAPE, RailShape.SOUTH_EAST);
                    case NORTH_WEST:
                        return blockState.setValue(SHAPE, RailShape.SOUTH_WEST);
                    case NORTH_EAST:
                        return blockState.setValue(SHAPE, RailShape.NORTH_WEST);
                    case NORTH_SOUTH:
                        return blockState.setValue(SHAPE, RailShape.EAST_WEST);
                    case EAST_WEST:
                        return blockState.setValue(SHAPE, RailShape.NORTH_SOUTH);
                }
            case CLOCKWISE_90:
                switch((RailShape)blockState.getValue(SHAPE)) {
                    case ASCENDING_EAST:
                        return blockState.setValue(SHAPE, RailShape.ASCENDING_SOUTH);
                    case ASCENDING_WEST:
                        return blockState.setValue(SHAPE, RailShape.ASCENDING_NORTH);
                    case ASCENDING_NORTH:
                        return blockState.setValue(SHAPE, RailShape.ASCENDING_EAST);
                    case ASCENDING_SOUTH:
                        return blockState.setValue(SHAPE, RailShape.ASCENDING_WEST);
                    case SOUTH_EAST:
                        return blockState.setValue(SHAPE, RailShape.SOUTH_WEST);
                    case SOUTH_WEST:
                        return blockState.setValue(SHAPE, RailShape.NORTH_WEST);
                    case NORTH_WEST:
                        return blockState.setValue(SHAPE, RailShape.NORTH_EAST);
                    case NORTH_EAST:
                        return blockState.setValue(SHAPE, RailShape.SOUTH_EAST);
                    case NORTH_SOUTH:
                        return blockState.setValue(SHAPE, RailShape.EAST_WEST);
                    case EAST_WEST:
                        return blockState.setValue(SHAPE, RailShape.NORTH_SOUTH);
                }
            default:
                return blockState;
        }
    }

    public BlockState mirror(BlockState blockState, Mirror mirror) {
        RailShape railshape = blockState.getValue(SHAPE);
        switch(mirror) {
            case LEFT_RIGHT:
                switch(railshape) {
                    case ASCENDING_NORTH:
                        return blockState.setValue(SHAPE, RailShape.ASCENDING_SOUTH);
                    case ASCENDING_SOUTH:
                        return blockState.setValue(SHAPE, RailShape.ASCENDING_NORTH);
                    case SOUTH_EAST:
                        return blockState.setValue(SHAPE, RailShape.NORTH_EAST);
                    case SOUTH_WEST:
                        return blockState.setValue(SHAPE, RailShape.NORTH_WEST);
                    case NORTH_WEST:
                        return blockState.setValue(SHAPE, RailShape.SOUTH_WEST);
                    case NORTH_EAST:
                        return blockState.setValue(SHAPE, RailShape.SOUTH_EAST);
                    default:
                        return super.mirror(blockState, mirror);
                }
            case FRONT_BACK:
                switch(railshape) {
                    case ASCENDING_EAST:
                        return blockState.setValue(SHAPE, RailShape.ASCENDING_WEST);
                    case ASCENDING_WEST:
                        return blockState.setValue(SHAPE, RailShape.ASCENDING_EAST);
                    case ASCENDING_NORTH:
                    case ASCENDING_SOUTH:
                    default:
                        break;
                    case SOUTH_EAST:
                        return blockState.setValue(SHAPE, RailShape.SOUTH_WEST);
                    case SOUTH_WEST:
                        return blockState.setValue(SHAPE, RailShape.SOUTH_EAST);
                    case NORTH_WEST:
                        return blockState.setValue(SHAPE, RailShape.NORTH_EAST);
                    case NORTH_EAST:
                        return blockState.setValue(SHAPE, RailShape.NORTH_WEST);
                }
        }

        return super.mirror(blockState, mirror);
    }

    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    public boolean isUnderWater(BlockState state) {
        return state.getValue(WATERLOGGED);
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(SHAPE, WATERLOGGED);
    }
}
