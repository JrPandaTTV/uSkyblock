package com.jrpanda.Commands;

import com.jrpanda.Util.Helper;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandWorkbench implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("workbench")) {
            if (!(sender instanceof Player)) {
                return Helper.send(sender, "");
            }
            Player player = (Player) sender;
            player.openWorkbench(null, true);
            return true;
        }
        return false;
    }
}
