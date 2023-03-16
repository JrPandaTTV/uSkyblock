package com.jrpanda.Listener;

import com.jrpanda.Util.Helper;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChat implements Listener {
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event){
        if(event.getMessage().contains("<3")) {
            event.setMessage(event.getMessage().replace("<3", "❤"));
        }
        String prefix = "&8[&fDefault&8] &7";
        String suffix = "&7";
        Player player = event.getPlayer();
        String message = event.getMessage();
        if(player.isOp()){
            suffix = "&c";
            prefix = "&f&l[&c&lOP&f&l] ";
            if(player.getName().equalsIgnoreCase("JrPanda")){
                prefix = "&f&l[&b&lDEV&f&l] ";
                suffix = "&b";
            }
            if(player.getName().equalsIgnoreCase("HaelFire")){
                prefix = "&8&l[&4&k;;&c&lADMIN&4&k;;&8&l] ";
            }
            event.setFormat(Helper.toColor(prefix + player.getDisplayName() + " &8&l» " + suffix + message));
            return;
        }
        event.setFormat(Helper.toColor(prefix + player.getDisplayName() + " &8&l» " + suffix) + message);
    }
}
