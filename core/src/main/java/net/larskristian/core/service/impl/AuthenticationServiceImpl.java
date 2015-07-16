package net.larskristian.core.service.impl;

import net.larskristian.core.dao.dto.User;
import net.larskristian.core.manager.SessionManager;
import net.larskristian.core.service.AuthenticationService;
import net.larskristian.core.service.UserService;
import net.larskristian.framework.encryption.EncryptionUtility;
import net.larskristian.framework.exception.ExceptionMessages;
import net.larskristian.framework.exception.type.user.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Lars K. Johansen
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private UserService userService;

    @Autowired
    private SessionManager sessionManager;

    @Override
    public User authenticate(String email, String password) {
        String shaPassword = EncryptionUtility.hash(password);
        User user = userService.getUserWithEmailAndPassword(email, shaPassword);
        if (user != null) {
           sessionManager.createSession(user.getId());
        } else {
            throw new UserException(ExceptionMessages.MESSAGE_USER_DID_NOT_EXIST_EXCEPTION);
        }
        return user;
    }
}
