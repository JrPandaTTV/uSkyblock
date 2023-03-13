package com.jrpanda.Util;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class LocHelper {

    public static void saveLocation(CustomFile file, Player player, String path){
        FileConfiguration config = file.getConfig();
        config.set(path + ".X", player.getLocation().getX());
        config.set(path + ".Y", player.getLocation().getY());
        config.set(path + ".Z", player.getLocation().getZ());
        config.set(path + ".World", player.getLocation().getWorld().getName());
        config.set(path + ".Yaw", player.getLocation().getYaw());
        config.set(path + ".Pitch", player.getLocation().getPitch());
        file.save();
    }

    public static void deleteLocation(CustomFile file, String path){
        FileConfiguration config = file.getConfig();
        config.set(path, null);
        file.save();
    }

    public static Location loadLocation(CustomFile file, String path){
        FileConfiguration config = file.getConfig();
        if(!config.contains(path)){
            return null;
        }
        return new Location(Bukkit.getWorld(config.getString(path + ".World")),
                config.getDouble(path + ".X"),
                config.getDouble(path + ".Y"),
                config.getDouble(path + ".Z"),
                (float) config.getDouble(path + ".Yaw"),
                (float) config.getDouble(path + ".Pitch"));
    }

}
