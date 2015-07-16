package net.larskristian.api.dto.services;

import net.larskristian.api.dto.User;

/**
 * @author Lars K. Johansen
 */
public interface UserMediationService {

    /**
     * Retrieves the user that has the current session.
     *
     * @return         The {@link net.larskristian.api.dto.User} for the current session.
     */
    User getCurrentUser();

    /**
     * Retrieves the user for the given {@code userId}.
     *
     * @param   userId The string that represents the user's id.
     * @return         The {@link net.larskristian.api.dto.User} with the specified {@code userId}.
     */
    User getUser(String userId);

    /**
     * Updates the locale for the user that has the current session.
     *
     * @param   user The user that has the current user's locale.
     */
    void updateLocaleForCurrentUser(User user);

}
