package net.larskristian.core.context.impl;

import net.larskristian.core.context.SessionContext;
import net.larskristian.core.dao.dto.AppType;
import net.larskristian.core.dao.dto.Session;
import net.larskristian.framework.exception.ExceptionMessages;
import net.larskristian.framework.exception.type.session.SessionException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * @author Lars K. Johansen
 */
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Component
public class SessionContextImpl implements SessionContext {

    private static final Logger LOG = LogManager.getLogger(SessionContextImpl.class);

    private Session session;

    @Override
    public void enterContext(Session session) {
        LOG.info("Entered session context with session={}", session);
        this.session = session;
    }

    @Override
    public String getUserId() {
        checkExistingSession();
        return session.getUserId();
    }

    @Override
    public String getSessionId() {
        checkExistingSession();
        return session.getId();
    }

    @Override
    public String getExternalSessionId() {
        checkExistingSession();
        return session.getExternalId();
    }

    @Override
    public AppType getAppType() {
        checkExistingSession();
        return session.getAppType();
    }

    @Override
    public boolean isAuthenticated() {
        return session != null;
    }

    private void checkExistingSession() {
        if (!isAuthenticated()) {
            throw new SessionException(ExceptionMessages.MESSAGE_INVALID_SESSION);
        }
    }

}
