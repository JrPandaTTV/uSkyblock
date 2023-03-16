package com.jrpanda.Commands;

import com.jrpanda.Util.Helper;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class CommandAlert implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("alert")){
            Player player = (Player) sender;
            if(args.length > 1){
                args = Arrays.copyOfRange(args, 1, args.length);
                String msg = Helper.compileText(args);
                if(args[0].equalsIgnoreCase("@a")){
                    for(Player player1 : Bukkit.getOnlinePlayers()){
                        Helper.sendTitle(player1, "&e&lALERT", msg, 5, 30, 45);
                    }
                    return Helper.send(player, "&6Alert has been sent!");
                }
                Player target = Bukkit.getPlayer(args[0]);
                if(target == null){ return Helper.send(player, "&cPlayer not found!"); }
                Helper.sendTitle(target, "&e&lALERT", msg, 5, 30, 45);
                return Helper.send(player, "&6Alert has been sent!~");
            }
        }
        return false;
    }


}
