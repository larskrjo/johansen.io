package net.larskristian.core.manager.impl;

import net.larskristian.core.dao.SessionDao;
import net.larskristian.core.dao.dto.AppType;
import net.larskristian.core.dao.dto.Session;
import net.larskristian.core.manager.SessionManager;
import net.larskristian.framework.number.NumberUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Lars K. Johansen
 */
@Service
public class SessionManagerImpl implements SessionManager {

    @Autowired
    private SessionDao sessionDao;

    @Override
    public Session getCurrentSession(String sessionId) {
        return sessionDao.getSession(sessionId);
    }

    @Override
    public Session createSession(String userId) {
        Session session = new Session();
        session.setAppType(AppType.NOTHING);
        session.setExternalId(NumberUtility.getUUID());
        session.setUserId(userId);
        sessionDao.saveSession(session);
        return session;
    }

    @Override
    public void saveOrUpdateSession(Session session) {
        sessionDao.saveOrUpdateSession(session);
    }
}
