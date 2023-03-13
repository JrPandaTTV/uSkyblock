package com.jrpanda.Commands;

import com.jrpanda.Util.Helper;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandBroadcast implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("broadcast")){
            if(args.length == 0){return Helper.send(sender, "&cPlease specify a message!");}
            Bukkit.broadcastMessage(Helper.toColor(" &6[&e&lBroadcast&6] &f" + Helper.compileText(args)));
            return true;
        }
        return false;
    }
}
