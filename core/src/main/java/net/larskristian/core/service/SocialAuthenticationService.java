package net.larskristian.core.service;

/**
 * @author Lars K. Johansen
 */
public interface SocialAuthenticationService {

    /**
     * Get's the redirect uri to retrieve the access token.
     *
     * @param   baseUrl The url that represents the current server's url.
     * @return          The {@link String} with redirect info attached.
     */
    String getLoginUrl(String baseUrl);

    /**
     * Get's the redirect uri to retrieve the profile.
     *
     * @param   baseUrl           The url that represents the current server's url.
     * @param   authorizationCode The authorization code that proves the user authorized us to read access.
     * @return                    The {@link String} with redirect info attached.
     */
    String finishLogin(String baseUrl, String authorizationCode);

}
