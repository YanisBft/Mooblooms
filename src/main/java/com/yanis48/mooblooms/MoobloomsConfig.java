package com.yanis48.mooblooms;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

import blue.endless.jankson.Jankson;
import blue.endless.jankson.JsonElement;
import blue.endless.jankson.JsonGrammar;
import blue.endless.jankson.JsonObject;
import net.fabricmc.loader.api.FabricLoader;

public class MoobloomsConfig {
	
	public static class DandelionMoobloom {
		public static int weight = 10;
		public static int minGroupSize = 2;
		public static int maxGroupSize = 4;
		public static boolean spawnBlocks = true;
	}
	
	public static class PoppyMoobloom {
		public static int weight = 10;
		public static int minGroupSize = 2;
		public static int maxGroupSize = 4;
		public static boolean spawnBlocks = true;
	}
	
	public static class BlueOrchidMoobloom {
		public static int weight = 10;
		public static int minGroupSize = 2;
		public static int maxGroupSize = 4;
		public static boolean spawnBlocks = true;
	}
	
	public static class AlliumMoobloom {
		public static int weight = 10;
		public static int minGroupSize = 2;
		public static int maxGroupSize = 4;
		public static boolean spawnBlocks = true;
	}
	
	public static class OxeyeDaisyMoobloom {
		public static int weight = 10;
		public static int minGroupSize = 2;
		public static int maxGroupSize = 4;
		public static boolean spawnBlocks = true;
	}
	
	public static class CornflowerMoobloom {
		public static int weight = 10;
		public static int minGroupSize = 2;
		public static int maxGroupSize = 4;
		public static boolean spawnBlocks = true;
	}
	
	public static class WitherRoseMoobloom {
		public static int weight = 80;
		public static int minGroupSize = 2;
		public static int maxGroupSize = 4;
		public static boolean spawnBlocks = true;
	}
	
	public static class Suncower {
		public static int weight = 10;
		public static int minGroupSize = 2;
		public static int maxGroupSize = 4;
		public static boolean spawnBlocks = true;
	}
	
	public static class Bambmoo {
		public static int weight = 60;
		public static int minGroupSize = 2;
		public static int maxGroupSize = 4;
		public static boolean spawnBlocks = true;
	}
	
	public static class CrimsonMooshroom {
		public static int weight = 100;
		public static int minGroupSize = 4;
		public static int maxGroupSize = 8;
		public static boolean spawnBlocks = true;
	}
	
	public static class WarpedMooshroom {
		public static int weight = 100;
		public static int minGroupSize = 4;
		public static int maxGroupSize = 8;
		public static boolean spawnBlocks = true;
	}
	
	public static class Cluckshroom {
		public static int weight = 10;
		public static int minGroupSize = 4;
		public static int maxGroupSize = 8;
		public static boolean spawnBlocks = true;
	}
	
	public static void readConfig(JsonObject obj) {
		JsonObject dandelionMoobloom = getObjectOrEmpty("dandelion_moobloom", obj);
		DandelionMoobloom.weight = dandelionMoobloom.getInt("weight", DandelionMoobloom.weight);
		DandelionMoobloom.minGroupSize = dandelionMoobloom.getInt("min_group_size", DandelionMoobloom.minGroupSize);
		DandelionMoobloom.maxGroupSize = dandelionMoobloom.getInt("max_group_size", DandelionMoobloom.maxGroupSize);
		DandelionMoobloom.spawnBlocks = dandelionMoobloom.getBoolean("spawn_blocks", DandelionMoobloom.spawnBlocks);
		
		JsonObject poppyMoobloom = getObjectOrEmpty("poppy_moobloom", obj);
		PoppyMoobloom.weight = poppyMoobloom.getInt("weight", PoppyMoobloom.weight);
		PoppyMoobloom.minGroupSize = poppyMoobloom.getInt("min_group_size", PoppyMoobloom.minGroupSize);
		PoppyMoobloom.maxGroupSize = poppyMoobloom.getInt("max_group_size", PoppyMoobloom.maxGroupSize);
		PoppyMoobloom.spawnBlocks = poppyMoobloom.getBoolean("spawn_blocks", PoppyMoobloom.spawnBlocks);
		
		JsonObject blueOrchidMoobloom = getObjectOrEmpty("blue_orchid_moobloom", obj);
		BlueOrchidMoobloom.weight = blueOrchidMoobloom.getInt("weight", BlueOrchidMoobloom.weight);
		BlueOrchidMoobloom.minGroupSize = blueOrchidMoobloom.getInt("min_group_size", BlueOrchidMoobloom.minGroupSize);
		BlueOrchidMoobloom.maxGroupSize = blueOrchidMoobloom.getInt("max_group_size", BlueOrchidMoobloom.maxGroupSize);
		BlueOrchidMoobloom.spawnBlocks = blueOrchidMoobloom.getBoolean("spawn_blocks", BlueOrchidMoobloom.spawnBlocks);
		
		JsonObject alliumMoobloom = getObjectOrEmpty("allium_moobloom", obj);
		AlliumMoobloom.weight = alliumMoobloom.getInt("weight", AlliumMoobloom.weight);
		AlliumMoobloom.minGroupSize = alliumMoobloom.getInt("min_group_size", AlliumMoobloom.minGroupSize);
		AlliumMoobloom.maxGroupSize = alliumMoobloom.getInt("max_group_size", AlliumMoobloom.maxGroupSize);
		AlliumMoobloom.spawnBlocks = alliumMoobloom.getBoolean("spawn_blocks", AlliumMoobloom.spawnBlocks);
		
		JsonObject oxeyeDaisyMoobloom = getObjectOrEmpty("oxeye_daisy_moobloom", obj);
		OxeyeDaisyMoobloom.weight = oxeyeDaisyMoobloom.getInt("weight", OxeyeDaisyMoobloom.weight);
		OxeyeDaisyMoobloom.minGroupSize = oxeyeDaisyMoobloom.getInt("min_group_size", OxeyeDaisyMoobloom.minGroupSize);
		OxeyeDaisyMoobloom.maxGroupSize = oxeyeDaisyMoobloom.getInt("max_group_size", OxeyeDaisyMoobloom.maxGroupSize);
		OxeyeDaisyMoobloom.spawnBlocks = oxeyeDaisyMoobloom.getBoolean("spawn_blocks", OxeyeDaisyMoobloom.spawnBlocks);
		
		JsonObject cornflowerMoobloom = getObjectOrEmpty("cornflower_moobloom", obj);
		CornflowerMoobloom.weight = cornflowerMoobloom.getInt("weight", CornflowerMoobloom.weight);
		CornflowerMoobloom.minGroupSize = cornflowerMoobloom.getInt("min_group_size", CornflowerMoobloom.minGroupSize);
		CornflowerMoobloom.maxGroupSize = cornflowerMoobloom.getInt("max_group_size", CornflowerMoobloom.maxGroupSize);
		CornflowerMoobloom.spawnBlocks = cornflowerMoobloom.getBoolean("spawn_blocks", CornflowerMoobloom.spawnBlocks);
		
		JsonObject witherRoseMoobloom = getObjectOrEmpty("wither_rose_moobloom", obj);
		WitherRoseMoobloom.weight = witherRoseMoobloom.getInt("weight", WitherRoseMoobloom.weight);
		WitherRoseMoobloom.minGroupSize = witherRoseMoobloom.getInt("min_group_size", WitherRoseMoobloom.minGroupSize);
		WitherRoseMoobloom.maxGroupSize = witherRoseMoobloom.getInt("max_group_size", WitherRoseMoobloom.maxGroupSize);
		WitherRoseMoobloom.spawnBlocks = witherRoseMoobloom.getBoolean("spawn_blocks", WitherRoseMoobloom.spawnBlocks);
		
		JsonObject suncower = getObjectOrEmpty("suncower", obj);
		Suncower.weight = suncower.getInt("weight", Suncower.weight);
		Suncower.minGroupSize = suncower.getInt("min_group_size", Suncower.minGroupSize);
		Suncower.maxGroupSize = suncower.getInt("max_group_size", Suncower.maxGroupSize);
		Suncower.spawnBlocks = suncower.getBoolean("spawn_blocks", Suncower.spawnBlocks);
		
		JsonObject bambmoo = getObjectOrEmpty("bambmoo", obj);
		Bambmoo.weight = bambmoo.getInt("weight", Bambmoo.weight);
		Bambmoo.minGroupSize = bambmoo.getInt("min_group_size", Bambmoo.minGroupSize);
		Bambmoo.maxGroupSize = bambmoo.getInt("max_group_size", Bambmoo.maxGroupSize);
		Bambmoo.spawnBlocks = bambmoo.getBoolean("spawn_blocks", Bambmoo.spawnBlocks);
		
		JsonObject crimsonMooshroom = getObjectOrEmpty("allium_moobloom", obj);
		CrimsonMooshroom.weight = crimsonMooshroom.getInt("weight", CrimsonMooshroom.weight);
		CrimsonMooshroom.minGroupSize = crimsonMooshroom.getInt("min_group_size", CrimsonMooshroom.minGroupSize);
		CrimsonMooshroom.maxGroupSize = crimsonMooshroom.getInt("max_group_size", CrimsonMooshroom.maxGroupSize);
		CrimsonMooshroom.spawnBlocks = crimsonMooshroom.getBoolean("spawn_blocks", CrimsonMooshroom.spawnBlocks);
		
		JsonObject warpedMooshroom = getObjectOrEmpty("allium_moobloom", obj);
		WarpedMooshroom.weight = warpedMooshroom.getInt("weight", WarpedMooshroom.weight);
		WarpedMooshroom.minGroupSize = warpedMooshroom.getInt("min_group_size", WarpedMooshroom.minGroupSize);
		WarpedMooshroom.maxGroupSize = warpedMooshroom.getInt("max_group_size", WarpedMooshroom.maxGroupSize);
		WarpedMooshroom.spawnBlocks = warpedMooshroom.getBoolean("spawn_blocks", WarpedMooshroom.spawnBlocks);
		
		JsonObject cluckshroom = getObjectOrEmpty("cluckshroom", obj);
		Cluckshroom.weight = cluckshroom.getInt("weight", Cluckshroom.weight);
		Cluckshroom.minGroupSize = cluckshroom.getInt("min_group_size", Cluckshroom.minGroupSize);
		Cluckshroom.maxGroupSize = cluckshroom.getInt("max_group_size", Cluckshroom.maxGroupSize);
		Cluckshroom.spawnBlocks = cluckshroom.getBoolean("spawn_blocks", Cluckshroom.spawnBlocks);
	}
	
	public static void writeConfig(JsonObject obj) {
		JsonObject dandelionMoobloom = defaultPutButNotNull("dandelion_moobloom", new JsonObject(), obj);
		dandelionMoobloom.putDefault("weight", DandelionMoobloom.weight, "");
		dandelionMoobloom.putDefault("min_group_size", DandelionMoobloom.minGroupSize, "");
		dandelionMoobloom.putDefault("max_group_size", DandelionMoobloom.maxGroupSize, "");
		dandelionMoobloom.putDefault("spawn_blocks", DandelionMoobloom.spawnBlocks, "");
		
		JsonObject poppyMoobloom = defaultPutButNotNull("poppy_moobloom", new JsonObject(), obj);
		poppyMoobloom.putDefault("weight", PoppyMoobloom.weight, "");
		poppyMoobloom.putDefault("min_group_size", PoppyMoobloom.minGroupSize, "");
		poppyMoobloom.putDefault("max_group_size", PoppyMoobloom.maxGroupSize, "");
		poppyMoobloom.putDefault("spawn_blocks", PoppyMoobloom.spawnBlocks, "");
		
		JsonObject blueOrchidMoobloom = defaultPutButNotNull("blue_orchid_moobloom", new JsonObject(), obj);
		blueOrchidMoobloom.putDefault("weight", BlueOrchidMoobloom.weight, "");
		blueOrchidMoobloom.putDefault("min_group_size", BlueOrchidMoobloom.minGroupSize, "");
		blueOrchidMoobloom.putDefault("max_group_size", BlueOrchidMoobloom.maxGroupSize, "");
		blueOrchidMoobloom.putDefault("spawn_blocks", BlueOrchidMoobloom.spawnBlocks, "");
		
		JsonObject alliumMoobloom = defaultPutButNotNull("allium_moobloom", new JsonObject(), obj);
		alliumMoobloom.putDefault("weight", AlliumMoobloom.weight, "");
		alliumMoobloom.putDefault("min_group_size", AlliumMoobloom.minGroupSize, "");
		alliumMoobloom.putDefault("max_group_size", AlliumMoobloom.maxGroupSize, "");
		alliumMoobloom.putDefault("spawn_blocks", AlliumMoobloom.spawnBlocks, "");
		
		JsonObject oxeyeDaisyMoobloom = defaultPutButNotNull("oxeye_daisy_moobloom", new JsonObject(), obj);
		oxeyeDaisyMoobloom.putDefault("weight", OxeyeDaisyMoobloom.weight, "");
		oxeyeDaisyMoobloom.putDefault("min_group_size", OxeyeDaisyMoobloom.minGroupSize, "");
		oxeyeDaisyMoobloom.putDefault("max_group_size", OxeyeDaisyMoobloom.maxGroupSize, "");
		oxeyeDaisyMoobloom.putDefault("spawn_blocks", OxeyeDaisyMoobloom.spawnBlocks, "");
		
		JsonObject cornflowerMoobloom = defaultPutButNotNull("cornflower_moobloom", new JsonObject(), obj);
		cornflowerMoobloom.putDefault("weight", CornflowerMoobloom.weight, "");
		cornflowerMoobloom.putDefault("min_group_size", CornflowerMoobloom.minGroupSize, "");
		cornflowerMoobloom.putDefault("max_group_size", CornflowerMoobloom.maxGroupSize, "");
		cornflowerMoobloom.putDefault("spawn_blocks", CornflowerMoobloom.spawnBlocks, "");
		
		JsonObject witherRoseMoobloom = defaultPutButNotNull("wither_rose_moobloom", new JsonObject(), obj);
		witherRoseMoobloom.putDefault("weight", WitherRoseMoobloom.weight, "");
		witherRoseMoobloom.putDefault("min_group_size", WitherRoseMoobloom.minGroupSize, "");
		witherRoseMoobloom.putDefault("max_group_size", WitherRoseMoobloom.maxGroupSize, "");
		witherRoseMoobloom.putDefault("spawn_blocks", WitherRoseMoobloom.spawnBlocks, "");
		
		JsonObject suncower = defaultPutButNotNull("suncower", new JsonObject(), obj);
		suncower.putDefault("weight", Suncower.weight, "");
		suncower.putDefault("min_group_size", Suncower.minGroupSize, "");
		suncower.putDefault("max_group_size", Suncower.maxGroupSize, "");
		suncower.putDefault("spawn_blocks", Suncower.spawnBlocks, "");
		
		JsonObject bambmoo = defaultPutButNotNull("bambmoo", new JsonObject(), obj);
		bambmoo.putDefault("weight", Bambmoo.weight, "");
		bambmoo.putDefault("min_group_size", Bambmoo.minGroupSize, "");
		bambmoo.putDefault("max_group_size", Bambmoo.maxGroupSize, "");
		bambmoo.putDefault("spawn_blocks", Bambmoo.spawnBlocks, "");
		
		JsonObject crimsonMooshroom = defaultPutButNotNull("allium_moobloom", new JsonObject(), obj);
		crimsonMooshroom.putDefault("weight", CrimsonMooshroom.weight, "");
		crimsonMooshroom.putDefault("min_group_size", CrimsonMooshroom.minGroupSize, "");
		crimsonMooshroom.putDefault("max_group_size", CrimsonMooshroom.maxGroupSize, "");
		crimsonMooshroom.putDefault("spawn_blocks", CrimsonMooshroom.spawnBlocks, "");
		
		JsonObject warpedMooshroom = defaultPutButNotNull("allium_moobloom", new JsonObject(), obj);
		warpedMooshroom.putDefault("weight", WarpedMooshroom.weight, "");
		warpedMooshroom.putDefault("min_group_size", WarpedMooshroom.minGroupSize, "");
		warpedMooshroom.putDefault("max_group_size", WarpedMooshroom.maxGroupSize, "");
		warpedMooshroom.putDefault("spawn_blocks", WarpedMooshroom.spawnBlocks, "");
		
		JsonObject cluckshroom = defaultPutButNotNull("cluckshroom", new JsonObject(), obj);
		cluckshroom.putDefault("weight", Cluckshroom.weight, "");
		cluckshroom.putDefault("min_group_size", Cluckshroom.minGroupSize, "");
		cluckshroom.putDefault("max_group_size", Cluckshroom.maxGroupSize, "");
		cluckshroom.putDefault("spawn_blocks", Cluckshroom.spawnBlocks, "");
	}
	
	private static final Jankson JANKSON = Jankson.builder().build();
	
	public static void sync() {
		File file = FabricLoader.getInstance().getConfigDirectory().toPath().resolve("mooblooms.json5").toFile();
		JsonObject config = new JsonObject();
		if (file.exists()) {
			loadFile(file, config);
		} else {
			writeConfig(config);
			saveFile(file, config);
		}
	}
	
	private static void loadFile(File file, JsonObject config) {
		try {
			config = JANKSON.load(file);
			readConfig(config);
			saveFile(file, config);
		} catch (Exception e) {
			Mooblooms.LOGGER.error("[Mooblooms] Config could not be loaded: {}", e.getMessage());
		}
	}
	
	private static void saveFile(File file, JsonObject config) {
		writeConfig(config);
		try (OutputStream out = new BufferedOutputStream(new FileOutputStream(file))) {
			if (!file.exists()) {
				file.createNewFile();
			}
			out.write(config.toJson(JsonGrammar.JANKSON).getBytes(StandardCharsets.UTF_8));
			out.flush();
			out.close();
		} catch (Exception e) {
			Mooblooms.LOGGER.error("[Mooblooms] Config could not be saved: {}", e.getMessage());
		}
	}
	
	private static JsonObject getObjectOrEmpty(String key, JsonObject on) {
		JsonObject obj = on.getObject(key);
		return obj != null ? obj : new JsonObject();
	}
	
	@SuppressWarnings("unchecked")
	private static <T extends JsonElement> T defaultPutButNotNull(String key, T value, JsonObject json) {
		JsonElement result = json.putDefault(key, value, value.getClass(), null);
		return result != null ? (T) result : value;
	}
}
