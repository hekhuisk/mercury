package hekhuis.mercury.service;

import hekhuis.mercury.entity.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    private static Map<Long, User> userMap = new HashMap<>();

    private static long newUserID = 1;

    // Will probably need to make separate methods for create and update since update needs to make sure current logged in person is the same as one being updated

    public User saveUser(User user) throws Exception {
        User existingUser = userMap.get(user.getUserID());
        if (existingUser != null) {
            if (existingUser.getUserID() != user.getUserID()) {
                throw new Exception("Invalid user ID");
            }
            userMap.replace(existingUser.getUserID(), user);
        } else {
            user.setUserID(newUserID++);
            userMap.put(user.getUserID(), user);
        }

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
