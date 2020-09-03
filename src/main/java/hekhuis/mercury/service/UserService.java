package hekhuis.mercury.service;

import hekhuis.mercury.dao.UserDAO;
import hekhuis.mercury.entity.User;

public class UserService {

    public static final UserDAO userDAO = new UserDAO();

    public void createUser(User user) {
        userDAO.createUser(user);
    }

    public User getUser(int userID) {
        return userDAO.getUser(userID);
    }

    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    public void deleteUser(int userID) {
        userDAO.deleteUser(userID);
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }
}
