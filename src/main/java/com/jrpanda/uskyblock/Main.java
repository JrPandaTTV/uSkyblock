package com.jrpanda.uskyblock;

import com.jrpanda.Commands.*;
import com.jrpanda.Listener.ObsToLava;
import com.jrpanda.Listener.PlayerChat;
import com.jrpanda.Listener.PlayerConnection;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class Main extends JavaPlugin {

    private File playerFolder;
    @Override
    public void onEnable() {
        registerListeners();
        registerCommands();

        playerFolder = new File(getDataFolder(), "PlayerData");
        if(!playerFolder.exists()){
            playerFolder.mkdirs();
        }
    }

    @Override
    public void onDisable() {


    }

    public void registerCommands(){
        registerCommand("tphere", new CommandTeleporthere());
        registerCommand("vanish", new CommandVanish(this));
        registerCommand("fly", new CommandFly());
        registerCommand("enderchest", new CommandEnderchest());
        registerCommand("nickname", new CommandNickname());
        registerCommand("tphere", new CommandTeleporthere());
        registerCommand("speed", new CommandSpeed());
        registerCommand("workbench", new CommandWorkbench());
        registerCommand("disposal", new CommandDisposal());
        registerCommand("broadcast", new CommandBroadcast());
        registerCommand("tpall", new CommandTeleportall());
        registerCommand("nightvision", new CommandNightvision());
        registerCommand("alert", new CommandAlert());
        registerCommand("kickall", new CommandKickall());
        registerCommand("setwarp", new CommandSetwarp());
        registerCommand("delwarp", new CommandDelwarp());
        registerCommand("warp", new CommandWarp());
        registerCommand("setspawn", new CommandSetspawn());
        registerCommand("spawn", new CommandSpawn());
        registerCommand("afk", new CommandAfk());
        registerCommand("heal", new CommandHeal());
        registerCommand("rename", new CommandRename());
        registerCommand("invsee", new CommandInvsee());
        //registerCommand("invsee", new CommandInvsee());
        registerCommand("hat", new CommandHat());

        registerCommand("island", new Island());
        //registerCommand("kits", new Kits());

    }

    public void registerListeners(){
        registerListener(new ObsToLava());
        registerListener(new PlayerChat());
        //registerListener(new CommandInvsee());
        registerListener(new PlayerConnection(this));
    }


    private void registerCommand(String name, CommandExecutor cmd){
        this.getCommand(name).setExecutor(cmd);
    }
    private void registerListener(Listener listener){
        Bukkit.getServer().getPluginManager().registerEvents(listener, this);
    }


}
