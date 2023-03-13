package com.jrpanda.Commands;

import com.jrpanda.Util.Helper;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandEnderchest implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("enderchest")){
            if(!(sender instanceof Player)){ return Helper.send(sender, ""); }
            Player player = (Player) sender;
            if(args.length == 0) {
                player.openInventory(player.getEnderChest());
                return true;
            }
            if(args.length == 1){
                Player target = Bukkit.getPlayer(args[0]);
                if(target == null){ return Helper.send(player, "&cPlayer not found!"); }
                player.openInventory(target.getEnderChest());
                return true;
            } else {
                return Helper.send(player, "&eBzzz, error!");
            }
        }
        return false;
    }
}
