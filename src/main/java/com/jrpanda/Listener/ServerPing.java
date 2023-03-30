package com.jrpanda.Listener;

import com.jrpanda.Util.Helper;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class ServerPing implements Listener {
    @EventHandler
    public void onServerPing(ServerListPingEvent event){
        /*event.setMotd(Helper.toColor("                &6&l>> &e⭐ Twinkle Twinkle &e⭐ &6&l<<" +
                "\n  &a&l24/7 Online &f&l| &b&lFriendly Staff &f&l| &c&lDaily Events!"));
         */
        event.setMotd(Helper.hexColor(""));
    }
}
