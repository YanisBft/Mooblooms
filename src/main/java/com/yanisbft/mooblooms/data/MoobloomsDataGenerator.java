package com.yanisbft.mooblooms.data;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class MoobloomsDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator dataGenerator) {
        FabricDataGenerator.Pack pack = dataGenerator.createPack();

        // assets
        pack.addProvider(MoobloomsModelProvider::new);

        // data
        pack.addProvider(MoobloomsEntityTypeTagProvider::new);
        pack.addProvider(MoobloomsBiomeTagProvider::new);
    }
}
