package net.larskristian.core.dao.base;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

/**
 * @author Lars K. Johansen
 */
public abstract class BaseDao<T> {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Saves the object of type {@link T}.
     *
     * @param object The {@code object} to be persisted.
     */
    protected void save(Object object) {
        sessionFactory.getCurrentSession().save(object);
    }

    /**
     * Saves or updates the object of type {@link T}.
     *
     * @param object The {@code object} to be persisted.
     */
    protected void saveOrUpdate(Object object) {
        sessionFactory.getCurrentSession().saveOrUpdate(object);
    }

    /**
     * Gets the object of type {@link T} based on the {@code id}.
     *
     * @param id The id of the object to get.
     * @return   Object of type {@link T}.
     */
    @SuppressWarnings("unchecked")
    protected T get(Serializable id) {
        return (T) sessionFactory.getCurrentSession().get((Class) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0], id);
    }

    /**
     * Deletes the object of type {@link T} based on the {@code id}.
     *
     * @param object The object of type {@link T} to delete.
     */
    @SuppressWarnings("unchecked")
    protected void delete(T object) {
        sessionFactory.getCurrentSession().delete(object);
    }

}
