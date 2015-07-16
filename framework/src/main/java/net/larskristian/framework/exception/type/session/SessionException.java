package net.larskristian.framework.exception.type.session;

import net.larskristian.framework.exception.AbstractBaseException;
import net.larskristian.framework.exception.ExceptionMessages;

/**
 * @author Lars K. Johansen
 */
public class SessionException extends AbstractBaseException {

    public SessionException(String message) {
        super(message);
    }

    public SessionException(Throwable t) {
        super(t);
    }

    public SessionException(String message, Throwable t) {
        super(message, t);
    }

    @Override
    public String getErrorId() {
        return ExceptionMessages.ERROR_SESSION_EXCEPTION;
    }

}
