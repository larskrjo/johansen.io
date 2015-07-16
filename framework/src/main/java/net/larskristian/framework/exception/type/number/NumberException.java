package net.larskristian.framework.exception.type.number;

import net.larskristian.framework.exception.AbstractBaseException;
import net.larskristian.framework.exception.ExceptionMessages;

/**
 * @author Lars K. Johansen
 */
public class NumberException extends AbstractBaseException {

    public NumberException(String message) {
        super(message);
    }

    public NumberException(Throwable t) {
        super(t);
    }

    public NumberException(String message, Throwable t) {
        super(message, t);
    }

    @Override
    public String getErrorId() {
        return ExceptionMessages.ERROR_NUMBER_EXCEPTION;
    }
}
