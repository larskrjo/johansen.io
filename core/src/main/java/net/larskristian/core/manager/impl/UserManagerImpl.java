package net.larskristian.core.manager.impl;

import net.larskristian.core.dao.UserDao;
import net.larskristian.core.dao.dto.User;
import net.larskristian.core.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Lars K. Johansen
 */
@Service
public class UserManagerImpl implements UserManager {

    public static final String DEFAULT_LOCALE = "us";

    @Autowired
    private UserDao userDao;

    @Override
    public User getUser(String userId) {
        return userDao.getUser(userId);
    }

    @Override
    public User getUserWithEmail(String email) {
        return userDao.getUserWithEmail(email);
    }

    @Override
    public User getUserWithEmailAndPassword(String email, String password) {
        return userDao.getUserWithEmailAndPassword(email, password);
    }

    @Override
    public User updateUser(String email, User user) {
        return userDao.updateUser(email, user);
    }

    @Override
    public User createUser(User user) {
        return userDao.createUser(user);
    }

}
