package com.jrpanda.Commands;

import com.jrpanda.Util.Helper;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

public class CommandHeal implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("heal")){
            if(!(sender instanceof Player)){
                return true;
            }
            Player player = (Player) sender;
            if(args.length == 0){
                healPlayer(player);
                return Helper.send(player, "&6You have been healed.");
            }
            if(args.length == 1){
                Player target = Bukkit.getPlayer(args[0]);
                if(target == null){ return Helper.send(player, "&cPlayer not found!"); }
                healPlayer(target);
                Helper.send(target, "&6You have been healed!");
                return Helper.send(player, "&6" + target.getName() + " has been healed.");
            }
        }
        return false;
    }

    public void healPlayer(Player player){
        for(PotionEffect pot : player.getActivePotionEffects()){
            player.removePotionEffect(pot.getType());
        }
        player.setHealth(20.0);
        player.setFoodLevel(20);
        player.setFreezeTicks(0);
        player.setFireTicks(0);
    }
}
