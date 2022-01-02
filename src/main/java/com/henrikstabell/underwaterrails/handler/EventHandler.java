package com.henrikstabell.underwaterrails.handler;

import com.henrikstabell.underwaterrails.UnderwaterRails;
import com.henrikstabell.underwaterrails.block.rail.IUnderwaterRail;
import net.minecraft.entity.item.minecart.MinecartEntity;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.DamageSource;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.opengl.GL11;

@Mod.EventBusSubscriber(modid = UnderwaterRails.MODID)
public class EventHandler {

    @SubscribeEvent
    public static void onMinecartDrownDamage(LivingHurtEvent event) {
        if (event.getSource() == DamageSource.DROWN)
            if (event.getEntityLiving().getRootVehicle() instanceof MinecartEntity)
                if (event.getEntityLiving().getCommandSenderWorld().getBlockState(((MinecartEntity) event.getEntityLiving().getRootVehicle()).getCurrentRailPosition()).getBlock() instanceof IUnderwaterRail)
                    if (((IUnderwaterRail) event.getEntityLiving().getCommandSenderWorld().getBlockState(((MinecartEntity) event.getEntityLiving().getRootVehicle()).getCurrentRailPosition()).getBlock()).waterBreathingWhenOnRail()) {
                        event.getEntity().setAirSupply(300);
                        event.setCanceled(true);
                    }
    }
    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void onRenderFogUnderwater(EntityViewRenderEvent.FogDensity event) {
        if (event.getInfo().getFluidInCamera().is(FluidTags.WATER))
            if (event.getInfo().getEntity().getRootVehicle() instanceof MinecartEntity)
                if (event.getInfo().getEntity().getCommandSenderWorld().getBlockState(((MinecartEntity) event.getInfo().getEntity().getRootVehicle()).getCurrentRailPosition()).getBlock() instanceof IUnderwaterRail)
                    if (((IUnderwaterRail) event.getInfo().getEntity().getCommandSenderWorld().getBlockState(((MinecartEntity) event.getInfo().getEntity().getRootVehicle()).getCurrentRailPosition()).getBlock()).waterBreathingWhenOnRail()) {
                        GL11.glFogf(GL11.GL_FOG_DENSITY, 0.00025f);
                        event.setCanceled(true);
                    }
    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void onRenderFogColorUnderwater(EntityViewRenderEvent.FogColors event) {
        if (event.getInfo().getFluidInCamera().is(FluidTags.WATER))
            if (event.getInfo().getEntity().getRootVehicle() instanceof MinecartEntity)
                if (event.getInfo().getEntity().getCommandSenderWorld().getBlockState(((MinecartEntity) event.getInfo().getEntity().getRootVehicle()).getCurrentRailPosition()).getBlock() instanceof IUnderwaterRail)
                    if (((IUnderwaterRail) event.getInfo().getEntity().getCommandSenderWorld().getBlockState(((MinecartEntity) event.getInfo().getEntity().getRootVehicle()).getCurrentRailPosition()).getBlock()).waterBreathingWhenOnRail()) {
                        event.setBlue(0);
                        event.setRed(0);
                        event.setGreen(0);
                    }
    }
}
