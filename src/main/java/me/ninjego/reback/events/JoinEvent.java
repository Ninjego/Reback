package me.ninjego.reback.events;

import me.ninjego.reback.Reback;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Reback.getInstance().getPlayerManager().setupUser(e.getPlayer());
    }

}
