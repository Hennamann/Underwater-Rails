package com.henrikstabell.underwaterrails.block.rail;

import com.henrikstabell.underwaterrails.block.rail.api.IUnderwaterRail;
import net.minecraft.world.level.block.LiquidBlockContainer;
import net.minecraft.world.level.block.PoweredRailBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.RailShape;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;

public class UnderwaterPoweredRailBlock extends PoweredRailBlock implements LiquidBlockContainer, IUnderwaterRail {

    public static final EnumProperty<RailShape> SHAPE = BlockStateProperties.RAIL_SHAPE_STRAIGHT;
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
    private final boolean isActivator;

    public UnderwaterPoweredRailBlock(BlockBehaviour.Properties properties) {
        this(properties, false);
    }

    public UnderwaterPoweredRailBlock(BlockBehaviour.Properties properties, boolean isPoweredRail) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(SHAPE, RailShape.NORTH_SOUTH).setValue(POWERED, Boolean.valueOf(false)).setValue(WATERLOGGED, Boolean.valueOf(false)));
        this.isActivator = !isPoweredRail;
    }

    public boolean isActivatorRail() {
        return isActivator;
    }

    @Override
    public boolean waterBreathingWhenOnRail() {
        return true;
    }
}
