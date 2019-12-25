package com.yanis48.mooblooms;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

import blue.endless.jankson.Jankson;
import blue.endless.jankson.JsonElement;
import blue.endless.jankson.JsonGrammar;
import blue.endless.jankson.JsonObject;
import blue.endless.jankson.api.SyntaxError;

public class MoobloomsConfig {
	
	private static final Jankson JANKSON = Jankson.builder().build();
	
	public static void loadFrom(JsonObject obj) {
		JsonObject spawnWeight = getObjectOrEmpty("spawn_weight", obj);
		SpawnWeight.dandelionMoobloom = spawnWeight.getInt("dandelion_moobloom", SpawnWeight.dandelionMoobloom);
		SpawnWeight.poppyMoobloom = spawnWeight.getInt("poppy_moobloom", SpawnWeight.poppyMoobloom);
		SpawnWeight.blueOrchidMoobloom = spawnWeight.getInt("blue_orchid_moobloom", SpawnWeight.blueOrchidMoobloom);
		SpawnWeight.alliumMoobloom = spawnWeight.getInt("allium_moobloom", SpawnWeight.alliumMoobloom);
		SpawnWeight.oxeyeDaisyMoobloom = spawnWeight.getInt("oxeye_daisy_moobloom", SpawnWeight.oxeyeDaisyMoobloom);
		SpawnWeight.cornflowerMoobloom = spawnWeight.getInt("cornflower_moobloom", SpawnWeight.cornflowerMoobloom);
		SpawnWeight.witherRoseMoobloom = spawnWeight.getInt("wither_rose_moobloom", SpawnWeight.witherRoseMoobloom);
		SpawnWeight.suncower = spawnWeight.getInt("suncower", SpawnWeight.suncower);
		SpawnWeight.bambmoo = spawnWeight.getInt("bambmoo", SpawnWeight.bambmoo);
		SpawnWeight.cluckshroom = spawnWeight.getInt("cluckshroom", SpawnWeight.cluckshroom);
		
		JsonObject autoBlockSpawning = getObjectOrEmpty("auto_block_spawning", obj);
		AutoBlockSpawning.mooblooms = autoBlockSpawning.getBoolean("mooblooms", AutoBlockSpawning.mooblooms);
		AutoBlockSpawning.cluckshroom = autoBlockSpawning.getBoolean("cluckshroom", AutoBlockSpawning.cluckshroom);
	}
	
	public static void saveTo(JsonObject obj) {
		JsonObject spawnWeight = defaultPutButNotNull("spawn_weight", new JsonObject(), obj);
		spawnWeight.putDefault("dandelion_moobloom", SpawnWeight.dandelionMoobloom, "");
		spawnWeight.putDefault("poppy_moobloom", SpawnWeight.poppyMoobloom, "");
		spawnWeight.putDefault("blue_orchid_moobloom", SpawnWeight.blueOrchidMoobloom, "");
		spawnWeight.putDefault("allium_moobloom", SpawnWeight.alliumMoobloom, "");
		spawnWeight.putDefault("oxeye_daisy_moobloom", SpawnWeight.oxeyeDaisyMoobloom, "");
		spawnWeight.putDefault("cornflower_moobloom", SpawnWeight.cornflowerMoobloom, "");
		spawnWeight.putDefault("wither_rose_moobloom", SpawnWeight.witherRoseMoobloom, "");
		spawnWeight.putDefault("suncower", SpawnWeight.suncower, "");
		spawnWeight.putDefault("bambmoo", SpawnWeight.bambmoo, "");
		spawnWeight.putDefault("cluckshroom", SpawnWeight.cluckshroom, "");
		
		JsonObject autoBlockSpawning = defaultPutButNotNull("auto_block_spawning", new JsonObject(), obj);
		autoBlockSpawning.putDefault("mooblooms", AutoBlockSpawning.mooblooms, "If mooblooms can spawn flowers automatically");
		autoBlockSpawning.putDefault("cluckshroom", AutoBlockSpawning.cluckshroom, "If cluckshrooms can spawn mushrooms automatically");
	}
	
	public static void sync() {
		File configFile = new File("config/mooblooms.json5");
		JsonObject config = new JsonObject();
		if (configFile.exists()) {
			try {
				config = JANKSON.load(configFile);
				loadFrom(config);
				writeConfigFile(configFile, config);
			} catch (IOException | SyntaxError e) {
				Mooblooms.LOGGER.error("Mooblooms config could not be loaded. Default values will be used.", e);
			}
		} else {
			saveTo(config);
			writeConfigFile(configFile, config);
		}
	}
	
	private static void writeConfigFile(File file, JsonObject config) {
		saveTo(config);
		try (OutputStream out = new BufferedOutputStream(new FileOutputStream(file))) {
			out.write(config.toJson(JsonGrammar.JANKSON).getBytes(StandardCharsets.UTF_8));
		} catch (IOException e) {
			Mooblooms.LOGGER.error("Mooblooms config could not be written. This probably won't cause any problems, but it shouldn't happen.", e);
		}
	}
	
	private static JsonObject getObjectOrEmpty(String key, JsonObject on) {
		JsonObject obj = on.getObject(key);
		return obj != null ? obj : new JsonObject();
	}
	
	@SuppressWarnings("unchecked")
	private static <T extends JsonElement> T defaultPutButNotNull(String key, T value, JsonObject obj) {
		JsonElement result = obj.putDefault(key, value, value.getClass(), null);
		return result != null ? (T) result : value;
	}
	
	public static class SpawnWeight {
		public static int dandelionMoobloom = 10;
		public static int poppyMoobloom = 10;
		public static int blueOrchidMoobloom = 10;
		public static int alliumMoobloom = 10;
		public static int oxeyeDaisyMoobloom = 10;
		public static int cornflowerMoobloom = 10;
		public static int witherRoseMoobloom = 80;
		public static int suncower = 10;
		public static int bambmoo = 60;
		public static int cluckshroom = 10;
	}
	
	public static class AutoBlockSpawning {
		public static boolean mooblooms = true;
		public static boolean cluckshroom = true;
	}
}
