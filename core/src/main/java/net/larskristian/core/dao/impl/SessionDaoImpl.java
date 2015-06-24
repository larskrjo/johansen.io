package net.larskristian.core.dao.impl;

import net.larskristian.core.dao.SessionDao;
import net.larskristian.core.dao.base.BaseDao;
import net.larskristian.core.dao.dto.Session;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Lars K. Johansen
 */
@Transactional
@Repository
public class SessionDaoImpl extends BaseDao<Session> implements SessionDao {

    private static final String USER_ID = "userId";
    private static final String EXTERNAL_ID = "externalId";

    @Override
    public List<Session> getSessions(String userId) {
        return getByFieldName(USER_ID, userId);
    }

    @Override
    public Session getSession(String externalOrInternalId) {
        Session session = getOptional(externalOrInternalId);
        if (session != null) {
            return session;
        }

        return getByUniqueFieldName(EXTERNAL_ID, externalOrInternalId);
    }

    @Override
    public void saveSession(Session session) {
        save(session);
    }

    @Override
    public void saveOrUpdateSession(Session session) {
        saveOrUpdate(session);
    }

    @Override
    public void deleteSession(Session session) {
        delete(session);
    }

}
