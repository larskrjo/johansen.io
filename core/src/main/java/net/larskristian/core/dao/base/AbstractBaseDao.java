package net.larskristian.core.dao.base;

import net.larskristian.core.exception.ExceptionMessages;
import net.larskristian.core.exception.type.dao.DaoException;
import net.larskristian.framework.classes.ClassUtility;
import org.apache.commons.collections4.CollectionUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * @author Lars K. Johansen
 */
public abstract class AbstractBaseDao<T> {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Saves the object of type {@link T}.
     *
     * @param object The {@code object} to be persisted.
     * @return String the id of the created object.
     */
    protected String save(Object object) {
        Session session = sessionFactory.getCurrentSession();
        return (String) session.save(object);
    }

    /**
     * Saves or updates the object of type {@link T}.
     *
     * @param object The {@code object} to be persisted.
     */
    protected void saveOrUpdate(Object object) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(object);
    }

    /**
     * Gets the object of type {@link T} based on the {@code id}.
     *
     * @param id The id of the object to get.
     * @return   Object of type {@link T}.
     */
    @SuppressWarnings("unchecked")
    protected T get(Serializable id) {
        if (id == null) {
            throw new DaoException(String.format(ExceptionMessages.MESSAGE_DAO_VALUE_NOT_PRESENT, "id"));
        }
        T value = (T) sessionFactory.getCurrentSession().get(ClassUtility.getGenericClass(this), id);
        if (value == null) {
            throw new DaoException(ExceptionMessages.MESSAGE_DAO_OBJECT_NOT_FOUND);
        }
        return value;
    }

    /**
     * Gets the object of type {@link T} based on the {@code id} or returns null if not exists.
     *
     * @param id The id of the object to get.
     * @return   Object of type {@link T} or null if not exists.
     */
    @SuppressWarnings("unchecked")
    protected T getOptional(Serializable id) {
        if (id == null) {
            throw new DaoException(String.format(ExceptionMessages.MESSAGE_DAO_VALUE_NOT_PRESENT, "id"));
        }
        return  (T) sessionFactory.getCurrentSession().get(ClassUtility.getGenericClass(this), id);
    }

    /**
     * Gets the objects of type {@link T} based on the {@code fieldName} and {@code fieldValue}.
     *
     * @param column The id of the object to get.
     * @param value The id of the object to get.
     * @return   Objects of type {@link T}.
     */
    @SuppressWarnings("unchecked")
    protected List<T> getByFieldName(Serializable column, Serializable value) {
        if (column == null) {
            throw new DaoException(ExceptionMessages.MESSAGE_DAO_COLUMN_NOT_PRESENT);
        } else if (value == null) {
            throw new DaoException(String.format(ExceptionMessages.MESSAGE_DAO_VALUE_NOT_PRESENT, column.toString()));
        }
        String query = "SELECT * " +
                       "FROM " + ClassUtility.getGenericClass(this).getSimpleName() + " " +
                       "WHERE " + column.toString() + "='" + value.toString() + "'";
        List<T> list = (List<T>) sessionFactory.getCurrentSession().createSQLQuery(query).addEntity(ClassUtility.getGenericClass(this)).list();
        if (list == null) {
            throw new DaoException(ExceptionMessages.MESSAGE_DAO_OBJECT_NOT_FOUND);
        }
        return list;
    }

    /**
     * Gets the object of type {@link T} based on the {@code column} and {@code value}.
     *
     * @param column The id of the object to get.
     * @param value The id of the object to get.
     * @return   Object of type {@link T}.
     */
    protected T getByUniqueFieldName(Serializable column, Serializable value) {
        List<T> list = getByFieldName(column, value);
        if (CollectionUtils.isEmpty(list)) {
            throw new DaoException(ExceptionMessages.MESSAGE_DAO_OBJECT_NOT_FOUND);
        }
        if (list.size() > 1) {
            throw new DaoException(ExceptionMessages.MESSAGE_DAO_RESULT_NOT_UNIQUE);
        }
        return list.get(0);
    }

    /**
     * Deletes the object of type {@link T} based on the {@code id}.
     *
     * @param object The object of type {@link T} to delete.
     */
    protected void delete(T object) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(object);
    }

}
