package com.yanisbft.mooblooms.data;

import com.yanisbft.mooblooms.Mooblooms;
import com.yanisbft.mooblooms.api.AbstractMoobloom;
import com.yanisbft.mooblooms.api.Cluckshroom;
import com.yanisbft.mooblooms.api.Moobloom;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;

import java.util.Comparator;
import java.util.concurrent.CompletableFuture;

public class MoobloomsEntityTypeTagProvider extends FabricTagProvider.EntityTypeTagProvider {

    public MoobloomsEntityTypeTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup registries) {
        FabricTagBuilder moobloomsTag = this.getOrCreateTagBuilder(TagKey.of(RegistryKeys.ENTITY_TYPE, Mooblooms.id("mooblooms")));
        for (Moobloom moobloom : Moobloom.MOOBLOOM_BY_TYPE.values().stream().sorted(Comparator.comparing(AbstractMoobloom::getName)).toList()) {
            moobloomsTag.add(moobloom.getName());
        }

        FabricTagBuilder cluckshroomsTag = this.getOrCreateTagBuilder(TagKey.of(RegistryKeys.ENTITY_TYPE, Mooblooms.id("cluckshrooms")));
        for (Cluckshroom cluckshroom : Cluckshroom.CLUCKSHROOM_BY_TYPE.values().stream().sorted(Comparator.comparing(AbstractMoobloom::getName)).toList()) {
            cluckshroomsTag.add(cluckshroom.getName());
        }
    }
}
