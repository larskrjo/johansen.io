package net.larskristian.core.service;

import net.larskristian.core.dao.dto.User;

/**
 * @author Lars K. Johansen
 */
public interface AuthenticationService {

    /**
     * Authenticates the user with the given credentials.
     *
     * @param   email    The string that represents the user's email.
     * @param   password The string that represents the user's password.
     * @return           The {@link User} with the matching {@code email} and {@code password}.
     */
    User authenticate(String email, String password);

}
