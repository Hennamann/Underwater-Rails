package com.henrikstabell.underwaterrails;

import com.henrikstabell.underwaterrails.block.rail.BlockAdvancedUnderwaterRail;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.entity.item.minecart.MinecartEntity;
import net.minecraft.util.DamageSource;
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
        if (event.getSource() == DamageSource.DROWN && event.getEntityLiving().getRootVehicle() instanceof MinecartEntity && event.getEntityLiving().getCommandSenderWorld().getBlockState(((MinecartEntity) event.getEntityLiving().getRootVehicle()).getCurrentRailPosition()).getBlock() instanceof BlockAdvancedUnderwaterRail) {
            event.getEntity().setAirSupply(300);
            event.setCanceled(true);
        }
    }

    //@SubscribeEvent
    //public static void onMinecartUnderwater(TickEvent.PlayerTickEvent event) {
    //    if (event.player.getCommandSenderWorld().isClientSide && event.player.isPassenger() && event.player.getRootVehicle() instanceof MinecartEntity && event.player.getCommandSenderWorld().getBlockState(((MinecartEntity) event.player.getRootVehicle()).getCurrentRailPosition()).getBlock() instanceof BlockAdvancedUnderwaterRail) {
    //        event.player.addEffect(new EffectInstance(Effects.NIGHT_VISION, 110, 10, false, false, false));
    //    }
    //}

    //@OnlyIn(Dist.CLIENT)
    //@SubscribeEvent
    //public static void onMinecartUnderwater(TickEvent.PlayerTickEvent event) {
    //    if (event.player.getRootVehicle() instanceof MinecartEntity && event.player.getCommandSenderWorld().getBlockState(((MinecartEntity) event.player.getRootVehicle()).getCurrentRailPosition()).getBlock() instanceof BlockAdvancedUnderwaterRail) {
    //        Minecraft.getInstance().gameRenderer.
    //    }
    //}

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public void onRenderFog(EntityViewRenderEvent.FogDensity event) {
        if (event.getInfo().getEntity().getRootVehicle() instanceof MinecartEntity && event.getInfo().getEntity().getCommandSenderWorld().getBlockState(((MinecartEntity) event.getInfo().getEntity().getRootVehicle()).getCurrentRailPosition()).getBlock() instanceof BlockAdvancedUnderwaterRail) {
            RenderSystem.fogMode(GlStateManager.FogMode.EXP);
            event.setDensity(0.0025F);
            event.setCanceled(true);
        }
    }
}
