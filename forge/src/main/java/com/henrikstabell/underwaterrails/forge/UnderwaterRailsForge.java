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
@Mod.EventBusSubscriber(modid = UnderwaterRails.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class UnderwaterRailsForge {
    public UnderwaterRailsForge() {
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(UnderwaterRails.MODID, FMLJavaModLoadingContext.get().getModEventBus());
        UnderwaterRails.init();
    }

    @SubscribeEvent
    public static void onClientSetupEvent(FMLClientSetupEvent event) {
        UnderwaterRails.clientInit();
    }
}
