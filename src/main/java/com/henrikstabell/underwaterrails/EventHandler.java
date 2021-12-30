package com.henrikstabell.underwaterrails;

import com.henrikstabell.underwaterrails.block.rail.BlockAdvancedUnderwaterRail;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.entity.item.minecart.MinecartEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.TickEvent;
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

    @SubscribeEvent
    public static void onMinecartUnderwater(TickEvent.PlayerTickEvent event) {
        if (event.player.getCommandSenderWorld().isClientSide && event.player.isPassenger() && event.player.getRootVehicle() instanceof MinecartEntity && event.player.getCommandSenderWorld().getBlockState(((MinecartEntity) event.player.getRootVehicle()).getCurrentRailPosition()).getBlock() instanceof BlockAdvancedUnderwaterRail) {
            event.player.addEffect(new EffectInstance(Effects.NIGHT_VISION, 110, 10, false, false, false));
        }
    }
}
