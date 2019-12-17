package com.yanis48.mooblooms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.yanis48.mooblooms.init.MoobloomsEntities;
import com.yanis48.mooblooms.init.MoobloomsItems;

import net.fabricmc.api.ModInitializer;

public class Mooblooms implements ModInitializer {
	
	public static final String MOD_ID = "mooblooms";
	public static final Logger LOGGER = LogManager.getLogger();
	
	@Override
	public void onInitialize() {		
		new MoobloomsEntities();
		new MoobloomsItems();
		
		MoobloomsConfig.sync();
	}
}
