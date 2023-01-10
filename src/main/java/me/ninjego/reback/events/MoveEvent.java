package me.ninjego.reback.events;

import me.ninjego.reback.Reback;
import me.ninjego.reback.commands.impl.DebugCommand;
import me.ninjego.reback.timestamp.Timestamp;
import me.ninjego.reback.timestamp.User;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class MoveEvent implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent event) {

        Player player = event.getPlayer();

        User user = Reback.getInstance().getPlayerManager().getUser(player);

        if(user == null) {
            return;
        }

        if(!user.isTrack()) {
            return;
        }

        Timestamp timestamp = new Timestamp(player, System.currentTimeMillis(), player.getLocation());
        user.getTimestampList().add(timestamp);
        for(Player debug : DebugCommand.debugList) {
            debug.sendMessage(timestamp.getPlayer() + ", " + timestamp.getTime() + ", " + timestamp.getLocation());
        }

    }

}
