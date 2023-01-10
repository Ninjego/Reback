package me.ninjego.reback;

import me.ninjego.reback.commands.CommandManager;
import me.ninjego.reback.events.JoinEvent;
import me.ninjego.reback.events.MoveEvent;
import me.ninjego.reback.managers.PlayerManager;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Reback extends JavaPlugin {

    private static Reback instance;

    private PlayerManager playerManager;

    private CommandManager commandManager;

    public static Reback getInstance() {
        return instance;
    }

    public PlayerManager getPlayerManager() {
        return playerManager;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic

        //Set instance
        instance = this;

        //Register playerManager
        playerManager = new PlayerManager();

        //Register Event
        registerEvents();

        //Register CommandManager
        commandManager = new CommandManager();
        commandManager.registerSubCommands();
        this.getCommand("reback").setExecutor(commandManager);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void registerEvents() {
        PluginManager pm = this.getServer().getPluginManager();;
        pm.registerEvents(new MoveEvent(), this);
        pm.registerEvents(new JoinEvent(), this);
    }
}
