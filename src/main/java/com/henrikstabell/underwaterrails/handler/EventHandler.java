package com.henrikstabell.underwaterrails.handler;

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

@Mod.EventBusSubscriber(modid = UnderwaterRails.MODID)
public class EventHandler {

    @SubscribeEvent
    public static void onMinecartDrownDamage(LivingHurtEvent event) {
        if (event.getSource() == DamageSource.DROWN)
            if (event.getEntityLiving().getRootVehicle() instanceof Minecart)
                if (event.getEntityLiving().getCommandSenderWorld().getBlockState(((Minecart) event.getEntityLiving().getRootVehicle()).getCurrentRailPosition()).getBlock() instanceof IUnderwaterRail)
                    if (((IUnderwaterRail) event.getEntityLiving().getCommandSenderWorld().getBlockState(((Minecart) event.getEntityLiving().getRootVehicle()).getCurrentRailPosition()).getBlock()).waterBreathingWhenOnRail()) {
                        event.getEntity().setAirSupply(300);
                        event.setCanceled(true);
                    }
    }
    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void onRenderFogUnderwater(EntityViewRenderEvent.FogDensity event) {
        if (event.getCamera().getFluidInCamera() == FogType.WATER)
            if (event.getCamera().getEntity().getRootVehicle() instanceof Minecart)
                if (event.getCamera().getEntity().getCommandSenderWorld().getBlockState(((Minecart) event.getCamera().getEntity().getRootVehicle()).getCurrentRailPosition()).getBlock() instanceof IUnderwaterRail)
                    if (((IUnderwaterRail) event.getCamera().getEntity().getCommandSenderWorld().getBlockState(((Minecart) event.getCamera().getEntity().getRootVehicle()).getCurrentRailPosition()).getBlock()).waterBreathingWhenOnRail()) {
                        //GL11.glFogf(GL11.GL_FOG_DENSITY, 0.00025f); No longer works...
                        event.setDensity(350.0f);
                        event.setCanceled(true);
                    }
    }

    @OnlyIn(Dist.CLIENT)
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
