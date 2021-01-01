package com.yanisbft.mooblooms.config;

import com.yanisbft.mooblooms.Mooblooms;

import io.github.prospector.modmenu.api.ConfigScreenFactory;
import io.github.prospector.modmenu.api.ModMenuApi;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class ModMenuIntegration implements ModMenuApi {

	@Override
	public String getModId() {
		return Mooblooms.MOD_ID;
	}

	@Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return screen -> AutoConfig.getConfigScreen(MoobloomsConfig.class, screen).get();
    }
}
