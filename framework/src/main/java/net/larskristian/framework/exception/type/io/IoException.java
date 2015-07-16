package net.larskristian.framework.exception.type.io;

import net.larskristian.framework.exception.AbstractBaseException;
import net.larskristian.framework.exception.ExceptionMessages;

/**
 * @author Lars K. Johansen
 */
public class IoException extends AbstractBaseException {

    public IoException(String message) {
        super(message);
    }

    public IoException(Throwable t) {
        super(t);
    }

    public IoException(String message, Throwable t) {
        super(message, t);
    }

    @Override
    public String getErrorId() {
        return ExceptionMessages.ERROR_IO_EXCEPTION;
    }
}
