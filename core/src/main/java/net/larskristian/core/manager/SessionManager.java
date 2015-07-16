package net.larskristian.core.manager;

import net.larskristian.core.dao.dto.Session;

/**
 * @author Lars K. Johansen
 */
public interface SessionManager {

    Session getCurrentSession(String sessionId);

    void createSession(String userId);

    void deleteSession(Session session);

}
