package com.jrpanda.Ranks;

import com.jrpanda.Util.CustomFile;
import com.jrpanda.Util.Helper;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class RankCommand implements CommandExecutor {
    private Ranks ranks = new Ranks();
    private CustomFile file;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("rank")){
            if(args.length == 0) {
                Helper.send(sender, "&b=======================");
                Helper.send(sender, "&6/rank create <name>");
                Helper.send(sender, "&6/rank promote <player>");
                Helper.send(sender, "&6/rank demote <player>");
                Helper.send(sender, "&6/rank add <perms>");
                Helper.send(sender, "&6/rank edit <args>");
                return true;
            }

            if(args.length == 2) {
                if (args[0].equalsIgnoreCase("create")) {
                    String path = args[1].toLowerCase();
                    ranks.setName(path);
                    return Helper.send(sender, "&aRanks created!");
                }
            }
        }

        return false;
    }
}
