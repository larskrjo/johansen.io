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
    UserManager userManager;

    @Override
    public User getUser(String userId) {
        return userManager.getUser(userId);
    }

    public void NOTHIN() {
        if (true) {

        }
    }

}
