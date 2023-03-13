package com.jrpanda.Commands;

import com.jrpanda.Util.Helper;
import com.jrpanda.uskyblock.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.ArrayList;

public class CommandVanish implements CommandExecutor, Listener {
    private ArrayList<Player> vanished = new ArrayList<>();
    private Main main;
    public CommandVanish(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("vanish")){
            if(!(sender instanceof Player)){
                return true;
            }
            Player player = (Player) sender;
            if(!vanished.contains(player)){
                for(Player other : Bukkit.getOnlinePlayers()){
                    if(!other.isOp()) {
                        other.hidePlayer(main, player);
                    }
                }
                vanished.add(player);
                return Helper.send(player, "&eYou have been vanished!");
            } else {
                for(Player other : Bukkit.getOnlinePlayers()){
                    other.showPlayer(main, player);
                }
                vanished.remove(player);
                return Helper.send(player, "&eYou have unvanished!");
            }
        }
        return false;
    }
}
