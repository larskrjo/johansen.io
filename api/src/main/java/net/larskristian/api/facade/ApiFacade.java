package net.larskristian.api.facade;

import net.larskristian.framework.exception.ExceptionMessages;
import net.larskristian.framework.exception.type.PageNotFoundException;
import net.larskristian.framework.uri.UriPaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lars K. Johansen
 */
@RestController
public class ApiFacade {

    private static final Logger LOG = LogManager.getLogger(ApiFacade.class);

    @RequestMapping(value = UriPaths.API_WILDCARD)
    public ResponseEntity<Void> wildcard() {
        LOG.info("Entered ApiFacade.wildcard");
        throw new PageNotFoundException(ExceptionMessages.MESSAGE_ENDPOINT_NOT_FOUND);
    }
}
