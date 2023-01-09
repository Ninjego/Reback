package me.ninjego.reback.managers;

import me.ninjego.reback.Reback;
import me.ninjego.reback.timestamp.Timestamp;
import me.ninjego.reback.timestamp.User;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TrackManager {

    private final HashMap<User, List<Timestamp>> playerList;

    public TrackManager() {
        playerList = new HashMap<>();
    }

    public void registerPlayer(Player player) {
        User user = Reback.getInstance().getPlayerManager().getUser(player);
        if(playerList.containsKey(user)) {
            user.setTrack(true);
            return;
        }
        playerList.put(user, new ArrayList<>()); // Track player
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
