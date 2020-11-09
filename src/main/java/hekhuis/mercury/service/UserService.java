package hekhuis.mercury.service;

import hekhuis.mercury.entity.User;
import hekhuis.mercury.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User updateUser(long userID, User user) throws Exception {
        getUser(userID);
        user.setUserID(userID);
        return userRepository.save(user);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUser(long userID) throws Exception {
        User user = userRepository.findById(userID)
                                  .orElseThrow(() -> new Exception("User not found for this id :: " + userID));
        return user;
    }

    public void deleteUser(long userID) throws Exception {
        User user = getUser(userID);
        userRepository.delete(user);
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(userRepository.findAll());
    }
}
