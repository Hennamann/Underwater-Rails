package com.henrikstabell.underwaterrails;

import com.henrikstabell.underwaterrails.block.rail.BlockAdvancedUnderwaterRail;
import com.henrikstabell.underwaterrails.block.rail.BlockBasicPoweredUnderwaterRail;
import com.henrikstabell.underwaterrails.block.rail.BlockBasicUnderwaterRail;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.entity.item.minecart.MinecartEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * See The repos LICENSE.MD file for what you can and can't do with the code.
 * Created by Hennamann(Ole Henrik Stabell) on 30/03/2018.
 */
@Mod(UnderwaterRails.MODID)
@Mod.EventBusSubscriber(modid = UnderwaterRails.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class UnderwaterRails
{
    public static final String MODID = "underwaterrails";
    public static final String NAME = "Underwater Rails";
    public static final String VERSION = "1.0.0";

    private static final Logger LOGGER = LogManager.getLogger();

    public static Block BLOCK_BASIC_UNDERWATER_RAIL;
    public static Block BLOCK_ADVANCED_UNDERWATER_RAIL;
    public static Block BLOCK_BASIC_POWERED_UNDERWATER_RAIL;

    public static BlockItem ITEM_BASIC_UNDERWATER_RAIL;
    public static BlockItem ITEM_ADVANCED_UNDERWATER_RAIL;
    public static BlockItem ITEM_BASIC_POWERED_UNDERWATER_RAIL;

    @SubscribeEvent
    public static void onBlocksRegistration(final RegistryEvent.Register<Block> blockRegisterEvent) {
        BLOCK_BASIC_UNDERWATER_RAIL = (BlockBasicUnderwaterRail)(new BlockBasicUnderwaterRail(AbstractBlock.Properties.of(Material.HEAVY_METAL, MaterialColor.NONE).noCollission().strength(0.7F).sound(SoundType.METAL)).setRegistryName(MODID, "basic_underwater_rail"));
        blockRegisterEvent.getRegistry().register(BLOCK_BASIC_UNDERWATER_RAIL);

        BLOCK_BASIC_POWERED_UNDERWATER_RAIL = (BlockBasicPoweredUnderwaterRail)(new BlockBasicPoweredUnderwaterRail(AbstractBlock.Properties.of(Material.HEAVY_METAL, MaterialColor.NONE).noCollission().strength(0.7F).sound(SoundType.METAL)).setRegistryName(MODID, "basic_powered_underwater_rail"));
        blockRegisterEvent.getRegistry().register(BLOCK_BASIC_POWERED_UNDERWATER_RAIL);

        BLOCK_ADVANCED_UNDERWATER_RAIL = (BlockAdvancedUnderwaterRail)(new BlockAdvancedUnderwaterRail(AbstractBlock.Properties.of(Material.HEAVY_METAL, MaterialColor.NONE).noCollission().strength(0.5F).sound(SoundType.METAL)).setRegistryName(MODID, "advanced_underwater_rail"));
        blockRegisterEvent.getRegistry().register(BLOCK_ADVANCED_UNDERWATER_RAIL);
    }

    @SubscribeEvent
    public static void onItemsRegistration(final RegistryEvent.Register<Item> itemRegisterEvent) {
        Item.Properties ITEM_BASIC_UNDERWATER_RAIL_PROPERTIES = new Item.Properties().tab(ItemGroup.TAB_TRANSPORTATION);
        ITEM_BASIC_UNDERWATER_RAIL = new BlockItem(BLOCK_BASIC_UNDERWATER_RAIL, ITEM_BASIC_UNDERWATER_RAIL_PROPERTIES);
        ITEM_BASIC_UNDERWATER_RAIL.setRegistryName(BLOCK_BASIC_UNDERWATER_RAIL.getRegistryName());
        itemRegisterEvent.getRegistry().register(ITEM_BASIC_UNDERWATER_RAIL);

        Item.Properties ITEM_BASIC_POWERED_UNDERWATER_RAIL_PROPERTIES = new Item.Properties().tab(ItemGroup.TAB_TRANSPORTATION);
        ITEM_BASIC_UNDERWATER_RAIL = new BlockItem(BLOCK_BASIC_POWERED_UNDERWATER_RAIL, ITEM_BASIC_POWERED_UNDERWATER_RAIL_PROPERTIES);
        ITEM_BASIC_POWERED_UNDERWATER_RAIL.setRegistryName(MODID, "basic_powered_underwater_rail");
        itemRegisterEvent.getRegistry().register(ITEM_BASIC_POWERED_UNDERWATER_RAIL);

        Item.Properties ITEM_ADVANCED_UNDERWATER_RAIL_PROPERTIES = new Item.Properties().tab(ItemGroup.TAB_TRANSPORTATION);
        ITEM_ADVANCED_UNDERWATER_RAIL = new BlockItem(BLOCK_ADVANCED_UNDERWATER_RAIL, ITEM_ADVANCED_UNDERWATER_RAIL_PROPERTIES);
        ITEM_ADVANCED_UNDERWATER_RAIL.setRegistryName(BLOCK_ADVANCED_UNDERWATER_RAIL.getRegistryName());
        itemRegisterEvent.getRegistry().register(ITEM_ADVANCED_UNDERWATER_RAIL);
    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void onClientSetupEvent(FMLClientSetupEvent event) {
        RenderTypeLookup.setRenderLayer(UnderwaterRails.BLOCK_BASIC_UNDERWATER_RAIL, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(UnderwaterRails.BLOCK_ADVANCED_UNDERWATER_RAIL, RenderType.cutout());
        RenderTypeLookup.setRenderLayer(UnderwaterRails.BLOCK_BASIC_POWERED_UNDERWATER_RAIL, RenderType.cutout());
    }
}
