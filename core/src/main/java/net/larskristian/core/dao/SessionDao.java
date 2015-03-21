package net.larskristian.core.dao;

import net.larskristian.core.dao.dto.Session;

import java.util.List;

/**
 * @author Lars K. Johansen
 */
public interface SessionDao {

    /**
     * Retrieves the sessions for the given {@code userId}.
     *
     * @param   userId String that represents the user's id.
     * @return         {@link java.util.List<net.larskristian.core.dao.dto.Session>} for the specified {@code userId}.
     */
    List<Session> getSessions(String userId);

    /**
     * Retrieves the session for the given {@code externalOrInternalId}.
     *
     * @param   externalOrInternalId String that represents the external or internal session id.
     * @return                       {@link net.larskristian.core.dao.dto.Session} for
     *                                       the specified {@code externalOrInternalId}.
     */
    Session getSession(String externalOrInternalId);

    /**
     * Saves the session.
     *
     * @param   session Session to be saved.
     */
    void saveSession(Session session);

    /**
     * Saves or updates the session.
     *
     * @param   session Session to be saved or updated.
     */
    void saveOrUpdateSession(Session session);

    /**
     * Deletes the session.
     *
     * @param   session Session to be deleted.
     */
    void deleteSession(Session session);
}
