package com.jrpanda.Listener;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class ObsToLava implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e){
        Block b = e.getClickedBlock();
        if(e.getAction() == Action.RIGHT_CLICK_BLOCK && b.getType() == Material.OBSIDIAN){
            Player p = e.getPlayer();
            ItemStack item = p.getInventory().getItemInMainHand();
            if(item.getType() == Material.BUCKET){
                b.setType(Material.AIR);
                item.setType(Material.LAVA_BUCKET);
            }
        }
    }

}
