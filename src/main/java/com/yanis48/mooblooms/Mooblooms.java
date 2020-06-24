package com.yanis48.mooblooms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.yanis48.mooblooms.config.MoobloomsConfig;
import com.yanis48.mooblooms.init.MoobloomsEntities;
import com.yanis48.mooblooms.init.MoobloomsGeneration;
import com.yanis48.mooblooms.init.MoobloomsItems;

import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.serializer.Toml4jConfigSerializer;
import net.fabricmc.api.ModInitializer;

public class Mooblooms implements ModInitializer {
	public static final String MOD_ID = "mooblooms";
	public static final Logger LOGGER = LogManager.getLogger();
	
	@Override
	public void onInitialize() {		
		new MoobloomsEntities();
		new MoobloomsItems();
		AutoConfig.register(MoobloomsConfig.class, Toml4jConfigSerializer::new);
		
		MoobloomsEntities.registerEntityAttributes();
		
		MoobloomsGeneration.init();
	}
}
