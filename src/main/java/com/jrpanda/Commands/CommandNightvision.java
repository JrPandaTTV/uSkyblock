package com.jrpanda.Commands;

import com.jrpanda.Util.Helper;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class CommandNightvision implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("nightvision")){
            if(!(sender instanceof Player)) { return true; }
            Player player = (Player) sender;
            if(player.hasPotionEffect(PotionEffectType.NIGHT_VISION)){
                player.removePotionEffect(PotionEffectType.NIGHT_VISION);
                return Helper.send(player, "&4&l» &c&lNightvision is &c&ldisabled.");
            }
            player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 1000000, 255, false, false));
            return Helper.send(player, "&2&l» &a&lNightvision is enabled.");
        }
        return false;
    }
}
