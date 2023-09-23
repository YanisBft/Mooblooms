package com.yanisbft.mooblooms.data;

import com.yanisbft.mooblooms.api.AbstractMoobloom;
import com.yanisbft.mooblooms.init.MoobloomsEntities;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;

import java.util.concurrent.CompletableFuture;

public class MoobloomsBiomeTagProvider extends FabricTagProvider<Biome> {

    public MoobloomsBiomeTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, RegistryKeys.BIOME, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup registries) {
        this.getOrCreateTagBuilder(getTag(MoobloomsEntities.DANDELION_MOOBLOOM)).add(BiomeKeys.FLOWER_FOREST);
        this.getOrCreateTagBuilder(getTag(MoobloomsEntities.POPPY_MOOBLOOM)).add(BiomeKeys.FLOWER_FOREST);
        this.getOrCreateTagBuilder(getTag(MoobloomsEntities.BLUE_ORCHID_MOOBLOOM)).add(BiomeKeys.FLOWER_FOREST, BiomeKeys.SWAMP);
        this.getOrCreateTagBuilder(getTag(MoobloomsEntities.ALLIUM_MOOBLOOM)).add(BiomeKeys.FLOWER_FOREST);
        this.getOrCreateTagBuilder(getTag(MoobloomsEntities.OXEYE_DAISY_MOOBLOOM)).add(BiomeKeys.FLOWER_FOREST);
        this.getOrCreateTagBuilder(getTag(MoobloomsEntities.CORNFLOWER_MOOBLOOM)).add(BiomeKeys.FLOWER_FOREST);
        this.getOrCreateTagBuilder(getTag(MoobloomsEntities.WITHER_ROSE_MOOBLOOM)).add(BiomeKeys.NETHER_WASTES, BiomeKeys.SOUL_SAND_VALLEY, BiomeKeys.BASALT_DELTAS);
        this.getOrCreateTagBuilder(getTag(MoobloomsEntities.SUNCOWER)).add(BiomeKeys.SUNFLOWER_PLAINS);
        this.getOrCreateTagBuilder(getTag(MoobloomsEntities.BAMBMOO)).add(BiomeKeys.BAMBOO_JUNGLE);
        this.getOrCreateTagBuilder(getTag(MoobloomsEntities.COWCTUS)).add(BiomeKeys.BADLANDS);
        this.getOrCreateTagBuilder(getTag(MoobloomsEntities.AZALEA_MOOBLOOM)).add(BiomeKeys.LUSH_CAVES);
        this.getOrCreateTagBuilder(getTag(MoobloomsEntities.DRIPLEAF_MOOBLOOM)).add(BiomeKeys.LUSH_CAVES);
        this.getOrCreateTagBuilder(getTag(MoobloomsEntities.CHORUS_MOOBLOOM)).add(BiomeKeys.END_HIGHLANDS, BiomeKeys.END_MIDLANDS, BiomeKeys.SMALL_END_ISLANDS, BiomeKeys.END_BARRENS);

        this.getOrCreateTagBuilder(getTag(MoobloomsEntities.CRIMSON_MOOSHROOM)).add(BiomeKeys.CRIMSON_FOREST);
        this.getOrCreateTagBuilder(getTag(MoobloomsEntities.WARPED_MOOSHROOM)).add(BiomeKeys.WARPED_FOREST);

        this.getOrCreateTagBuilder(getTag(MoobloomsEntities.RED_CLUCKSHROOM)).add(BiomeKeys.MUSHROOM_FIELDS);
        this.getOrCreateTagBuilder(getTag(MoobloomsEntities.BROWN_CLUCKSHROOM)).add(BiomeKeys.MUSHROOM_FIELDS);
        this.getOrCreateTagBuilder(getTag(MoobloomsEntities.CRIMSON_CLUCKSHROOM)).add(BiomeKeys.CRIMSON_FOREST);
        this.getOrCreateTagBuilder(getTag(MoobloomsEntities.WARPED_CLUCKSHROOM)).add(BiomeKeys.WARPED_FOREST);
    }

    private TagKey<Biome> getTag(AbstractMoobloom moobloom) {
        String tagName = "spawns_" + moobloom.getName().getPath();
        return TagKey.of(RegistryKeys.BIOME, Identifier.of(moobloom.getName().getNamespace(), tagName));
    }
}
