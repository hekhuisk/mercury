package hekhuis.mercury.dao;

import hekhuis.mercury.entity.User;

import java.util.HashMap;
import java.util.Map;

public class UserDAO {

    public static Map<Integer, User> userMap = new HashMap<>();

    public void createUser(User user) {
        userMap.put(user.getUserID(), user);
    }

    public User getUser(int userID) {
        return userMap.get(userID);
    }

    public void updateUser(User user) {
        userMap.replace(user.getUserID(), user);
    }

    public void deleteUser(int userID) {
        userMap.remove(userID);
    }
}
