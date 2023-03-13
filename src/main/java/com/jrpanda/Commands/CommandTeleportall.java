package com.jrpanda.Commands;

import com.jrpanda.Util.Helper;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandTeleportall implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("tpall")){
            if(!(sender instanceof Player)){
                return true;
            }
            Player player = (Player) sender;
            Helper.send(player, "&6Teleporting...");
            for(Player target : Bukkit.getOnlinePlayers()){
                target.teleport(player.getLocation());
            }
            return true;
        }

        return false;
    }
}
