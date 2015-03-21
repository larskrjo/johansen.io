package net.larskristian.core.context.impl;

import net.larskristian.core.context.SessionContext;
import net.larskristian.core.dao.dto.Session;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * @author Lars K. Johansen
 */
@Service
public class SessionContextImpl implements SessionContext {

    private static final Logger LOG = LogManager.getLogger(SessionContextImpl.class);

    @Override
    public void enterContext(Session session) {
        LOG.info("Entered session context with session={}", session);
    }
}
