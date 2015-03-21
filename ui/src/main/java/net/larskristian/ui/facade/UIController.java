package net.larskristian.ui.facade;

import net.larskristian.core.exception.ExceptionMessages;
import net.larskristian.core.exception.type.PageNotFoundException;
import net.larskristian.framework.path.UriPaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Lars K. Johansen
 */
@Controller
@RequestMapping(value = UriPaths.UI_HOME)
public class UIController {

    private static final Logger LOG = LogManager.getLogger(UIController.class);

    @RequestMapping(value = UriPaths.UI_HOME, method = RequestMethod.GET)
    public String getPage(HttpServletRequest request) {
        LOG.info("Fetched website with requestURI={}", request.getRequestURI());
        return UriPaths.JSP_HOME;
    }

    @RequestMapping(value = UriPaths.UI_WILDCARD)
    public String wildcard() {
        throw new PageNotFoundException(ExceptionMessages.MESSAGE_PAGE_NOT_FOUND);
    }
}