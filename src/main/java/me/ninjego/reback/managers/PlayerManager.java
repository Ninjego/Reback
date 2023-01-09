package me.ninjego.reback.managers;

import me.ninjego.reback.timestamp.User;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PlayerManager {

    private List<User> userList;

    public PlayerManager() {
        userList = new ArrayList<>();
    }

    public void setupUser(Player player) {

        boolean exists = false;
        for(int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            if(user.getPlayer() != player && user.getPlayer() != null) {
                continue;
            }

            if(user.getUuid() != player.getUniqueId() && user.getUuid() != null) {
                continue;
            }

            user.setPlayer(player);
            user.setUuid(player.getUniqueId());
            userList.set(i, user);
            exists = true;
        }

        if(exists) {
           return;
        }

        User user = new User(player, player.getUniqueId());
        userList.add(user);
    }

    public void setupUser(UUID uuid) {

        boolean exists = false;
        for(int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            if(user.getPlayer() != Bukkit.getPlayer(uuid) && user.getPlayer() != null) {
                continue;
            }

            if(user.getUuid() != uuid && user.getUuid() != null) {
                continue;
            }

            user.setPlayer(Bukkit.getPlayer(uuid));
            user.setUuid(uuid);
            userList.set(i, user);
            exists = true;
        }

        if(exists) {
            return;
        }

        User user = new User(Bukkit.getPlayer(uuid), uuid);
        userList.add(user);
    }

    public User getUser(Player player) {
        return userList.stream().filter(user -> user.getPlayer() == player).findFirst().orElse(null);
    }

    public User getUser(UUID uuid) {
        return userList.stream().filter(user -> user.getUuid() == uuid).findFirst().orElse(null);
    }
}
