package me.ninjego.reback;

import me.ninjego.reback.events.MoveEvent;
import me.ninjego.reback.managers.TrackManager;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Reback extends JavaPlugin {

    private static Reback instance;

    private TrackManager playerManager;

    public static Reback getInstance() {
        return instance;
    }

    public TrackManager getPlayerManager() {
        return playerManager;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic

        //Set instance
        instance = this;

        //Register playerManager
        playerManager = new TrackManager();

        //Register Event
        registerEvents();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void registerEvents() {
        PluginManager pm = this.getServer().getPluginManager();;
        pm.registerEvents(new MoveEvent(), this);
    }
}
