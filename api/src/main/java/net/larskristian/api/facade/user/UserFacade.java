package net.larskristian.api.facade.user;

import net.larskristian.api.dto.User;
import net.larskristian.api.dto.services.UserMediationService;
import net.larskristian.api.facade.EmptyResponse;
import net.larskristian.core.annotations.RequireSession;
import net.larskristian.framework.exception.ExceptionMessages;
import net.larskristian.framework.exception.type.session.SessionException;
import net.larskristian.framework.uri.UriPaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Lars K. Johansen
 */
@RestController
public class UserFacade {

    private static final Logger LOG = LogManager.getLogger(UserFacade.class);

    @Autowired
    private UserMediationService userMediationService;

    @RequireSession
    @RequestMapping(value = UriPaths.API_USER_ME, method = RequestMethod.GET)
    public User getCurrentUser() {
        LOG.info("Entered UserFacade.getCurrentUser");

        User user = userMediationService.getCurrentUser();

        return user;
    }

    @RequireSession
    @RequestMapping(value = UriPaths.API_USER_ME_UPDATE, method = RequestMethod.PUT)
    public EmptyResponse updateLocale(@PathVariable String id, @RequestBody User user) {
        LOG.info("Entered UserFacade.updateLocale");

        if (!id.equals(user.getId())) {
            throw new SessionException(ExceptionMessages.MESSAGE_INVALID_SESSION);
        }
        userMediationService.updateLocaleForCurrentUser(user);

        return new EmptyResponse();
    }
}
