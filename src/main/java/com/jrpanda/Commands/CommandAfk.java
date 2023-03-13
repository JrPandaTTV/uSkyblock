package com.jrpanda.Commands;

import com.jrpanda.Util.Helper;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class CommandAfk implements CommandExecutor {
    private ArrayList<Player> afk = new ArrayList<>();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("afk")){
            if(!(sender instanceof Player)){
                return true;
            }
            Player player = (Player) sender;
            if(!afk.contains(player)){
                afk.add(player);
                player.setCanPickupItems(false);
                Helper.announceMessage("&b" + player.getName() + " is now AFK!");
                return Helper.send(player, "&bYou are now AFK!");
            } else {
                afk.remove(player);
                player.setCanPickupItems(true);
                Helper.announceMessage("&b" + player.getName() + " is back!");
                return Helper.send(player, "&bYou are no longer AFK!");
            }
        }
        return false;

    }

}
