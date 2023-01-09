package me.ninjego.reback;

import org.bukkit.plugin.java.JavaPlugin;

public final class Reback extends JavaPlugin {

    private static Reback instance;

    public static Reback getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic

        //Set instance
        instance = this;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
