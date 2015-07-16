package net.larskristian.core.manager;

import net.larskristian.core.dao.dto.User;

/**
 * @author Lars K. Johansen
 */
public interface UserManager {

    /**
     * Retrieves the user for the given {@code userId}.
     *
     * @param   userId The string that represents the user's id.
     * @return         The {@link net.larskristian.core.dao.dto.User} with the specified {@code userId}.
     */
    User getUser(String userId);

    /**
     * Retrieves the user for the given {@code email}.
     *
     * @param   email    The string that represents the user's email.
     * @return           The {@link net.larskristian.core.dao.dto.User} with the specified {@code email}.
     */
    User getUserWithEmail(String email);

    /**
     * Retrieves the user for the given {@code email} and {@code password}.
     *
     * @param   email    The string that represents the user's email.
     * @param   password The string that represents the user's password.
     * @return           The {@link net.larskristian.core.dao.dto.User} with the specified {@code email} and {@code password}.
     */
    User getUserWithEmailAndPassword(String email, String password);

    /**
     * Updates a user based on its email address.
     *  @param email The email to identify the user.
     * @param user  The new user values.
     */
    User updateUser(String email, User user);

    /**
     * Creates a new user from the given {@code user}.
     *
     * @param user The new user.
     */
    User createUser(User user);

}
