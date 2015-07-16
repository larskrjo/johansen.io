package net.larskristian.core.dao.impl;

import com.google.common.collect.Lists;
import net.larskristian.core.dao.UserDao;
import net.larskristian.core.dao.base.AbstractBaseDao;
import net.larskristian.core.dao.dto.User;
import net.larskristian.framework.exception.ExceptionMessages;
import net.larskristian.framework.exception.type.dao.DaoException;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

/**
 * @author Lars K. Johansen
 */
@Transactional
@Repository
public class UserDaoImpl extends AbstractBaseDao<User> implements UserDao {

    @Override
    public User getUser(String userId) {
        return read(userId);
    }

    @Override
    public User getUserWithEmail(String email) {
        List<User> users = readByFieldName("email", email);
        return users.size() > 0 ? users.get(0) : null;
    }

    @Override
    public User getUserWithEmailAndPassword(String email, String password) {
        List<Pair<Serializable, Serializable>> pairList = Lists.newArrayList();
        Pair<Serializable, Serializable> emailPair = new ImmutablePair<Serializable, Serializable>("email", email);
        pairList.add(emailPair);
        Pair<Serializable, Serializable> passwordPair = new ImmutablePair<Serializable, Serializable>("password", password);
        pairList.add(passwordPair);
        List<User> users = readByFieldNames(pairList);
        return users.size() > 0 ? users.get(0) : null;
    }

    @Override
    public User updateUser(String email, User user) {
        User currentUser = getUserWithEmail(email);
        if (currentUser != null) {
            user.setId(currentUser.getId());
            return update(user);
        } else {
            throw new DaoException(ExceptionMessages.MESSAGE_DAO_OBJECT_NOT_FOUND);
        }
    }

    @Override
    public User createUser(User user) {
        User currentUser = getUserWithEmail(user.getEmail());
        if (currentUser == null) {
            String id = create(user);
            return read(id);
        } else {
            throw new DaoException(ExceptionMessages.MESSAGE_DAO_OBJECT_NOT_FOUND);
        }
    }

}
