package com.henrikstabell.underwaterrails.fabric;

import com.henrikstabell.underwaterrails.UnderwaterRails;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;

public class UnderwaterRailsFabricClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        UnderwaterRails.clientInit();
    }
}
