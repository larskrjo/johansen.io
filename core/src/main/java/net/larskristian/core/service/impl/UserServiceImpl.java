package net.larskristian.core.service.impl;

import net.larskristian.core.dao.dto.User;
import net.larskristian.core.manager.UserManager;
import net.larskristian.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Lars K. Johansen
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserManager userManager;

    @Override
    public User getUser(String userId) {
        return userManager.getUser(userId);
    }

    @Override
    public User getUserWithEmail(String email) {
        return userManager.getUserWithEmail(email);
    }

    @Override
    public User getUserWithEmailAndPassword(String email, String password) {
        return userManager.getUserWithEmailAndPassword(email, password);
    }

    public User createUser(User user) {
        return userManager.createUser(user);
    }

    public User updateUser(String email, User user) {
        return userManager.updateUser(email, user);
    }

}
