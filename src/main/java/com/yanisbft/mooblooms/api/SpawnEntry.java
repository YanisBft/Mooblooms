package com.yanisbft.mooblooms.api;

import com.yanisbft.mooblooms.config.MoobloomConfigCategory;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;

import java.util.function.Predicate;

public class SpawnEntry {
    private Predicate<BiomeSelectionContext> biomeSelector;
    private int weight;
    private int minGroupSize;
    private int maxGroupSize;

    /**
     * Creates a new spawn entry from a biome selector and a config category.
     * <p>This constructor expects a config category class containing "{@code weight}", "{@code minGroupSize}"
     * and "{@code maxGroupSize}" fields, corresponding to config entries.</p>
     * @param biomeSelector a biome selection predicate (see {@linkplain net.fabricmc.fabric.api.biome.v1.BiomeSelectors BiomeSelectors})
     * @param configCategory an instance of a class implementing {@link MoobloomConfigCategory}
     */
    public SpawnEntry(Predicate<BiomeSelectionContext> biomeSelector, MoobloomConfigCategory configCategory) {
        this.biomeSelector = biomeSelector;
        try {
            this.weight = configCategory.getClass().getDeclaredField("weight").getInt(configCategory);
            this.minGroupSize = configCategory.getClass().getDeclaredField("minGroupSize").getInt(configCategory);
            this.maxGroupSize = configCategory.getClass().getDeclaredField("maxGroupSize").getInt(configCategory);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates a new spawn entry from a biome selector, a weight and a minimum and maximum group sizes.
     * @param biomeSelector a biome selection predicate (see {@linkplain net.fabricmc.fabric.api.biome.v1.BiomeSelectors BiomeSelectors})
     * @param weight a weight
     * @param minGroupSize a minimum group size
     * @param maxGroupSize a maximum group size
     */
    public SpawnEntry(Predicate<BiomeSelectionContext> biomeSelector, int weight, int minGroupSize, int maxGroupSize) {
        this.biomeSelector = biomeSelector;
        this.weight = weight;
        this.minGroupSize = minGroupSize;
        this.maxGroupSize = maxGroupSize;
    }

    /**
     * Returns the biome selection predicate of this spawn entry.
     */
    public Predicate<BiomeSelectionContext> getBiomeSelector() {
        return this.biomeSelector;
    }

    /**
     * Returns the weight of this spawn entry.
     */
    public int getWeight() {
        return this.weight;
    }

    /**
     * Returns the minimum group size of this spawn entry.
     */
    public int getMinGroupSize() {
        return this.minGroupSize;
    }

    /**
     * Returns the maximum group size of this spawn entry.
     */
    public int getMaxGroupSize() {
        return this.maxGroupSize;
    }
}
