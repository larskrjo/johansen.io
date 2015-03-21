package net.larskristian.core.context;

import net.larskristian.core.dao.dto.Session;

/**
 * @author Lars K. Johansen
 */
public interface SessionContext {

    void enterContext(Session session);
}
