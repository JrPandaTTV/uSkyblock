package com.jrpanda.uskyblock;

import com.jrpanda.Util.CustomFile;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.time.Instant;
import java.util.UUID;

public class PlayerDB {
    private final UUID uuid;
    private String name, nickname, ip;
    private CustomFile file;
    private long lastlogin, lastdisconnect;

    public PlayerDB(UUID uuid){
        this.uuid = uuid;
        load();
    }


    private void load(){
        file = new CustomFile("plugins/uSkyblock/PlayerData/" + uuid.toString() + ".yml");
        name = getString("Name");
        nickname = getString("Nickname");
        lastlogin = getLong("Last-Login");
        lastdisconnect = getLong("Last-Disconnect");
    }

    public void save(boolean async){
        FileConfiguration config = file.getConfig();
        config.set("Name", name);
        config.set("Nickname", nickname);
        config.set("Last-Login", lastlogin);
        config.set("Last-Disconnect", lastdisconnect);

        if (async == true){ file.saveAsynchronously(); }
        else{ file.save(); }
    }
    public void onLogout(){
        this.lastdisconnect = Instant.now().toEpochMilli();
    }
    public void onLogin(){
        this.lastlogin = Instant.now().toEpochMilli();
        this.name = Bukkit.getPlayer(uuid).getName();
    }
    public void setNickname(String nickname){ this.nickname = nickname; }
    public void setName(String name){ this.name = name; }

    public long getLastLogin() { return lastlogin; }
    public long getLastDisconnect() { return lastdisconnect; }

    private String getString(String path){
        FileConfiguration config = file.getConfig();
        if (config.contains(path)){ return config.getString(path); }
        else return "";
    }

    private long getLong(String path){
        FileConfiguration config = file.getConfig();
        if (config.contains(path)){ return config.getLong(path); }
        else return -1;
    }

}
