package net.larskristian.core.dao.impl;

import net.larskristian.core.dao.UserDao;
import net.larskristian.core.dao.base.BaseDao;
import net.larskristian.core.dao.dto.User;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * @author Lars K. Johansen
 */
@Transactional
@Repository
public class UserDaoImpl extends BaseDao<User> implements UserDao {

    @Override
    public User getUser(String userId) {
        return get(userId);
    }

}
