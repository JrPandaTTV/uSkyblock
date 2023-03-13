package com.jrpanda.Commands;

import com.jrpanda.Util.Helper;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandKickall implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("kickall")) {
            Player player = (Player) sender;
            for (Player target : Bukkit.getOnlinePlayers()) {
                if (!target.equals(player)) {
                    if (!target.isOp()) {
                        Helper.disconnectPlayer(target);
                    }
                }

            }
            return Helper.send(sender, "&6Players has been kicked successfully!");


        }
        return true;
    }
}