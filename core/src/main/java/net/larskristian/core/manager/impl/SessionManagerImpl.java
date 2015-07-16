package net.larskristian.core.manager.impl;

import net.larskristian.core.context.SessionContext;
import net.larskristian.core.dao.SessionDao;
import net.larskristian.core.dao.dto.AppType;
import net.larskristian.core.dao.dto.Session;
import net.larskristian.core.manager.SessionManager;
import net.larskristian.framework.number.NumberUtility;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Lars K. Johansen
 */
@Service
public class SessionManagerImpl implements SessionManager {

    @Autowired
    private SessionDao sessionDao;

    @Autowired
    private SessionContext sessionContext;

    @Override
    public Session getCurrentSession(String sessionId) {
        return sessionDao.getSession(sessionId);
    }

    @Override
    public void createSession(String userId) {
        Session session = new Session();
        session.setAppType(AppType.NOTHING);
        session.setExternalId(NumberUtility.getUUID());
        session.setUserId(userId);
        List<Session> currentSessions = sessionDao.getSessions(userId);
        if (!CollectionUtils.isEmpty(currentSessions)) {
            for (Session existingSession: currentSessions) {
                sessionDao.deleteSession(existingSession);
            }
        }
        sessionDao.saveSession(session);
        sessionContext.enterContext(session);
    }

    @Override
    public void deleteSession(Session session) {
        List<Session> currentSessions = sessionDao.getSessions(session.getUserId());
        if (!CollectionUtils.isEmpty(currentSessions)) {
            for (Session existingSession: currentSessions) {
                sessionDao.deleteSession(existingSession);
            }
        }
    }
}
