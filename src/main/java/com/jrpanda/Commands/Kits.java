package com.jrpanda.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Kits implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("kits")){

        }

        return true;
    }


    /*
    kits:
      starter:
        -
        -
        cooldown: [duration]
      VIP1:
        -
        -
        cooldown: [duration]

     */
}
