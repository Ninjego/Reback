package me.ninjego.reback.commands;

import me.ninjego.reback.commands.impl.DebugCommand;
import me.ninjego.reback.commands.impl.StartCommand;
import me.ninjego.reback.commands.impl.StopCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandManager implements CommandExecutor {

    public List<SubCommand> commandList = new ArrayList<>();

    public void registerSubCommands() {
        Bukkit.getLogger().info("---------- Loading Subcommands ----------");
        registerClass(new StartCommand());
        registerClass(new StopCommand());
        registerClass(new DebugCommand());
        Bukkit.getLogger().info("-----------------------------------------");
    }

    private void registerClass(SubCommand command) {
        commandList.add(command);
        Bukkit.getLogger().info("Loaded command: " + command.getCommand());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player))
            return true;

        Player player = (Player) sender;

        boolean found = false;

        for(SubCommand sub : commandList) {
            if(sub.getCommand().equalsIgnoreCase(args[0])) {
                sub.call(player, args);
                found = true;
                break;
            }
        }

        if(!found) {
            player.sendMessage(ChatColor.RED + "Invalid arguments: Command not found!");
        }

        return true;
    }
}
