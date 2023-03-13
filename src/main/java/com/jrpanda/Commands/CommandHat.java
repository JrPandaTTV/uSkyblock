package com.jrpanda.Commands;

import com.jrpanda.Util.Helper;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CommandHat implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("hat")){
            if(!(sender instanceof Player)){ return true;}
            Player player = (Player) sender;
            ItemStack item = player.getInventory().getItemInMainHand();
            ItemStack helm = player.getInventory().getHelmet();
            if((item.getType() == Material.AIR) || (item==null)){
                if((helm.getType() == Material.AIR) || (helm==null)) {return Helper.send(player, "&eBzzz, an error has occured.");}
                player.getInventory().addItem(helm);
                player.getInventory().setHelmet(null);
                return Helper.send(player, "&6Hat has been removed.");
            }
            if(!(helm ==null)) {
                player.getInventory().addItem(helm);
                player.getInventory().setHelmet(null);
            }
            player.getInventory().setHelmet(item);
            player.getInventory().setItemInMainHand(null);
            return Helper.send(player, "&6Enjoy your new hat!");
        }
        return false;
    }
}
