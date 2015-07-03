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

    @Autowired
    private UserDao userDao;

    @Override
    public User getUser(String userId) {
        return userDao.getUser(userId);
    }

}
