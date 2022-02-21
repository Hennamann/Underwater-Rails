package com.henrikstabell.underwaterrails.fabric;

import com.henrikstabell.underwaterrails.UnderwaterRails;
import net.fabricmc.api.ModInitializer;

public class UnderwaterRailsFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        UnderwaterRails.init();
    }
}
