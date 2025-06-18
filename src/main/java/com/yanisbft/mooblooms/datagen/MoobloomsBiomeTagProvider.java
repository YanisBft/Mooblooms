package com.yanisbft.mooblooms.datagen;

import com.yanisbft.mooblooms.api.AbstractMoobloom;
import com.yanisbft.mooblooms.init.MoobloomsEntities;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MoobloomsBiomeTagProvider extends FabricTagProvider<Biome> {

    public MoobloomsBiomeTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, RegistryKeys.BIOME, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup registries) {
        this.builder(getTag(MoobloomsEntities.DANDELION_MOOBLOOM)).add(BiomeKeys.FLOWER_FOREST);
        this.builder(getTag(MoobloomsEntities.POPPY_MOOBLOOM)).add(BiomeKeys.FLOWER_FOREST);
        this.builder(getTag(MoobloomsEntities.BLUE_ORCHID_MOOBLOOM)).add(List.of(BiomeKeys.FLOWER_FOREST, BiomeKeys.SWAMP));
        this.builder(getTag(MoobloomsEntities.ALLIUM_MOOBLOOM)).add(BiomeKeys.FLOWER_FOREST);
        this.builder(getTag(MoobloomsEntities.OXEYE_DAISY_MOOBLOOM)).add(BiomeKeys.FLOWER_FOREST);
        this.builder(getTag(MoobloomsEntities.CORNFLOWER_MOOBLOOM)).add(BiomeKeys.FLOWER_FOREST);
        this.builder(getTag(MoobloomsEntities.WITHER_ROSE_MOOBLOOM)).add(List.of(BiomeKeys.NETHER_WASTES, BiomeKeys.SOUL_SAND_VALLEY, BiomeKeys.BASALT_DELTAS));
        this.builder(getTag(MoobloomsEntities.SUNCOWER)).add(BiomeKeys.SUNFLOWER_PLAINS);
        this.builder(getTag(MoobloomsEntities.BAMBMOO)).add(BiomeKeys.BAMBOO_JUNGLE);
        this.builder(getTag(MoobloomsEntities.COWCTUS)).add(List.of(BiomeKeys.BADLANDS, BiomeKeys.WOODED_BADLANDS));
        this.builder(getTag(MoobloomsEntities.CHERRY_MOOBLOOM)).add(BiomeKeys.CHERRY_GROVE);
        this.builder(getTag(MoobloomsEntities.EYEBLOSSOM_MOOBLOOM)).add(BiomeKeys.PALE_GARDEN);
        this.builder(getTag(MoobloomsEntities.AZALEA_MOOBLOOM)).add(BiomeKeys.LUSH_CAVES);
        this.builder(getTag(MoobloomsEntities.DRIPLEAF_MOOBLOOM)).add(BiomeKeys.LUSH_CAVES);
        this.builder(getTag(MoobloomsEntities.CHORUS_MOOBLOOM)).add(List.of(BiomeKeys.END_HIGHLANDS, BiomeKeys.END_MIDLANDS, BiomeKeys.SMALL_END_ISLANDS, BiomeKeys.END_BARRENS));

        this.builder(getTag(MoobloomsEntities.CRIMSON_MOOSHROOM)).add(BiomeKeys.CRIMSON_FOREST);
        this.builder(getTag(MoobloomsEntities.WARPED_MOOSHROOM)).add(BiomeKeys.WARPED_FOREST);

        this.builder(getTag(MoobloomsEntities.RED_CLUCKSHROOM)).add(BiomeKeys.MUSHROOM_FIELDS);
        this.builder(getTag(MoobloomsEntities.BROWN_CLUCKSHROOM)).add(BiomeKeys.MUSHROOM_FIELDS);
        this.builder(getTag(MoobloomsEntities.CRIMSON_CLUCKSHROOM)).add(BiomeKeys.CRIMSON_FOREST);
        this.builder(getTag(MoobloomsEntities.WARPED_CLUCKSHROOM)).add(BiomeKeys.WARPED_FOREST);
    }

    private TagKey<Biome> getTag(AbstractMoobloom moobloom) {
        return TagKey.of(RegistryKeys.BIOME, moobloom.getName().withPrefixedPath("spawns_"));
    }
}
