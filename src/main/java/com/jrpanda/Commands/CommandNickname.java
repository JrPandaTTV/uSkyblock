package com.jrpanda.Commands;

import com.jrpanda.Util.Helper;
import com.jrpanda.uskyblock.PlayerDB;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandNickname implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("nickname")){
            Player player = (Player) sender;
            if(args.length == 1){
                PlayerDB db = new PlayerDB(player.getUniqueId());
                if(args[0].equalsIgnoreCase("off")){
                    player.setDisplayName(player.getName());
                    db.setNickname("");
                    db.save(true);
                    return Helper.send(player, "&6Nickname has been removed!");
                }
                player.setDisplayName(Helper.toColor(args[0]));
                db.setNickname(args[0]);
                db.save(true);
                return Helper.send(player, "&6Nickname has been changed!");
            }
        }

        return false;
    }
}
