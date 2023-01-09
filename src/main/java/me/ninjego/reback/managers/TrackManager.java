package me.ninjego.reback.managers;

import me.ninjego.reback.timestamp.Timestamp;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TrackManager {

    private final HashMap<Player, List<Timestamp>> playerList;

    public TrackManager() {
        playerList = new HashMap<>();
    }

    public void registerPlayer(Player player) {
        if(playerList.containsKey(player)) {

        }
        playerList.put(player, new ArrayList<>()); // Track player
    }

    public void unregisterPlayer(Player player) {
        playerList.remove(player); // Stop tracking player
    }

    public boolean contains(Player player) {
        //if(playerList.contains(player)) {
       //     return true;
        //}

        return false;
    }

    public HashMap<Player, List<Timestamp>> getPlayerList() {
        return playerList;
    }
}
