package com.yanisbft.mooblooms.api;

import com.yanisbft.mooblooms.config.MoobloomConfigCategory;

public class SpawnEntry {
    private int weight;
    private int minGroupSize;
    private int maxGroupSize;

    /**
     * Creates a new spawn entry from a config category.
     * <p>This constructor expects a config category class containing "{@code weight}", "{@code minGroupSize}"
     * and "{@code maxGroupSize}" fields, corresponding to config entries.</p>
     * @param configCategory an instance of a class implementing {@link MoobloomConfigCategory}
     */
    public SpawnEntry(MoobloomConfigCategory configCategory) {
        try {
            this.weight = configCategory.getClass().getDeclaredField("weight").getInt(configCategory);
            this.minGroupSize = configCategory.getClass().getDeclaredField("minGroupSize").getInt(configCategory);
            this.maxGroupSize = configCategory.getClass().getDeclaredField("maxGroupSize").getInt(configCategory);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates a new spawn entry from a weight, a minimum group size and a maximum group size.
     * @param weight a weight
     * @param minGroupSize a minimum group size
     * @param maxGroupSize a maximum group size
     */
    public SpawnEntry(int weight, int minGroupSize, int maxGroupSize) {
        this.weight = weight;
        this.minGroupSize = minGroupSize;
        this.maxGroupSize = maxGroupSize;
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
