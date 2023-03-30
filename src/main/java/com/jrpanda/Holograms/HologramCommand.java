package com.jrpanda.Holograms;

import com.jrpanda.Util.Helper;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class HologramCommand implements CommandExecutor {
    /*
    Holograms:
        test:
            created: JrPanda
            text:["Header", "line 1", "line 2"]
            coords:
                 X:
                 Y:
                 Z:
     */
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("hologram")) {
            if (!(sender instanceof Player)) {
                return Helper.send(sender, "&cPlayer only command");
            }
            Player player = (Player) sender;
            if(args.length == 1){
                if(args[0].equalsIgnoreCase("help")){
                    Helper.send(player,"&e&l----- &6&lHolograms Commands &e&l-----");
                    Helper.send(player,"&d/hologram create <name> [text]");
                    Helper.send(player,"&d/hologram delete <name>"); //
                    Helper.send(player,"&d/hologram edit <name>"); //
                    Helper.send(player,"&d/hologram list [page]"); //
                    Helper.send(player,"&d/hologram movehere <name>"); //
                    Helper.send(player,"&d/hologram reload"); //
                    Helper.send(player,"&d/hologram teleport <name>"); //
                    Helper.send(player,"&e&l----- &6&lHolograms Commands &e&l-----");
                    return true;
                }
            }
            if(args.length >= 3){
                args = Arrays.copyOfRange(args, 2, args.length);
                String msg = Helper.compileText(args);
                spawnHologram(player, msg);
                return Helper.send(player, "&bHologram created successfully!");
            }

        }
        return false;
    }

    public void spawnHologram(Player player, String args){
        Location location = player.getLocation();
        ArmorStand stand = (ArmorStand) player.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);

        stand.setInvisible(true);
        stand.setGravity(false);
        stand.setInvulnerable(true);

        stand.setCustomName(Helper.toColor(args));
        stand.setCustomNameVisible(true);

    }
}
