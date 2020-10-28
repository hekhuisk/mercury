package hekhuis.mercury.service;

import hekhuis.mercury.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    private static Map<Long, User> userMap = new HashMap<>();

    private static long newUserID = 1;

    static {
        User user = new User();
        user.setUserID(newUserID++);
        user.setUsername("KyleHekhuis");
        userMap.put(user.getUserID(), user);
    }

    // Will probably need to make separate methods for create and update since update needs to make sure current logged in person is the same as one being updated

    public User updateUser(long userID, User user) throws Exception {
        User existingUser = userMap.get(userID);
        if (existingUser == null) {
                throw new Exception("User does not exist");
        }
        user.setUserID(userID);
        userMap.replace(existingUser.getUserID(), user);

        return user;
    }

    public User createUser(User user) {
        user.setUserID(newUserID++);
        userMap.put(user.getUserID(), user);

        return user;
    }

    public User getUser(long userID) {
        return userMap.get(userID);
    }

    public void deleteUser(long userID) {
        userMap.remove(userID);
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(userMap.values());
    }
}
