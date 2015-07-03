package net.larskristian.core.exception.type.dao;

import net.larskristian.core.exception.AbstractBaseException;
import net.larskristian.core.exception.ExceptionMessages;

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
