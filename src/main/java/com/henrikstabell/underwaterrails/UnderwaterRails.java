package com.henrikstabell.underwaterrails;

import com.henrikstabell.underwaterrails.block.rail.UnderwaterDetectorRailBlock;
import com.henrikstabell.underwaterrails.block.rail.UnderwaterPoweredRailBlock;
import com.henrikstabell.underwaterrails.block.rail.UnderwaterRailBlock;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
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
    public static final String VERSION = "2.2.0";

    public static final Logger LOGGER = LogManager.getLogger();

    /**
     * BLOCKS
     */
    public static Block UNDERWATER_RAIL_BLOCK;
    public static Block UNDERWATER_POWERED_RAIL_BLOCK;
    public static Block UNDERWATER_DETECTOR_RAIL_BLOCK;
    public static Block UNDERWATER_ACTIVATOR_RAIL_BLOCK;

    /**
     * ITEMS
     */
    public static BlockItem UNDERWATER_RAIL_ITEM;
    public static BlockItem UNDERWATER_POWERED_RAIL_ITEM;
    public static BlockItem UNDERWATER_DETECTOR_RAIL_ITEM;
    public static BlockItem UNDERWATER_ACTIVATOR_RAIL_ITEM;

    @SubscribeEvent
    public static void onBlocksRegistration(final RegistryEvent.Register<Block> blockRegisterEvent) {

        UNDERWATER_RAIL_BLOCK = (UnderwaterRailBlock)(new UnderwaterRailBlock(BlockBehaviour.Properties.of(Material.HEAVY_METAL, MaterialColor.NONE).noCollission().strength(0.5F).sound(SoundType.GLASS)).setRegistryName(MODID, "underwater_rail"));
        blockRegisterEvent.getRegistry().register(UNDERWATER_RAIL_BLOCK);

        UNDERWATER_POWERED_RAIL_BLOCK = (UnderwaterPoweredRailBlock)(new UnderwaterPoweredRailBlock(BlockBehaviour.Properties.of(Material.HEAVY_METAL, MaterialColor.NONE).noCollission().strength(0.5F).sound(SoundType.GLASS), true).setRegistryName(MODID, "powered_underwater_rail"));
        blockRegisterEvent.getRegistry().register(UNDERWATER_POWERED_RAIL_BLOCK);

        UNDERWATER_DETECTOR_RAIL_BLOCK = (UnderwaterDetectorRailBlock)(new UnderwaterDetectorRailBlock(BlockBehaviour.Properties.of(Material.HEAVY_METAL, MaterialColor.NONE).noCollission().strength(0.5F).sound(SoundType.GLASS)).setRegistryName(MODID, "detector_underwater_rail"));
        blockRegisterEvent.getRegistry().register(UNDERWATER_DETECTOR_RAIL_BLOCK);

        UNDERWATER_ACTIVATOR_RAIL_BLOCK = (UnderwaterPoweredRailBlock)(new UnderwaterPoweredRailBlock(BlockBehaviour.Properties.of(Material.HEAVY_METAL, MaterialColor.NONE).noCollission().strength(0.5F).sound(SoundType.GLASS)).setRegistryName(MODID, "activator_underwater_rail"));
        blockRegisterEvent.getRegistry().register(UNDERWATER_ACTIVATOR_RAIL_BLOCK);
    }

    @SubscribeEvent
    public static void onItemsRegistration(final RegistryEvent.Register<Item> itemRegisterEvent) {
        Item.Properties ITEM_RAIL_PROP = new Item.Properties().tab(CreativeModeTab.TAB_TRANSPORTATION);

        UNDERWATER_RAIL_ITEM = new BlockItem(UNDERWATER_RAIL_BLOCK, ITEM_RAIL_PROP);
        UNDERWATER_RAIL_ITEM.setRegistryName(MODID, "underwater_rail");
        itemRegisterEvent.getRegistry().register(UNDERWATER_RAIL_ITEM);

        UNDERWATER_POWERED_RAIL_ITEM = new BlockItem(UNDERWATER_POWERED_RAIL_BLOCK, ITEM_RAIL_PROP);
        UNDERWATER_POWERED_RAIL_ITEM.setRegistryName(MODID, "powered_underwater_rail");
        itemRegisterEvent.getRegistry().register(UNDERWATER_POWERED_RAIL_ITEM);

        UNDERWATER_DETECTOR_RAIL_ITEM = new BlockItem(UNDERWATER_DETECTOR_RAIL_BLOCK, ITEM_RAIL_PROP);
        UNDERWATER_DETECTOR_RAIL_ITEM.setRegistryName(MODID, "detector_underwater_rail");
        itemRegisterEvent.getRegistry().register(UNDERWATER_DETECTOR_RAIL_ITEM);

        UNDERWATER_ACTIVATOR_RAIL_ITEM = new BlockItem(UNDERWATER_ACTIVATOR_RAIL_BLOCK, ITEM_RAIL_PROP);
        UNDERWATER_ACTIVATOR_RAIL_ITEM.setRegistryName(MODID, "activator_underwater_rail");
        itemRegisterEvent.getRegistry().register(UNDERWATER_ACTIVATOR_RAIL_ITEM);
    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public static void onClientSetupEvent(FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(UnderwaterRails.UNDERWATER_RAIL_BLOCK, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(UnderwaterRails.UNDERWATER_POWERED_RAIL_BLOCK, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(UnderwaterRails.UNDERWATER_DETECTOR_RAIL_BLOCK, RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(UnderwaterRails.UNDERWATER_ACTIVATOR_RAIL_BLOCK, RenderType.cutoutMipped());
    }
}
