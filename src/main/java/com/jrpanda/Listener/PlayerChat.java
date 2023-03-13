package com.jrpanda.Listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChat implements Listener {
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event){
        if(event.getMessage().contains("<3")){
            event.setMessage(event.getMessage().replace("<3", "❤"));
        }

    }
}
