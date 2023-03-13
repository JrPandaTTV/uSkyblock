package com.jrpanda.Listener;

import com.jrpanda.Util.CustomFile;
import com.jrpanda.Util.Helper;
import com.jrpanda.Util.LocHelper;
import com.jrpanda.uskyblock.Main;
import com.jrpanda.uskyblock.PlayerDB;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

public class PlayerConnection implements Listener {
    private Main main;
    public PlayerConnection(Main main){
        this.main = main;
    }
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        if(player.isOp()){
            event.setJoinMessage(Helper.toColor("&f&l[&c&lOP&f&l] &f" + player.getName() +
                    " has entered the server."));
        }
        CustomFile file = new CustomFile("plugins/uSkyblock/warps.yml");
        String path = "Warps.spawn";
        Location spawn = LocHelper.loadLocation(file, path);
        player.teleport(spawn);

        File playerFile = new File(main.getDataFolder() + "/PlayerData", player.getUniqueId() + ".yml");
        PlayerDB db = new PlayerDB(player.getUniqueId());
        if(!playerFile.exists()){
            try {
                playerFile.createNewFile();
            } catch (IOException e){
                main.getServer().getLogger().log(Level.SEVERE, "Can't create " + player.getName() + " user file.");
            }
        }
        db.onLogin();
        db.save(true);
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event){
        Player player = event.getPlayer();
        PlayerDB db = new PlayerDB(player.getUniqueId());
        db.onLogout();
        db.save(false);
    }

}
