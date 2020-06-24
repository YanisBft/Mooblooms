package com.yanis48.mooblooms.config;

import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;
import me.sargunvohra.mcmods.autoconfig1u.annotation.ConfigEntry;

@Config(name = "mooblooms")
public class MoobloomsConfig implements ConfigData {

	@ConfigEntry.Gui.CollapsibleObject
	public DandelionMoobloom dandelionMoobloom = new DandelionMoobloom();
	
	@ConfigEntry.Gui.CollapsibleObject
	public PoppyMoobloom poppyMoobloom = new PoppyMoobloom();
	
	@ConfigEntry.Gui.CollapsibleObject
	public BlueOrchidMoobloom blueOrchidMoobloom = new BlueOrchidMoobloom();
	
	@ConfigEntry.Gui.CollapsibleObject
	public AlliumMoobloom alliumMoobloom = new AlliumMoobloom();
	
	@ConfigEntry.Gui.CollapsibleObject
	public OxeyeDaisyMoobloom oxeyeDaisyMoobloom = new OxeyeDaisyMoobloom();
	
	@ConfigEntry.Gui.CollapsibleObject
	public CornflowerMoobloom cornflowerMoobloom = new CornflowerMoobloom();
	
	@ConfigEntry.Gui.CollapsibleObject
	public WitherRoseMoobloom witherRoseMoobloom = new WitherRoseMoobloom();
	
	@ConfigEntry.Gui.CollapsibleObject
	public Suncower suncower = new Suncower();
	
	@ConfigEntry.Gui.CollapsibleObject
	public Bambmoo bambmoo = new Bambmoo();
	
	@ConfigEntry.Gui.CollapsibleObject
	public CrimsonMooshroom crimsonMooshroom = new CrimsonMooshroom();
	
	@ConfigEntry.Gui.CollapsibleObject
	public WarpedMooshroom warpedMooshroom = new WarpedMooshroom();
	
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
		public static boolean damagePlayers = true;
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
}
