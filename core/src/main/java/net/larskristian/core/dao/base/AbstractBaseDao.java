package net.larskristian.core.dao.base;

import com.google.common.collect.Lists;
import net.larskristian.framework.classes.ClassUtility;
import net.larskristian.framework.exception.ExceptionMessages;
import net.larskristian.framework.exception.type.dao.DaoException;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * @author Lars K. Johansen
 */
public abstract class AbstractBaseDao<T> {

    private static final String UNCHECKED = "unchecked";

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Creates the object of type {@link T}.
     *
     * @param object The {@code object} to be persisted.
     * @return String the id of the created object.
     */
    @SuppressWarnings(UNCHECKED)
    protected String create(T object) {
        if (object == null) {
            throw new DaoException(ExceptionMessages.MESSAGE_DAO_OBJECT_NOT_PRESENT);
        }
        return (String) sessionFactory.getCurrentSession().save(object);
    }

    /**
     * Reads the object of type {@link T} based on the {@code id} or returns null if not exists.
     *
     * @param id The id of the object to read.
     * @return   Object of type {@link T} or null if not exists.
     */
    @SuppressWarnings(UNCHECKED)
    protected T read(Serializable id) {
        if (id == null) {
            throw new DaoException(String.format(ExceptionMessages.MESSAGE_DAO_VALUE_NOT_PRESENT, "id"));
        }
        return (T) sessionFactory.getCurrentSession().get(ClassUtility.getGenericClass(this), id);
    }

    /**
     * Updates the object of type {@link T}.
     *
     * @param object The {@code object} to be persisted.
     */
    @SuppressWarnings(UNCHECKED)
    protected T update(T object) {
        if (object == null) {
            throw new DaoException(ExceptionMessages.MESSAGE_DAO_OBJECT_NOT_PRESENT);
        }
        return (T) sessionFactory.getCurrentSession().merge(object);
    }

    /**
     * Deletes the object of type {@link T} based on the {@code id}.
     *
     * @param object The object of type {@link T} to delete.
     */
    protected void delete(T object) {
        if (object == null) {
            throw new DaoException(ExceptionMessages.MESSAGE_DAO_OBJECT_NOT_PRESENT);
        }
        sessionFactory.getCurrentSession().delete(object);
    }

    /**
     * Lists the objects of type {@link T}.
     *
     * @return List of objects of type {@link T}.
     */
    @SuppressWarnings(UNCHECKED)
    protected List<T> list() {
        return (List<T>) sessionFactory.getCurrentSession().
                createQuery(String.format("FROM %s", ClassUtility.getGenericClass(this).getCanonicalName())).list();
    }

    /**
     * Lists the objects of type {@link T} based on the {@code fieldName} and {@code fieldValue}.
     *
     * @param column The id of the object to read.
     * @param value  The id of the object to read.
     * @return       Objects of type {@link T}.
     */
    @SuppressWarnings(UNCHECKED)
    protected List<T> readByFieldName(Serializable column, Serializable value) {
        if (column == null) {
            throw new DaoException(ExceptionMessages.MESSAGE_DAO_COLUMN_NOT_PRESENT);
        } else if (value == null) {
            throw new DaoException(String.format(ExceptionMessages.MESSAGE_DAO_VALUE_NOT_PRESENT, column.toString()));
        }
        Pair<Serializable, Serializable> pair = new ImmutablePair<Serializable, Serializable>(column, value);
        return readByFieldNames(Lists.newArrayList(pair));
    }

    /**
     * Lists the objects of type {@link T} based on the list of {@code Pair} with fieldName and fieldValues.
     *
     * @param keyValuePairs The list of key-value pairs that represent fields and values.
     * @return              Objects of type {@link T}.
     */
    @SuppressWarnings(UNCHECKED)
    protected List<T> readByFieldNames(List<Pair<Serializable, Serializable>> keyValuePairs) {
        if (CollectionUtils.size(keyValuePairs) < 1) {
            throw new DaoException(ExceptionMessages.MESSAGE_DAO_OBJECT_NOT_PRESENT);
        }
        for (Pair<Serializable, Serializable> pair : keyValuePairs) {
            if (pair.getKey() == null) {
                throw new DaoException(ExceptionMessages.MESSAGE_DAO_COLUMN_NOT_PRESENT);
            } else if (pair.getValue() == null) {
                throw new DaoException(String.format(ExceptionMessages.MESSAGE_DAO_VALUE_NOT_PRESENT, pair.getKey().toString()));
            }
        }
        StringBuffer query = new StringBuffer("SELECT * FROM " + ClassUtility.getGenericClass(this).getSimpleName() + " WHERE");
        int index = 0;
        for (Pair<Serializable, Serializable> pair : keyValuePairs) {
            query.append(" " + pair.getKey().toString() + "='" + pair.getValue().toString() + "'");
            index++;
            if (index < keyValuePairs.size()) {
                query.append(" AND");
            }
        }
        return (List<T>) sessionFactory.getCurrentSession().createSQLQuery(query.toString()).addEntity(ClassUtility.getGenericClass(this)).list();
    }

    /**
     * Reads the object of type {@link T} based on the {@code id}.
     *
     * @param id The id of the object to read.
     * @return   Object of type {@link T}.
     */
    @SuppressWarnings(UNCHECKED)
    protected T readUniqueById(Serializable id) {
        return readUniqueByFieldName("id", id);
    }

    /**
     * Gets the object of type {@link T} based on the {@code column} and {@code value}.
     *
     * @param column The id of the object to read.
     * @param value  The id of the object to read.
     * @return       Object of type {@link T}.
     */
    @SuppressWarnings(UNCHECKED)
    protected T readUniqueByFieldName(Serializable column, Serializable value) {
        List<T> list = readByFieldName(column, value);
        if (CollectionUtils.isEmpty(list)) {
            throw new DaoException(ExceptionMessages.MESSAGE_DAO_OBJECT_NOT_FOUND);
        }
        if (list.size() > 1) {
            throw new DaoException(ExceptionMessages.MESSAGE_DAO_RESULT_NOT_UNIQUE);
        }
        return list.get(0);
    }

    /**
     * Reads the object of type {@link T} based on the list of {@code Pair} with fieldName and fieldValues.
     *
     * @param keyValuePairs The list of key-value pairs that represent fields and values.
     * @return              Object of type {@link T}.
     */
    @SuppressWarnings(UNCHECKED)
    protected T readUniqueByFieldNames(List<Pair<Serializable, Serializable>> keyValuePairs) {
        List<T> list = readByFieldNames(keyValuePairs);
        if (CollectionUtils.isEmpty(list)) {
            throw new DaoException(ExceptionMessages.MESSAGE_DAO_OBJECT_NOT_FOUND);
        }
        if (list.size() > 1) {
            throw new DaoException(ExceptionMessages.MESSAGE_DAO_RESULT_NOT_UNIQUE);
        }
        return list.get(0);
    }

}
