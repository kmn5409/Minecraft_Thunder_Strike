package com.KeanuNichols.LightningStrike;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.Bukkit;

public class Bolt implements CommandExecutor{

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
		System.out.println("bolt");
		String name = sender.getName();				
		Player plr = Bukkit.getPlayer(name);
		Location loca = plr.getLocation();
		World world = plr.getWorld();
		world.strikeLightning(loca);
		return true;
	}
}
