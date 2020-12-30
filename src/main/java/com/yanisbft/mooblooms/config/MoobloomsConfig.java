package com.yanisbft.mooblooms.config;

import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;
import me.sargunvohra.mcmods.autoconfig1u.annotation.ConfigEntry;

@Config(name = "mooblooms")
public class MoobloomsConfig implements ConfigData {

	@ConfigEntry.Gui.CollapsibleObject public DandelionMoobloom dandelionMoobloom = new DandelionMoobloom();
	@ConfigEntry.Gui.CollapsibleObject public PoppyMoobloom poppyMoobloom = new PoppyMoobloom();
	@ConfigEntry.Gui.CollapsibleObject public BlueOrchidMoobloom blueOrchidMoobloom = new BlueOrchidMoobloom();
	@ConfigEntry.Gui.CollapsibleObject public AlliumMoobloom alliumMoobloom = new AlliumMoobloom();
	@ConfigEntry.Gui.CollapsibleObject public OxeyeDaisyMoobloom oxeyeDaisyMoobloom = new OxeyeDaisyMoobloom();
	@ConfigEntry.Gui.CollapsibleObject public CornflowerMoobloom cornflowerMoobloom = new CornflowerMoobloom();
	@ConfigEntry.Gui.CollapsibleObject public WitherRoseMoobloom witherRoseMoobloom = new WitherRoseMoobloom();
	@ConfigEntry.Gui.CollapsibleObject public Suncower suncower = new Suncower();
	@ConfigEntry.Gui.CollapsibleObject public Bambmoo bambmoo = new Bambmoo();
	@ConfigEntry.Gui.CollapsibleObject public CrimsonMooshroom crimsonMooshroom = new CrimsonMooshroom();
	@ConfigEntry.Gui.CollapsibleObject public WarpedMooshroom warpedMooshroom = new WarpedMooshroom();
	@ConfigEntry.Gui.CollapsibleObject public RedCluckshroom redCluckshroom = new RedCluckshroom();
	@ConfigEntry.Gui.CollapsibleObject public BrownCluckshroom brownCluckshroom = new BrownCluckshroom();
	@ConfigEntry.Gui.CollapsibleObject public CrimsonCluckshroom crimsonCluckshroom = new CrimsonCluckshroom();
	@ConfigEntry.Gui.CollapsibleObject public WarpedCluckshroom warpedCluckshroom = new WarpedCluckshroom();

	public static class DandelionMoobloom implements MoobloomConfigCategory {
		public int weight = 10;
		public int minGroupSize = 2;
		public int maxGroupSize = 4;
		public boolean spawnBlocks = true;
	}
	
	public static class PoppyMoobloom implements MoobloomConfigCategory {
		public int weight = 10;
		public int minGroupSize = 2;
		public int maxGroupSize = 4;
		public boolean spawnBlocks = true;
	}
	
	public static class BlueOrchidMoobloom implements MoobloomConfigCategory {
		public int weight = 10;
		public int minGroupSize = 2;
		public int maxGroupSize = 4;
		public boolean spawnBlocks = true;
	}
	
	public static class AlliumMoobloom implements MoobloomConfigCategory {
		public int weight = 10;
		public int minGroupSize = 2;
		public int maxGroupSize = 4;
		public boolean spawnBlocks = true;
	}
	
	public static class OxeyeDaisyMoobloom implements MoobloomConfigCategory {
		public int weight = 10;
		public int minGroupSize = 2;
		public int maxGroupSize = 4;
		public boolean spawnBlocks = true;
	}
	
	public static class CornflowerMoobloom implements MoobloomConfigCategory {
		public int weight = 10;
		public int minGroupSize = 2;
		public int maxGroupSize = 4;
		public boolean spawnBlocks = true;
	}
	
	public static class WitherRoseMoobloom implements MoobloomConfigCategory {
		public int weight = 80;
		public int minGroupSize = 2;
		public int maxGroupSize = 4;
		public boolean spawnBlocks = true;
		public boolean damagePlayers = true;
	}
	
	public static class Suncower implements MoobloomConfigCategory {
		public int weight = 10;
		public int minGroupSize = 2;
		public int maxGroupSize = 4;
		public boolean spawnBlocks = true;
	}
	
	public static class Bambmoo implements MoobloomConfigCategory {
		public int weight = 60;
		public int minGroupSize = 2;
		public int maxGroupSize = 4;
		public boolean spawnBlocks = true;
	}
	
	public static class CrimsonMooshroom implements MoobloomConfigCategory {
		public int weight = 100;
		public int minGroupSize = 4;
		public int maxGroupSize = 8;
		public boolean spawnBlocks = true;
	}
	
	public static class WarpedMooshroom implements MoobloomConfigCategory {
		public int weight = 100;
		public int minGroupSize = 4;
		public int maxGroupSize = 8;
		public boolean spawnBlocks = true;
	}
	
	public static class RedCluckshroom implements MoobloomConfigCategory {
		public int weight = 10;
		public int minGroupSize = 4;
		public int maxGroupSize = 8;
		public boolean spawnBlocks = true;
	}
	
	public static class BrownCluckshroom implements MoobloomConfigCategory {
		public int weight = 10;
		public int minGroupSize = 4;
		public int maxGroupSize = 8;
		public boolean spawnBlocks = true;
	}
	
	public static class CrimsonCluckshroom implements MoobloomConfigCategory {
		public int weight = 100;
		public int minGroupSize = 4;
		public int maxGroupSize = 8;
		public boolean spawnBlocks = true;
	}
	
	public static class WarpedCluckshroom implements MoobloomConfigCategory {
		public int weight = 100;
		public int minGroupSize = 4;
		public int maxGroupSize = 8;
		public boolean spawnBlocks = true;
	}
}
