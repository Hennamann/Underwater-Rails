package com.henrikstabell.underwaterrails;

import com.henrikstabell.underwaterrails.block.rail.BlockAdvancedUnderwaterRail;
import com.henrikstabell.underwaterrails.block.rail.BlockBasicUnderwaterRail;
import com.henrikstabell.underwaterrails.proxy.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import org.apache.logging.log4j.Logger;

/**
 * See The repos LICENSE.MD file for what you can and can't do with the code.
 * Created by Hennamann(Ole Henrik Stabell) on 30/03/2018.
 */
@Mod(modid = UnderwaterRails.MODID, name = UnderwaterRails.NAME, version = UnderwaterRails.VERSION)
@Mod.EventBusSubscriber
public class UnderwaterRails
{
    public static final String MODID = "underwaterrails";
    public static final String NAME = "Underwater Rails";
    public static final String VERSION = "1.0.0";

    public static Logger logger;

    public static final Block BLOCK_BASIC_UNDERWATER_RAIL = new BlockBasicUnderwaterRail();
    public static final Block BLOCK_ADVANCED_UNDERWATER_RAIL = new BlockAdvancedUnderwaterRail();

    @Mod.Instance(MODID)
    public static UnderwaterRails INSTANCE;

    @SidedProxy(clientSide = "com.henrikstabell.underwaterrails.proxy.ClientProxy", serverSide = "com.henrikstabell.underwaterrails.proxy.CommonProxy")
    public static CommonProxy proxy;


    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {}

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {}

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event)
    {
        event.getRegistry().register(BLOCK_BASIC_UNDERWATER_RAIL);
        event.getRegistry().register(BLOCK_ADVANCED_UNDERWATER_RAIL);
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        event.getRegistry().register(new ItemBlock(BLOCK_BASIC_UNDERWATER_RAIL).setRegistryName(BLOCK_BASIC_UNDERWATER_RAIL.getRegistryName()));
        event.getRegistry().register(new ItemBlock(BLOCK_ADVANCED_UNDERWATER_RAIL).setRegistryName(BLOCK_ADVANCED_UNDERWATER_RAIL.getRegistryName()));
    }

    @SubscribeEvent
    public static void registerAllModels(ModelRegistryEvent event)
    {
        proxy.doModelLoading();
    }
}
