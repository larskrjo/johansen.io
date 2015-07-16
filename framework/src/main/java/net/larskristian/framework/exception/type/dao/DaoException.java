package net.larskristian.framework.exception.type.dao;

import net.larskristian.framework.exception.AbstractBaseException;
import net.larskristian.framework.exception.ExceptionMessages;

/**
 * @author Lars K. Johansen
 */
public class DaoException extends AbstractBaseException {

    public DaoException(String message) {
        super(message);
    }

    public DaoException(Throwable t) {
        super(t);
    }

    public DaoException(String message, Throwable t) {
        super(message, t);
    }

    @Override
    public String getErrorId() {
        return ExceptionMessages.ERROR_DAO_EXCEPTION;
    }
}
