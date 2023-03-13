package com.jrpanda.Commands;

import com.jrpanda.Util.Helper;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class CommandInvsee implements CommandExecutor{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("invsee")){
            if(!(sender instanceof Player)){
                return true;
            }
            Player player = (Player) sender;
            if(args.length == 1){
                Player target = Bukkit.getPlayer(args[0]);
                if(target == null){ return Helper.send(player, "&cPlayer not found!"); }
                Inventory inv = target.getInventory();
                player.openInventory(inv);
                return true;
            }


        }

        return false;
    }
}
