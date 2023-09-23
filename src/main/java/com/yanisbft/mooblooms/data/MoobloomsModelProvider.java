package com.yanisbft.mooblooms.data;

import com.yanisbft.mooblooms.api.Cluckshroom;
import com.yanisbft.mooblooms.api.Moobloom;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.util.Identifier;

import java.util.Optional;

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
        Identifier parent = new Identifier("minecraft", "item/template_spawn_egg");

        for (Moobloom moobloom : Moobloom.MOOBLOOM_BY_TYPE.values()) {
            itemModelGenerator.register(moobloom.getSpawnEgg(), new Model(Optional.of(parent), Optional.empty()));
        }

        for (Cluckshroom cluckshroom : Cluckshroom.CLUCKSHROOM_BY_TYPE.values()) {
            itemModelGenerator.register(cluckshroom.getSpawnEgg(), new Model(Optional.of(parent), Optional.empty()));
        }
    }
}
