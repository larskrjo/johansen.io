package net.larskristian.api.dto.services.impl;

import net.larskristian.api.dto.User;
import net.larskristian.api.dto.services.UserMediationService;
import net.larskristian.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Lars K. Johansen
 */
@Component
public class UserMediationServiceImpl implements UserMediationService {

    @Autowired
    UserService userService;

    @Override
    public User getUser(String userId) {
        return toMediatedUser(userService.getUser(userId));
    }

    private static User toMediatedUser(net.larskristian.core.dao.dto.User persisted) {
        User mediated = new User();
        mediated.setFirstName(persisted.getFirstName());
        mediated.setLastName(persisted.getLastName());
        return mediated;
    }

}
