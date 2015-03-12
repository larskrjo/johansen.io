package net.larskristian.ui.facade;

import net.larskristian.core.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Lars K. Johansen
 */
@Controller
@RequestMapping("/")
public class UserController {

    private static final Logger LOG = LogManager.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String getUser(ModelMap model) {
        LOG.info("Entered UserController.getUser");

        model.addAttribute("message", userService.getUser("123"));

        return "hello";
    }
}
