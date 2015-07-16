package net.larskristian.api.dto.services.impl;

import net.larskristian.api.dto.User;
import net.larskristian.api.dto.services.UserMediationService;
import net.larskristian.core.context.SessionContext;
import net.larskristian.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Lars K. Johansen
 */
@Component
public class UserMediationServiceImpl implements UserMediationService {

    @Autowired
    private UserService userService;

    @Autowired
    private SessionContext sessionContext;

    @Override
    public User getCurrentUser() {
        String currentUserId = sessionContext.getUserId();
        return getUser(currentUserId);
    }

    @Override
    public User getUser(String userId) {
        return toMediatedUser(userService.getUser(userId));
    }

    @Override
    public void updateLocaleForCurrentUser(User user) {
        net.larskristian.core.dao.dto.User currentUser = userService.getUser(sessionContext.getUserId());
        currentUser.setLocale(user.getLocale());
        userService.updateUser(currentUser.getEmail(), currentUser);
    }

    public static User toMediatedUser(net.larskristian.core.dao.dto.User persisted) {
        User mediated = new User();
        mediated.setId(persisted.getId());
        mediated.setEmail(persisted.getEmail());
        mediated.setFirstName(persisted.getFirstName());
        mediated.setLastName(persisted.getLastName());
        mediated.setProfilePicture(persisted.getProfilePicture());
        mediated.setLocale(persisted.getLocale());
        return mediated;
    }

}
