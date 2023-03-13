package com.jrpanda.Commands;

import com.jrpanda.Util.CustomFile;
import com.jrpanda.Util.Helper;
import com.jrpanda.Util.LocHelper;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandDelwarp implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("delwarp")){
            if(!(sender instanceof Player)){ return Helper.send(sender, "&4Not a player!"); }
            Player player = (Player) sender;
            CustomFile file = new CustomFile("plugins/uSkyblock/warps.yml");
            if(args.length == 1){
                String path = "Warps." + args[0].toLowerCase();
                if(LocHelper.loadLocation(file, path) == null){ return Helper.send(player, "&cInvalid warp! Please check again!"); }
                LocHelper.deleteLocation(file, path);
                return Helper.send(player,"&6Warp has been deleted!");
            } else { return Helper.send(player, "&cNot enough args!"); }
        }
        return true;
    }
}
