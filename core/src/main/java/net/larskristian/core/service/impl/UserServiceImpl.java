package net.larskristian.core.service.impl;

import net.larskristian.core.dao.dto.User;
import net.larskristian.core.manager.UserManager;
import net.larskristian.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Lars K. Johansen
 */
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    UserManager userManager;

    @Override
    public User getUser(String userId) {
        return userManager.getUser(userId);
    }

}
