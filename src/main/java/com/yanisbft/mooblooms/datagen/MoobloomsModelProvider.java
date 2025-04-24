package com.yanisbft.mooblooms.datagen;

import com.yanisbft.mooblooms.Mooblooms;
import com.yanisbft.mooblooms.api.Cluckshroom;
import com.yanisbft.mooblooms.api.Moobloom;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.*;
import net.minecraft.item.Item;
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
        generateSpawnEggTemplate(itemModelGenerator);

        for (Moobloom moobloom : Moobloom.MOOBLOOM_BY_TYPE.values()) {
            registerSpawnEgg(itemModelGenerator, moobloom.getSpawnEgg(), moobloom.getPrimarySpawnEggColor(), moobloom.getSecondarySpawnEggColor());
        }

        for (Cluckshroom cluckshroom : Cluckshroom.CLUCKSHROOM_BY_TYPE.values()) {
            registerSpawnEgg(itemModelGenerator, cluckshroom.getSpawnEgg(), cluckshroom.getPrimarySpawnEggColor(), cluckshroom.getSecondarySpawnEggColor());
        }
    }

    private static void generateSpawnEggTemplate(ItemModelGenerator itemModelGenerator) {
        Models.GENERATED_TWO_LAYERS.upload(
                Mooblooms.id("item/template_spawn_egg"),
                TextureMap.layered(Mooblooms.id("item/spawn_egg"), Mooblooms.id("item/spawn_egg_overlay")),
                itemModelGenerator.modelCollector
        );
    }

    private static void registerSpawnEgg(ItemModelGenerator generator, Item item, int primaryColor, int secondaryColor) {
        Identifier identifier = generator.upload(item, new Model(Optional.of(Mooblooms.id("item/template_spawn_egg")), Optional.empty()));
        generator.output.accept(item, ItemModels.tinted(identifier, ItemModels.constantTintSource(primaryColor), ItemModels.constantTintSource(secondaryColor)));
    }
}
