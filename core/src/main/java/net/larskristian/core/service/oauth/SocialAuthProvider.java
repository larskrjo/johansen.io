package net.larskristian.core.service.oauth;

import net.larskristian.core.dao.dto.User;

/**
 * @author Lars K. Johansen
 */
public interface SocialAuthProvider {

    /**
     * Get's the redirect uri to retrieve the access token.
     *
     * @param   baseUrl The url that represents the current server's url.
     * @return          The {@link String} with redirect info attached.
     */
    String getLoginUrl(String baseUrl);

    /**
     * Get's the redirect uri to retrieve the profile.
     *  @param   baseUrl           The url that represents the current server's url.
     * @param   authorizationCode The authorization code that proves the user authorized us to read access.
     */
    User finishLogin(String baseUrl, String authorizationCode);

}
