package net.larskristian.framework.exception.type.user;

import net.larskristian.framework.exception.AbstractBaseException;
import net.larskristian.framework.exception.ExceptionMessages;

/**
 * @author Lars K. Johansen
 */
public class UserException extends AbstractBaseException {

    public UserException(String message) {
        super(message);
    }

    public UserException(Throwable t) {
        super(t);
    }

    public UserException(String message, Throwable t) {
        super(message, t);
    }

    @Override
    public String getErrorId() {
        return ExceptionMessages.ERROR_USER_EXCEPTION;
    }

}
