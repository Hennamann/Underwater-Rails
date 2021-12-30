package com.henrikstabell.underwaterrails.block.rail;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
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
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

/**
 * See The repos LICENSE.MD file for what you can and can't do with the code.
 * Created by Hennamann(Ole Henrik Stabell) on 30/03/2018.
 */
public class BlockAdvancedUnderwaterRail extends AbstractRailBlock {

    private static final EnumProperty<RailShape> SHAPE = BlockStateProperties.RAIL_SHAPE;

    protected static final VoxelShape CUSTOM_FLAT_AABB = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0F, 16.0D);
    protected static final VoxelShape CUSTOM_HALF_BLOCK_AABB = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0F, 16.0D);

    public BlockAdvancedUnderwaterRail(Properties properties) {
        super(false, properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(SHAPE, RailShape.NORTH_SOUTH));
    }

    @Override
    public VoxelShape getShape(BlockState blockState, IBlockReader blockReader, BlockPos blockPos, ISelectionContext selectionContext) {
        RailShape railshape = blockState.is(this) ? blockState.getValue(this.getShapeProperty()) : null;
        RailShape railShape2 = blockState.is(this) ? getRailDirection(blockState, blockReader, blockPos, null) : null;
        return railshape != null && railshape.isAscending() ? CUSTOM_HALF_BLOCK_AABB : CUSTOM_FLAT_AABB;
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

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(SHAPE);
    }
}
