package com.jrpanda.Commands;

import com.jrpanda.Util.Helper;
import com.jrpanda.Util.ItemBuilder;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CommandRename implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)){
            return true;
        }
        Player player = (Player) sender;
        if(args.length == 1) {
            ItemStack item = player.getInventory().getItemInMainHand();
            String msg = args[0].replace('_', ' ');
            item.setItemMeta(new ItemBuilder(item).setName(msg).build().getItemMeta());
            return Helper.send(player, "&6Item has been renamed!");
        }
        return false;
    }
}
