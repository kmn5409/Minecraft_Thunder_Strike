package com.KeanuNichols.LightningStrike;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import java.lang.Math;

public class LightningStrike extends JavaPlugin {
	
	public long randomNumber(){
		long leftLimit = 100L;
	    long rightLimit = 600L;
	    long generatedLong = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
		return generatedLong;
	}
	@Override
    public void onEnable() {
		System.out.println("Hello");
		//getCommand("lightning").setExecutor(new Bolt());
		JavaPlugin plugin = this;
		Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable()
        {
            public void run()
            {			
        		Player plr = Bukkit.getPlayer("KeanuNichols");
            	plr.sendMessage(Float.toString(randomNumber()));
            	Bolt();
            }
        }, 20L, randomNumber());
		System.out.println("After");
    }
    @Override
    public void onDisable() {
    }
    
    public void Bolt(){
    	for (Player online : Bukkit.getServer().getOnlinePlayers()) {
            Player plr = Bukkit.getPlayer(online.getName());
            Location loca = plr.getLocation();
    		World world = plr.getWorld();
    		world.strikeLightning(loca);
        }
    	//System.out.println("bolt");
		//String name = sender.getName();				
		//Player plr = Bukkit.getPlayer(name);
    }

}
