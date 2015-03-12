package net.larskristian.api.facade;

import net.larskristian.api.dto.User;
import net.larskristian.core.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lars K. Johansen
 */
@RestController
@RequestMapping("/rest")
public class RestUserController {

    private static final Logger LOG = LogManager.getLogger(RestUserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public User getUser(ModelMap model) {
        LOG.info("Entered RestUserController.getUser");

        model.addAttribute("message", userService.getUser("123"));

        return new User();
    }
}
