package com.KeanuNichols.LightningStrike;

import org.bukkit.plugin.java.JavaPlugin;

public class LightningStrike extends JavaPlugin {
	
	@Override
    public void onEnable() {
		System.out.println("Hello");
		getCommand("lightning").setExecutor(new Bolt());
    }
    @Override
    public void onDisable() {
    }

}
