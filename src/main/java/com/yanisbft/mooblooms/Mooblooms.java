package com.yanisbft.mooblooms;

import com.yanisbft.mooblooms.config.MoobloomsConfig;
import com.yanisbft.mooblooms.init.MoobloomsEntities;
import com.yanisbft.mooblooms.init.MoobloomsGeneration;

import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.serializer.Toml4jConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

public class Mooblooms implements ModInitializer {
	public static final String MOD_ID = "mooblooms";
	
	@Override
	public void onInitialize() {
		AutoConfig.register(MoobloomsConfig.class, Toml4jConfigSerializer::new);
		
		new MoobloomsEntities();
		
		MoobloomsGeneration.init();
	}
	
	public static Identifier id(String name) {
		return new Identifier(Mooblooms.MOD_ID, name);
	}
}
