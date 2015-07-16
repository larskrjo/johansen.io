package net.larskristian.api.facade.authentication;

import net.larskristian.api.dto.Credentials;
import net.larskristian.api.dto.services.AuthenticationMediationService;
import net.larskristian.api.facade.EmptyResponse;
import net.larskristian.core.annotations.RequireSession;
import net.larskristian.core.context.SessionContext;
import net.larskristian.core.manager.CookieManager;
import net.larskristian.core.manager.SessionManager;
import net.larskristian.framework.exception.ExceptionMessages;
import net.larskristian.framework.exception.type.session.SessionException;
import net.larskristian.framework.uri.UriPaths;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Lars K. Johansen
 */
@RestController
public class AuthenticationFacade {

    private static final Logger LOG = LogManager.getLogger(AuthenticationFacade.class);

    @Autowired
    private AuthenticationMediationService authenticationMediationService;

    @Autowired
    private SessionContext sessionContext;

    @Autowired
    private SessionManager sessionManager;

    @Autowired
    private CookieManager cookieManager;

    @RequestMapping(value = UriPaths.API_AUTHENTICATE_USER, method = RequestMethod.POST)
    public EmptyResponse authenticateUser(HttpServletRequest request, HttpServletResponse response, @RequestBody Credentials credentials) {
        LOG.info("Entered AuthenticationFacade.authenticateUser");

        authenticationMediationService.authenticate(credentials);
        if (sessionContext.isAuthenticated()) {
            cookieManager.addSessionCookie(CookieManager.SESSION_COOKIE_NAME, sessionContext.getExternalSessionId(), false, request, response);
        }

        return new EmptyResponse();
    }

    @RequireSession
    @RequestMapping(value = UriPaths.API_INVALIDATE_SESSION, method = RequestMethod.DELETE)
    public EmptyResponse invalidateSession(HttpServletResponse response, @PathVariable String sessionId) {
        LOG.info("Entered AuthenticationFacade.invalidateSession");

        if (!StringUtils.equals(sessionId, sessionContext.getExternalSessionId())) {
            throw new SessionException(ExceptionMessages.MESSAGE_INVALID_SESSION);
        }
        sessionManager.deleteSession(sessionManager.getCurrentSession(sessionContext.getSessionId()));
        cookieManager.deleteCookie(CookieManager.SESSION_COOKIE_NAME, response);

        return new EmptyResponse();
    }
}
