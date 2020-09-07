package hekhuis.mercury.service;

import hekhuis.mercury.entity.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    private static Map<Long, User> userMap = new HashMap<>();

    public User saveUser(User user) {
        userMap.put(user.getUserID(), user);
        return user;
    }

    public User getUser(long userID) {
        return userMap.get(userID);
    }

    public void deleteUser(long userID) {

    }

    public List<User> getAllUsers() {
        return (List<User>) userMap.values();
    }
}
