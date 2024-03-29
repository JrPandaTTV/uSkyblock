package com.jrpanda.uskyblock;

import com.jrpanda.Commands.*;
import com.jrpanda.Holograms.HologramCommand;
import com.jrpanda.Listener.*;
import com.jrpanda.Ranks.RankCommand;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import javax.security.auth.login.LoginException;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

public final class Main extends JavaPlugin {
    private JDA jda;
    private File playerFolder, rankFile;

    @Override
    public void onEnable() {
        //setupDiscord();
        registerListeners();
        registerCommands();

        playerFolder = new File(getDataFolder(), "PlayerData");
        if (!playerFolder.exists()) {
            playerFolder.mkdirs();
        }

        rankFile = new File(getDataFolder() , "groups.yml");
        if (!rankFile.exists()){
            try {
                rankFile.createNewFile();
            } catch (IOException e) {
                getServer().getLogger().log(Level.SEVERE, "Groups.yml cannot be created.");
            }
        }


    }



    @Override
    public void onDisable() {

    }

    public void setupDiscord(){
        JDABuilder builder = JDABuilder.createDefault("MTA4MjIxNzYxMDc1NTcwNjg5MA.GiJ6rI.ecJ7ZWP3agRbL-uzIN4x9Wesfyl1xNyqaRrRSs");
        builder.setActivity(Activity.watching("FrostMC"));
        builder.addEventListeners(new DiscordListener());
        jda = builder.build();
        System.out.println("Success!");
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
        registerCommand("feed", new CommandFeed());
        registerCommand("hat", new CommandHat());
        registerCommand("rank", new RankCommand());
        registerCommand("realtime", new CommandRealTime());
        registerCommand("hologram", new HologramCommand());

        registerCommand("island", new Island());
        //registerCommand("kits", new Kits());

    }

    public void registerListeners(){
        registerListener(new ObsToLava());
        registerListener(new PlayerChat());
        registerListener(new ServerPing());
        //registerListener(new CommandInvsee());
        registerListener(new GrapplingHook());
        registerListener(new PlayerConnection(this));
    }


    private void registerCommand(String name, CommandExecutor cmd){
        this.getCommand(name).setExecutor(cmd);
    }
    private void registerListener(Listener listener){
        Bukkit.getServer().getPluginManager().registerEvents(listener, this);
    }


}
