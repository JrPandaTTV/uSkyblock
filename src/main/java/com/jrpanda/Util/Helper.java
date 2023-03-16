package com.jrpanda.Util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.bukkit.ChatColor.COLOR_CHAR;

public class Helper {
    public static boolean send(CommandSender sender, String msg){
        sender.sendMessage(Helper.toColor(msg));
        return true;
    }
    public static String toColor(String msg){
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    public static String compileText(String[] args){
        StringBuilder sb = new StringBuilder();
        for (String arg : args) {
            sb.append(arg).append(" ");
        }
        return sb.toString();
    }
    public static void sendTitle(Player player, String title, String msg, int fade, int stay, int out){
        player.sendTitle(toColor("&e&l" + title),
                toColor("&r&l"+msg),
                fade, stay, out);
    }

    public static void disconnectPlayer(Player player){
        player.kickPlayer(toColor("&eYou have been disconnected from the server. " +
                "\nReason: " +
                "\nTest"));
    }

    public static void announceMessage(String msg){
        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', msg));
    }


}
