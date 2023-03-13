package com.jrpanda.Commands;

import com.jrpanda.Util.CustomFile;
import com.jrpanda.Util.Helper;
import com.jrpanda.Util.LocHelper;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class CommandWarp implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("warp")){
            if(!(sender instanceof Player)){ return Helper.send(sender, "&4Not a player!"); }
            Player player = (Player) sender;
            CustomFile file = new CustomFile("plugins/uSkyblock/warps.yml");
            if(args.length == 0){
                ArrayList<String> list = new ArrayList<>();
                for(String s : file.getConfig().getConfigurationSection("Warps").getKeys(false)){
                    list.add(s);
                }
                return Helper.send(player, "&6Warps: &e" + list);
            }
            if(args.length == 1){
                String path = "Warps." + args[0].toLowerCase();
                Location location = LocHelper.loadLocation(file, path);
                if(location == null){return Helper.send(player, "&cWarp does not exist!");}
                player.teleport(location);
                return Helper.send(player,"&6Teleporting...");
            } else { return Helper.send(player, "&cNot enough args!"); }
        }
        return true;
    }
}
