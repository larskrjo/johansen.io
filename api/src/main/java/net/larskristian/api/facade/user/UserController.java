package net.larskristian.api.facade.user;

import net.larskristian.api.dto.User;
import net.larskristian.api.dto.services.UserMediationService;
import net.larskristian.framework.path.UriPaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lars K. Johansen
 */
@RestController
public class UserController {

    private static final Logger LOG = LogManager.getLogger(UserController.class);

    @Autowired
    private UserMediationService userMediationService;

    @RequestMapping(value = UriPaths.API_USER, method = RequestMethod.GET)
    public User getUser() {
        LOG.info("Entered RestUserController.getUser");

        User user = userMediationService.getUser("de305d54-79b4-431b-adb2-eb6b9e546013");

        return user;
    }
}
