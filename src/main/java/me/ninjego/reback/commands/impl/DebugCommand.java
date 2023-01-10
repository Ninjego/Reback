package me.ninjego.reback.commands.impl;

import me.ninjego.reback.commands.SubCommand;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class DebugCommand extends SubCommand {

    public static List<Player> debugList = new ArrayList<>();

    @Override
    public String getCommand() {
        return "debug";
    }

    @Override
    public void call(Player player, String[] args) {
        if(debugList.contains(player)) {
            debugList.remove(player);
            player.sendMessage(ChatColor.DARK_GREEN + "You have toggled debug mode " + ChatColor.RED + "OFF");
        } else {
            debugList.add(player);
            player.sendMessage(ChatColor.DARK_GREEN + "You have toggled debug mode " + ChatColor.RED + "ON");
        }
    }
}
