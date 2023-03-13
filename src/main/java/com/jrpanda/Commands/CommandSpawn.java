package com.jrpanda.Commands;

import com.jrpanda.Util.CustomFile;
import com.jrpanda.Util.Helper;
import com.jrpanda.Util.LocHelper;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class CommandSpawn implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("spawn")){
            if(!(sender instanceof Player)){ return Helper.send(sender, "&4Not a player!"); }
            Player player = (Player) sender;
            CustomFile file = new CustomFile("plugins/uSkyblock/warps.yml");
            String path = "Warps.spawn";
            Location location = LocHelper.loadLocation(file, path);
            if(args.length == 0){
                if(location == null){return Helper.send(player, "&cSpawn does not exist!");}
                player.teleport(location);
                return Helper.send(player,"&6Teleporting...");
            }
            if(args.length == 1){
                Player target = Bukkit.getPlayer(args[0]);
                if(target == null){ return Helper.send(player, "&cPlayer not found!"); }
                target.teleport(location);
                return Helper.send(target,"&6Teleporting...");

            }else { return Helper.send(player, "&cNot enough args!"); }
        }
        return true;
    }
}
