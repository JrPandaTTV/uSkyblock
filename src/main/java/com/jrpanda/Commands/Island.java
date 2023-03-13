package com.jrpanda.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Island implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("island")){
            if(args.length == 0){
                if(args[0].equalsIgnoreCase("create")){

                }
                if(args[0].equalsIgnoreCase("home")){

                }
                if(args[0].equalsIgnoreCase("delete")){

                }
                if(args[0].equalsIgnoreCase("settings")){

                }
            } // close args 0
            if(args.length == 1){
                if(args[0].equalsIgnoreCase("visit")){

                }
                if(args[0].equalsIgnoreCase("warp")){

                }
            }


        }



        return false;
    }
}
