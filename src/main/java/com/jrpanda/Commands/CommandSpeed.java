package com.jrpanda.Commands;

import com.jrpanda.Util.Helper;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSpeed implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("speed")){
            Player player = (Player) sender;
            if(args.length == 0){
                if(player.isFlying()){ return Helper.send(sender, "&eFlying speed is " + player.getFlySpeed()); }
                else { return Helper.send(sender, "&eWalking speed is " + player.getWalkSpeed()); }
            }
            if(args.length == 1){
                Float speed = Float.parseFloat(args[0])/10;
                if(speed > 1 || speed < -1 ){
                    speed = speed%1;
                }
                if(player.isFlying()){
                    player.setFlySpeed(speed);
                    return Helper.send(sender, "&eSet flying speed to " + speed*10);
                } else {
                    player.setWalkSpeed(speed);
                    return Helper.send(sender, "&eSet walking speed to "+ speed*10);
                }
            }

        }
        return false;
    }
}
