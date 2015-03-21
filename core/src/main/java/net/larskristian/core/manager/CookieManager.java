package net.larskristian.core.manager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Lars K. Johansen
 */
public interface CookieManager {

    String SESSION_COOKIE_NAME = "sessionId";

    /**
     * Returns the cookie based on the {@code name}.
     *
     * @param name The name associated with the cookie.
     * @return String the cookie if found.
     */
    String getCookie(String name, HttpServletRequest httpServletRequest);

    /**
     * Saves the cookie with specified {@code value} and {@code name} at the {@code httpServletResponse}.
     *
     * @param name The name for the cookie.
     * @param value The value for the cookie.
     * @param secure Flag that decides whether this cookie should be set via HTTPS.
     * @param httpServletResponse The httpServletResponse to set the cookie at.
     */
    void addSessionCookie(String name, String value, boolean secure, HttpServletResponse httpServletResponse);

    /**
     * Deletes the cookie with specified {@code name} at the {@code httpServletResponse}.
     *
     * @param name The name for the cookie.
     * @param httpServletResponse The httpServletResponse to set the cookie for deletion.
     */
    void deleteCookie(String name, HttpServletResponse httpServletResponse);
}
