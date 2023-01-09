package me.ninjego.reback.managers;

import me.ninjego.reback.timestamp.User;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

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
}
