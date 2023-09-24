package com.yanisbft.mooblooms.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "mooblooms")
public class MoobloomsConfig implements ConfigData {
	public boolean showApiLogs = true;

	@ConfigEntry.Gui.CollapsibleObject public BaseMoobloom dandelionMoobloom = new BaseMoobloom(10, 2, 4);
	@ConfigEntry.Gui.CollapsibleObject public BaseMoobloom poppyMoobloom = new BaseMoobloom(10, 2, 4);
	@ConfigEntry.Gui.CollapsibleObject public BaseMoobloom blueOrchidMoobloom = new BaseMoobloom(10, 2, 4);
	@ConfigEntry.Gui.CollapsibleObject public BaseMoobloom alliumMoobloom = new BaseMoobloom(10, 2, 4);
	@ConfigEntry.Gui.CollapsibleObject public BaseMoobloom oxeyeDaisyMoobloom = new BaseMoobloom(10, 2, 4);
	@ConfigEntry.Gui.CollapsibleObject public BaseMoobloom cornflowerMoobloom = new BaseMoobloom(10, 2, 4);
	@ConfigEntry.Gui.CollapsibleObject public DamagingMoobloom witherRoseMoobloom = new DamagingMoobloom(80, 2, 4);
	@ConfigEntry.Gui.CollapsibleObject public BaseMoobloom suncower = new BaseMoobloom(10, 2, 4);
	@ConfigEntry.Gui.CollapsibleObject public BaseMoobloom bambmoo = new BaseMoobloom(60, 2, 4);
	@ConfigEntry.Gui.CollapsibleObject public DamagingMoobloom cowctus = new DamagingMoobloom(10, 2, 4);
	@ConfigEntry.Gui.CollapsibleObject public BaseMoobloom azaleaMoobloom = new BaseMoobloom(100, 2, 4);
	@ConfigEntry.Gui.CollapsibleObject public BaseMoobloom dripleafMoobloom = new BaseMoobloom(100, 2, 4);
	@ConfigEntry.Gui.CollapsibleObject public BaseMoobloom chorusMoobloom = new BaseMoobloom(30, 2, 4);
	@ConfigEntry.Gui.CollapsibleObject public BaseMoobloom crimsonMooshroom = new BaseMoobloom(100, 4, 8);
	@ConfigEntry.Gui.CollapsibleObject public BaseMoobloom warpedMooshroom = new BaseMoobloom(100, 4, 8);
	@ConfigEntry.Gui.CollapsibleObject public BaseMoobloom cherryMoobloom = new BaseMoobloom(10, 2, 4);
	@ConfigEntry.Gui.CollapsibleObject public BaseMoobloom redCluckshroom = new BaseMoobloom(10, 4, 8);
	@ConfigEntry.Gui.CollapsibleObject public BaseMoobloom brownCluckshroom = new BaseMoobloom(10, 4, 8);
	@ConfigEntry.Gui.CollapsibleObject public BaseMoobloom crimsonCluckshroom = new BaseMoobloom(100, 4, 8);
	@ConfigEntry.Gui.CollapsibleObject public BaseMoobloom warpedCluckshroom = new BaseMoobloom(100, 4, 8);

	public static class BaseMoobloom implements MoobloomConfigCategory {
		public boolean spawnEnabled;
		public int weight;
		public int minGroupSize;
		public int maxGroupSize;
		public boolean spawnBlocks;

		public BaseMoobloom(int weight, int minGroupSize, int maxGroupSize) {
			this.spawnEnabled = true;
			this.weight = weight;
			this.minGroupSize = minGroupSize;
			this.maxGroupSize = maxGroupSize;
			this.spawnBlocks = true;
		}
	}

	public static class DamagingMoobloom implements MoobloomConfigCategory {
		public boolean spawnEnabled;
		public int weight;
		public int minGroupSize;
		public int maxGroupSize;
		public boolean spawnBlocks;
		public boolean damagePlayers;

		public DamagingMoobloom(int weight, int minGroupSize, int maxGroupSize) {
			this.spawnEnabled = true;
			this.weight = weight;
			this.minGroupSize = minGroupSize;
			this.maxGroupSize = maxGroupSize;
			this.spawnBlocks = true;
			this.damagePlayers = true;
		}
	}
}
