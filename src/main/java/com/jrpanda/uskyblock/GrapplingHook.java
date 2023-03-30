package com.jrpanda.uskyblock;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;

public class GrapplingHook implements Listener {

    @EventHandler
    public void onPlayerHook(PlayerFishEvent event){
        Player player = event.getPlayer();
        Location location = event.getPlayer().getLocation();
        Location hook = event.getHook().getLocation();
        if(event.getState().equals(PlayerFishEvent.State.REEL_IN)){
            Location change = hook.subtract(location);
            player.setVelocity(change.toVector().multiply(0.25));
        }
    }
}
