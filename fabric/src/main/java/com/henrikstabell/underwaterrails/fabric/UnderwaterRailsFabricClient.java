package com.henrikstabell.underwaterrails.fabric;

import com.henrikstabell.underwaterrails.UnderwaterRails;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;

public class UnderwaterRailsFabricClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(UnderwaterRails.UNDERWATER_RAIL.get(), RenderType.cutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(UnderwaterRails.POWERED_UNDERWATER_RAIL.get(), RenderType.cutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(UnderwaterRails.ACTIVATOR_UNDERWATER_RAIL.get(), RenderType.cutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(UnderwaterRails.DETECTOR_UNDERWATER_RAIL.get(), RenderType.cutoutMipped());
    }
}
