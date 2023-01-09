package me.ninjego.reback.events;

import me.ninjego.reback.Reback;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class MoveEvent implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent event) {

        Player player = event.getPlayer();

        if(!Reback.getInstance().getPlayerManager().contains(player)) {
            return;
        }



    }

}
