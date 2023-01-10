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

    public void toggleTrack(Player player) {

        // Check if player is setup
        if(getUser(player) == null) {
            setupUser(player);
        }

        User user = getUser(player);
        user.setTrack(!user.isTrack()); // Toggle track variable
        updateUser(user); // Update user in userList
    }

    public void setTrack(Player player, boolean bool) {
        if(getUser(player) == null) {
            setupUser(player);
        }

        User user = getUser(player);
        user.setTrack(bool);
        updateUser(user);
    }

    public void setupUser(Player player) {

        boolean exists = false;
        for(int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            if(user.getPlayer() != player && user.getPlayer() != null) {
                continue;
            }

            user.setPlayer(player);
            userList.set(i, user);
            exists = true;
        }

        if(exists) {
           return;
        }

        User user = new User(player);
        userList.add(user);
    }

    public User getUser(Player player) {
        return userList.stream().filter(user -> user.getPlayer() == player).findFirst().orElse(null);
    }

    public void updateUser(User user) {

        //Getting the index of the user.

        for(int i = 0; i < userList.size(); i++) {
            User u = userList.get(i);

            if(u == user) {
                userList.set(i, user);
            }
        }
    }

}
