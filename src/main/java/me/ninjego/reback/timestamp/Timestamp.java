package me.ninjego.reback.timestamp;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Timestamp {

    private Player player; // Current player
    private long time; // Timestamp of action
    private Location location; // Location

    public Timestamp(Player player, long time, Location location) {
        this.player = player;
        this.time = time;
        this.location = location;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
