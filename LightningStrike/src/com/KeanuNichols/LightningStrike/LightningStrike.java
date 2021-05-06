package com.KeanuNichols.LightningStrike;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.Random;
import java.lang.Math;

public class LightningStrike extends JavaPlugin {
	
	public void BoltPlayer(){
    	for (Player online : Bukkit.getServer().getOnlinePlayers()) {
            Player plr = Bukkit.getPlayer(online.getName());
            Location loca = plr.getLocation();
    		World world = plr.getWorld();
    		world.strikeLightning(loca);
        }
    }
	
	public void BoltRandomLocation(){
		for (Player online : Bukkit.getServer().getOnlinePlayers()){
			Player plr = Bukkit.getPlayer(online.getName());
            Location loca = plr.getLocation();
    		World world = plr.getWorld();
    		Chunk chunk = loca.getChunk();
    		int y = loca.getBlockY();
    		//int z = (int) chunk.getZ();
    		Location nloca = chunk.getBlock(randomInt(0,3),y,randomInt(0,3)).getLocation();
    		world.strikeLightning(nloca);
		}
	}
	
	public void BoltRandomEntity(){
		for (Player online : Bukkit.getServer().getOnlinePlayers()){
			Player plr = Bukkit.getPlayer(online.getName());
			List <Entity> entities = plr.getNearbyEntities(40, 40, 40);
			if(!entities.isEmpty()){
				Entity target = entities.get(randomInt(0,entities.size()));
				World world = plr.getWorld();
				world.strikeLightning(target.getLocation());
			}
		}
		
	}
	
	public long randomNumberTime(){
		long leftLimit = 100L;
	    long rightLimit = 600L;
	    long generatedLong = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
		return generatedLong;
	}
	
	public int randomInt(int min, int max){
		int number = min + (int) (Math.random() * (max - min));
		return number;
	}
	
	public void getBoltType(Player player){
		int num = randomInt(0,3);
		if(num == 0){
			BoltPlayer();
		}else if(num == 1){
			BoltRandomLocation();
		}else{
			BoltRandomEntity();
		}
	}
	@Override
    public void onEnable() {
		JavaPlugin plugin = this;
		Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable()
        {
            public void run()
            {			
            	int numPlayers = Bukkit.getOnlinePlayers().size();
            	if(numPlayers > 0){
            		int random = new Random().nextInt(numPlayers);
            		Player player = (Player)Bukkit.getOnlinePlayers().toArray()[random];
            		getBoltType(player);
            	}
            }
        }, 20L, randomNumberTime());
    }
    @Override
    public void onDisable() {
    }
    

}
