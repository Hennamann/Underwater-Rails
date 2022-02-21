package com.henrikstabell.underwaterrails.forge;

import dev.architectury.platform.forge.EventBuses;
import com.henrikstabell.underwaterrails.UnderwaterRails;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(UnderwaterRails.MODID)
@Mod.EventBusSubscriber(modid = UnderwaterRails.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class UnderwaterRailsForge {
    public UnderwaterRailsForge() {
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(UnderwaterRails.MODID, FMLJavaModLoadingContext.get().getModEventBus());
        UnderwaterRails.init();
    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void onClientSetupEvent(FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(UnderwaterRails.UNDERWATER_RAIL.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(UnderwaterRails.POWERED_UNDERWATER_RAIL.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(UnderwaterRails.DETECTOR_UNDERWATER_RAIL.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(UnderwaterRails.ACTIVATOR_UNDERWATER_RAIL.get(), RenderType.cutoutMipped());
    }
}
