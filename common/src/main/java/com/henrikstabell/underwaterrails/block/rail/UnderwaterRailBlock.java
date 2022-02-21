package com.henrikstabell.underwaterrails.block.rail;

import com.henrikstabell.underwaterrails.block.rail.api.IUnderwaterRail;
import net.minecraft.world.level.block.LiquidBlockContainer;
import net.minecraft.world.level.block.RailBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.RailShape;

public class UnderwaterRailBlock extends RailBlock implements LiquidBlockContainer, IUnderwaterRail {

    private static final EnumProperty<RailShape> SHAPE = BlockStateProperties.RAIL_SHAPE;

    public UnderwaterRailBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(SHAPE, RailShape.NORTH_SOUTH).setValue(WATERLOGGED, Boolean.valueOf(false)));
    }

    @Override
    public boolean waterBreathingWhenOnRail() {
        return true;
    }
}
