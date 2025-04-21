package com.yanisbft.mooblooms.datagen;

import com.yanisbft.mooblooms.api.Cluckshroom;
import com.yanisbft.mooblooms.api.Moobloom;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;

public class MoobloomsModelProvider extends FabricModelProvider {

    public MoobloomsModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        // not used
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        for (Moobloom moobloom : Moobloom.MOOBLOOM_BY_TYPE.values()) {
            itemModelGenerator.registerSpawnEgg(moobloom.getSpawnEgg(), moobloom.getPrimarySpawnEggColor(), moobloom.getSecondarySpawnEggColor());
        }

        for (Cluckshroom cluckshroom : Cluckshroom.CLUCKSHROOM_BY_TYPE.values()) {
            itemModelGenerator.registerSpawnEgg(cluckshroom.getSpawnEgg(), cluckshroom.getPrimarySpawnEggColor(), cluckshroom.getSecondarySpawnEggColor());
        }
    }
}
