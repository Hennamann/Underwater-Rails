package com.henrikstabell.underwaterrails.proxy;

import com.henrikstabell.underwaterrails.UnderwaterRails;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

/**
 * See The repos LICENSE.MD file for what you can and can't do with the code.
 * Created by Hennamann(Ole Henrik Stabell) on 30/03/2018.
 */
public class ClientProxy extends CommonProxy {

    @Override
    public void doModelLoading() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(UnderwaterRails.UNDER_WATER_RAIL), 0, new ModelResourceLocation(UnderwaterRails.UNDER_WATER_RAIL.getRegistryName(), "inventory"));
    }
}
