package me.ninjego.reback.commands.impl;

import me.ninjego.reback.Reback;
import me.ninjego.reback.commands.SubCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

//Command to start capturing timestamps
public class StartCommand extends SubCommand {

    @Override
    public String getCommand() {
        return "start";
    }

    @Override
    public void call(Player player, String[] args) {

        if(args[1] == null)
            player.sendMessage(ChatColor.RED + "Invalid Arguments: Target not found");

        Player target = Bukkit.getPlayerExact(args[1]);
        if(target == null) {
            player.sendMessage(ChatColor.RED + "Invalid Player: Couldn't find target");
        }

        Reback.getInstance().getPlayerManager().setTrack(target, true);
        player.sendMessage(ChatColor.DARK_GREEN + "You have turned tracking " + ChatColor.GREEN + "ON" + ChatColor.DARK_GREEN + " for " + target.getName());
    }
}
