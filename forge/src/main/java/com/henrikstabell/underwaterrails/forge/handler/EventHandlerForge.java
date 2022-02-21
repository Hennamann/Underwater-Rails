package com.henrikstabell.underwaterrails.forge.handler;

import com.henrikstabell.underwaterrails.UnderwaterRails;
import com.henrikstabell.underwaterrails.block.rail.api.IUnderwaterRail;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.vehicle.Minecart;
import net.minecraft.world.level.material.FogType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = UnderwaterRails.MODID, value = Dist.CLIENT)
public class EventHandlerForge {

        @SubscribeEvent
        public static void onRenderFogUnderwater(EntityViewRenderEvent.FogDensity event) {
            if (event.getCamera().getFluidInCamera() == FogType.WATER)
                if (event.getCamera().getEntity().getRootVehicle() instanceof Minecart)
                    if (event.getCamera().getEntity().getCommandSenderWorld().getBlockState(((Minecart) event.getCamera().getEntity().getRootVehicle()).getCurrentRailPosition()).getBlock() instanceof IUnderwaterRail)
                        if (((IUnderwaterRail) event.getCamera().getEntity().getCommandSenderWorld().getBlockState(((Minecart) event.getCamera().getEntity().getRootVehicle()).getCurrentRailPosition()).getBlock()).waterBreathingWhenOnRail()) {
                            event.setDensity(350.0f);
                            event.setCanceled(true);
                        }
        }

        @SubscribeEvent
        public static void onRenderFogColorUnderwater(EntityViewRenderEvent.FogColors event) {
            if (event.getCamera().getFluidInCamera() == FogType.WATER)
                if (event.getCamera().getEntity().getRootVehicle() instanceof Minecart)
                    if (event.getCamera().getEntity().getCommandSenderWorld().getBlockState(((Minecart) event.getCamera().getEntity().getRootVehicle()).getCurrentRailPosition()).getBlock() instanceof IUnderwaterRail)
                        if (((IUnderwaterRail) event.getCamera().getEntity().getCommandSenderWorld().getBlockState(((Minecart) event.getCamera().getEntity().getRootVehicle()).getCurrentRailPosition()).getBlock()).waterBreathingWhenOnRail()) {
                            event.setBlue(0);
                            event.setRed(0);
                            event.setGreen(0);
                        }
        }
}
