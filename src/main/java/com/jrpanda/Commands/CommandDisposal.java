package com.jrpanda.Commands;

import com.jrpanda.Util.Helper;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class CommandDisposal implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("disposal")){
            if(!(sender instanceof Player)){
                return true;
            }
            if(args.length == 0){
                Player player = (Player) sender;
                Inventory inv = Bukkit.createInventory(null, 36, Helper.toColor("&4Trash Bin"));
                player.openInventory(inv);
                return true;
            } else {
                return true;
            }
        }
        return false;
    }
}
