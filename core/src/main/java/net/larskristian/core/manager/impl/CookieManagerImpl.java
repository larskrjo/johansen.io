package net.larskristian.core.manager.impl;

import com.google.common.base.Objects;
import net.larskristian.core.manager.CookieManager;
import net.larskristian.framework.uri.UriPaths;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Lars K. Johansen
 */
@Service
public class CookieManagerImpl implements CookieManager {

    @Override
    public String getCookie(String name, HttpServletRequest httpServletRequest) {
        Cookie[] cookies = httpServletRequest.getCookies();
        if (cookies == null) {
            return null;
        }
        for (Cookie cookie : httpServletRequest.getCookies()) {
            if (Objects.equal(cookie.getName(), name)) {
                return cookie.getValue();
            }
        }
        return null;
    }

    @Override
    public void addSessionCookie(String name, String value, boolean secure, HttpServletRequest httpServletRequest,
                                 HttpServletResponse httpServletResponse) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath(UriPaths.ROOT);
        cookie.setSecure(httpServletRequest.isSecure());
        cookie.setMaxAge(-1); // Session scope
        httpServletResponse.addCookie(cookie);
    }

    @Override
    public void deleteCookie(String name, HttpServletResponse httpServletResponse) {
        Cookie cookie = new Cookie(name, null);
        cookie.setMaxAge(0); // Deletes cookie
        httpServletResponse.addCookie(cookie);
    }
}
