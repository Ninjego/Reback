package me.ninjego.reback.timestamp;

import org.bukkit.entity.Player;

import java.util.UUID;

public class User {

    private Player player;
    private UUID uuid;
    private boolean track;

    public User(Player player, UUID uuid) {
        this.player = player;
        this.uuid = uuid;
        this.track = false;
    }

    public UUID getUuid() {
        return uuid;
    }

    public Player getPlayer() {
        return player;
    }

    public boolean isTrack() {
        return track;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setTrack(boolean track) {
        this.track = track;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}
