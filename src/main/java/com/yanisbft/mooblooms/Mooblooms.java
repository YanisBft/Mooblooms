package com.yanisbft.mooblooms;

import com.yanisbft.mooblooms.config.MoobloomsConfig;
import com.yanisbft.mooblooms.init.MoobloomsEntities;
import com.yanisbft.mooblooms.init.MoobloomsSpawnRestrictions;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

public class Mooblooms implements ModInitializer {
	public static final String MOD_ID = "mooblooms";
	public static MoobloomsConfig config;

	@Override
	public void onInitialize() {
		AutoConfig.register(MoobloomsConfig.class, GsonConfigSerializer::new);
		config = AutoConfig.getConfigHolder(MoobloomsConfig.class).getConfig();
		
		new MoobloomsEntities();
		
		MoobloomsSpawnRestrictions.init();
	}

	/**
	 * Creates an identifier from the {@linkplain Mooblooms#MOD_ID mod id} and the provided {@code name}.
	 * @param name the path of the identifier
	 * @return an {@linkplain Identifier}, consisting of a namespace and a path
	 */
	public static Identifier id(String name) {
		return new Identifier(Mooblooms.MOD_ID, name);
	}
}
