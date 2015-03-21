package net.larskristian.api.facade;

import net.larskristian.core.exception.ExceptionMessages;
import net.larskristian.core.exception.type.PageNotFoundException;
import net.larskristian.framework.path.UriPaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lars K. Johansen
 */
@RestController
public class ApiController {

    private static final Logger LOG = LogManager.getLogger(ApiController.class);

    @RequestMapping(value = UriPaths.API_WILDCARD)
    public ResponseEntity<Void> wildcard() {
        LOG.info("Entered ApiController.wildcard");
        throw new PageNotFoundException(ExceptionMessages.MESSAGE_PAGE_NOT_FOUND);
    }
}
