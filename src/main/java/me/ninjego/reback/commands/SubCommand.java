package me.ninjego.reback.commands;

import org.bukkit.entity.Player;

public abstract class SubCommand {

    public abstract String getCommand();

    public abstract void call(Player player, String[] args);
}
