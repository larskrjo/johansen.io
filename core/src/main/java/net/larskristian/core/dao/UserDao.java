package net.larskristian.core.dao;

import net.larskristian.core.dao.dto.User;

/**
 * @author Lars K. Johansen
 */
public interface UserDao {

    /**
     * Retrieves the user for the given {@code userId}.
     *
     * @param   userId String that represents the user's id.
     * @return         {@link net.larskristian.core.dao.dto.User} with the specified {@code userId}.
     */
    User getUser(String userId);

}
