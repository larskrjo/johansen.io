package net.larskristian.core.dao;

import net.larskristian.core.dao.dto.User;

/**
 * @author Lars K. Johansen
 */
public interface UserDao {

    /**
     * Retrieves the user for the given {@code userId}.
     *
     * @param   userId The string that represents the user's id.
     * @return         The {@link net.larskristian.core.dao.dto.User} with the specified {@code userId}.
     */
    User getUser(String userId);

}
