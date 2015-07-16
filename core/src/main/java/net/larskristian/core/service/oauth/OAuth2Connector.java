package net.larskristian.core.service.oauth;

import net.larskristian.core.service.dto.AccessToken;
import net.larskristian.core.service.dto.SocialProfile;

import java.util.Set;

/**
 * @author Lars K. Johansen
 */
public interface OAuth2Connector {

    /**
     * Gets the login redirect url for authorization.
     *
     * @param url The endpoint to invoke.
     * @param redirectUri The endpoint that should be redirected back to.
     * @param clientId The client id of the application.
     * @param scopes The scopes for which we want to be authorized against.
     * @return The login redirect url.
     */
    String getLoginUrl(String url, String redirectUri, String clientId, Set<String> scopes);

    /**
     * Gets the access token for the user.
     *
     * @param url The endpoint to invoke.
     * @param redirectUrl The endpoint that should be redirected back to.
     * @param clientId The client id of the application.
     * @param clientSecret The client secret of the application.
     * @param authorizationCode The code returned from authorization request.
     * @return The access token for the user associated with the authorization code.
     */
    AccessToken getAccessToken(String url, String redirectUrl, String clientId, String clientSecret, String authorizationCode);

    /**
     * Gets the profile for the user associated with the access token.
     *
     * @param url The endpoint to invoke.
     * @param accessToken The access token to use.
     * @return The profile for the user associated with the access token.
     */
    SocialProfile getProfile(String url, AccessToken accessToken);

}
