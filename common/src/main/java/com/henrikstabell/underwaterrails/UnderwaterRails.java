package com.henrikstabell.underwaterrails;

import com.google.common.base.Suppliers;
import com.henrikstabell.underwaterrails.block.rail.UnderwaterDetectorRailBlock;
import com.henrikstabell.underwaterrails.block.rail.UnderwaterPoweredRailBlock;
import com.henrikstabell.underwaterrails.block.rail.UnderwaterRailBlock;
import com.henrikstabell.underwaterrails.block.rail.api.IUnderwaterRail;
import com.henrikstabell.underwaterrails.handler.EventHandler;
import dev.architectury.event.EventResult;
import dev.architectury.event.events.common.EntityEvent;
import dev.architectury.event.events.common.PlayerEvent;
import dev.architectury.registry.block.BlockProperties;
import dev.architectury.registry.client.rendering.RenderTypeRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.Registries;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.vehicle.Minecart;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Supplier;

public class UnderwaterRails {
    public static final String MODID = "underwaterrails";

    public static final Supplier<Registries> REGISTRIES = Suppliers.memoize(() -> Registries.get(MODID));

    public static final Logger LOGGER = LogManager.getLogger();

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(MODID, Registry.BLOCK_REGISTRY);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(MODID, Registry.ITEM_REGISTRY);

    // Blocks
    public static final RegistrySupplier<Block> UNDERWATER_RAIL = BLOCKS.register("underwater_rail", () ->
            new UnderwaterRailBlock(BlockProperties.of(Material.HEAVY_METAL, MaterialColor.NONE).noCollission().strength(0.5F).sound(SoundType.GLASS)));
    public static final RegistrySupplier<Block> POWERED_UNDERWATER_RAIL = BLOCKS.register("powered_underwater_rail", () ->
            new UnderwaterPoweredRailBlock(BlockProperties.of(Material.HEAVY_METAL, MaterialColor.NONE).noCollission().strength(0.5F).sound(SoundType.GLASS), true));
    public static final RegistrySupplier<Block> DETECTOR_UNDERWATER_RAIL = BLOCKS.register("detector_underwater_rail", () ->
            new UnderwaterDetectorRailBlock(BlockProperties.of(Material.HEAVY_METAL, MaterialColor.NONE).noCollission().strength(0.5F).sound(SoundType.GLASS)));
    public static final RegistrySupplier<Block> ACTIVATOR_UNDERWATER_RAIL = BLOCKS.register("activator_underwater_rail", () ->
            new UnderwaterPoweredRailBlock(BlockProperties.of(Material.HEAVY_METAL, MaterialColor.NONE).noCollission().strength(0.5F).sound(SoundType.GLASS), false));

    // Items
    public static final RegistrySupplier<Item> UNDERWATER_RAIL_ITEM = ITEMS.register("underwater_rail", () ->
            new BlockItem(UNDERWATER_RAIL.get(), new Item.Properties().tab(CreativeModeTab.TAB_TRANSPORTATION)));
    public static final RegistrySupplier<Item> POWERED_UNDERWATER_RAIL_ITEM = ITEMS.register("powered_underwater_rail", () ->
            new BlockItem(POWERED_UNDERWATER_RAIL.get(), new Item.Properties().tab(CreativeModeTab.TAB_TRANSPORTATION)));
    public static final RegistrySupplier<Item> DETECTOR_UNDERWATER_RAIL_ITEM = ITEMS.register("detector_underwater_rail", () ->
            new BlockItem(DETECTOR_UNDERWATER_RAIL.get(), new Item.Properties().tab(CreativeModeTab.TAB_TRANSPORTATION)));
    public static final RegistrySupplier<Item> ACTIVATOR_UNDERWATER_RAIL_ITEM = ITEMS.register("activator_underwater_rail", () ->
            new BlockItem(ACTIVATOR_UNDERWATER_RAIL.get(), new Item.Properties().tab(CreativeModeTab.TAB_TRANSPORTATION)));

    public static void init() {
        BLOCKS.register();
        ITEMS.register();

        EventHandler.initEvents();
    }

    public static void clientInit() {
        RenderTypeRegistry.register(RenderType.cutoutMipped(), UNDERWATER_RAIL.get(), POWERED_UNDERWATER_RAIL.get(), DETECTOR_UNDERWATER_RAIL.get(), ACTIVATOR_UNDERWATER_RAIL.get());
    }
}
