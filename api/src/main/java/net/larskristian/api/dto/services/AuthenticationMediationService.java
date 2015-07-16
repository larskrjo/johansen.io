package net.larskristian.api.dto.services;

import net.larskristian.api.dto.Credentials;

/**
 * @author Lars K. Johansen
 */
public interface AuthenticationMediationService {

    /**
     * Authenticates using the given {@code credentials}
     *
     * @param credentials The credentials for the user.
     */
    void authenticate(Credentials credentials);

}
