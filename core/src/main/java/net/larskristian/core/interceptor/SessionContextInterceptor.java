package net.larskristian.core.interceptor;

import net.larskristian.core.annotations.RequireSession;
import net.larskristian.core.context.SessionContext;
import net.larskristian.core.dao.dto.Session;
import net.larskristian.core.dao.dto.User;
import net.larskristian.core.manager.CookieManager;
import net.larskristian.core.manager.SessionManager;
import net.larskristian.core.manager.UserManager;
import net.larskristian.framework.exception.ExceptionMessages;
import net.larskristian.framework.exception.type.session.SessionException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

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

    @Autowired
    private UserManager userManager;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {
        Method method = ((HandlerMethod) handler).getMethod();

        String sessionId = cookieManager.getCookie(CookieManager.SESSION_COOKIE_NAME, httpServletRequest);

        if (sessionId == null) {
            if (method.isAnnotationPresent(RequireSession.class)) {
                LOG.warn("No session cookie was received.");
                throw new SessionException(ExceptionMessages.MESSAGE_INVALID_SESSION);
            }
        } else {
            Session session = sessionManager.getCurrentSession(sessionId);
            if (session == null) {
                LOG.warn("Invalid session cookie was received. sessionId={}", sessionId);
                cookieManager.deleteCookie(CookieManager.SESSION_COOKIE_NAME, httpServletResponse);
                if (method.isAnnotationPresent(RequireSession.class)) {
                    LOG.warn("No session cookie was received.");
                    throw new SessionException(ExceptionMessages.MESSAGE_INVALID_SESSION);
                }
            } else {
                sessionContext.enterContext(session);
            }
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler, ModelAndView modelAndView) throws Exception {
        if (modelAndView == null) {
            return;
        }
        if (sessionContext.isAuthenticated()) {
            User user = userManager.getUser(sessionContext.getUserId());
            modelAndView.addObject("locale", user.getLocale());
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler, Exception e) throws Exception {
        // Nothing to do
    }
}
