package net.larskristian.core.exception.type.session;

import net.larskristian.core.exception.BaseException;
import net.larskristian.core.exception.ExceptionMessages;

/**
 * @author Lars K. Johansen
 */
public class InvalidSessionException extends BaseException {

    public InvalidSessionException(String message) {
        super(message);
    }

    public InvalidSessionException(Throwable t) {
        super(t);
    }

    public InvalidSessionException(String message, Throwable t) {
        super(message, t);
    }

    @Override
    public String getErrorId() {
        return ExceptionMessages.ERROR_INVALID_SESSION_EXCEPTION;
    }

}
