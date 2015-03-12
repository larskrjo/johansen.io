package net.larskristian.core.manager.impl;

import net.larskristian.core.dao.UserDao;
import net.larskristian.core.dao.dto.User;
import net.larskristian.core.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Lars K. Johansen
 */
@Component
public class UserManagerImpl implements UserManager {

    @Autowired
    UserDao userDao;

    @Override
    public User getUser(String userId) {
        return userDao.getUser(userId);
    }

}
