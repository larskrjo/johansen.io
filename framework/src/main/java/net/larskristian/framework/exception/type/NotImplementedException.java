package net.larskristian.framework.exception.type;

import net.larskristian.framework.exception.AbstractBaseException;
import net.larskristian.framework.exception.ExceptionMessages;

/**
 * @author Lars K. Johansen
 */
public class NotImplementedException extends AbstractBaseException {

    public NotImplementedException(String message) {
        super(message);
    }

    public NotImplementedException(Throwable t) {
        super(t);
    }

    public NotImplementedException(String message, Throwable t) {
        super(message, t);
    }

    @Override
    public String getErrorId() {
        return ExceptionMessages.ERROR_NOT_IMPLEMENTED_EXCEPTION;
    }
}
