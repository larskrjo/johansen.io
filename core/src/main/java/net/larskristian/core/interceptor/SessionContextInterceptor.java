package net.larskristian.core.interceptor;

import net.larskristian.core.context.SessionContext;
import net.larskristian.core.dao.dto.Session;
import net.larskristian.core.exception.ExceptionMessages;
import net.larskristian.core.exception.type.session.InvalidSessionException;
import net.larskristian.core.manager.CookieManager;
import net.larskristian.core.manager.SessionManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * @author Lars K. Johansen
 */
public class SessionContextInterceptor implements HandlerInterceptor {

    private static final Logger LOG = LogManager.getLogger(SessionContextInterceptor.class);

    @Autowired
    private CookieManager cookieManager;

    @Autowired
    private SessionManager sessionManager;

    @Autowired
    private SessionContext sessionContext;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {
        String sessionId = cookieManager.getCookie(CookieManager.SESSION_COOKIE_NAME, httpServletRequest);

        Session session = null;
        if (Objects.isNull(sessionId)) {
            // send user to login page!
            if (!Objects.equals(httpServletRequest.getParameter("loggedIn"), "true")) {
                throw new InvalidSessionException(ExceptionMessages.MESSAGE_INVALID_SESSION);
            }
            // --- TEMP to log the user in ---
            session = sessionManager.createSession("de305d54-79b4-431b-adb2-eb6b9e546013");
            cookieManager.addSessionCookie(CookieManager.SESSION_COOKIE_NAME, session.getExternalId(), false, httpServletResponse);
            sessionId = session.getId();
        }

        session = sessionManager.getCurrentSession(sessionId);
        if (Objects.isNull(session)) {
            LOG.warn("Invalid session cookie was received. sessionId={}", sessionId);
            cookieManager.deleteCookie(CookieManager.SESSION_COOKIE_NAME, httpServletResponse);
            // send to login page!
        }

        sessionContext.enterContext(session);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler, Exception e) throws Exception {

    }
}
