package com.yanis48.mooblooms;

import com.yanis48.mooblooms.init.MoobloomsEntities;
import com.yanis48.mooblooms.init.MoobloomsItems;

import net.fabricmc.api.ModInitializer;

public class Mooblooms implements ModInitializer {
	
	public static final String MOD_ID = "mooblooms";
	
	@Override
	public void onInitialize() {
		new MoobloomsEntities();
		new MoobloomsItems();
	}
}
