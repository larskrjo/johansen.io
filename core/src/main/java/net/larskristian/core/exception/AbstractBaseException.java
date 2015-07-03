package net.larskristian.core.exception;

/**
 * @author Lars K. Johansen
 */
public abstract class AbstractBaseException extends RuntimeException {

    public AbstractBaseException(String message) {
        super(message);
    }

    public AbstractBaseException(Throwable t) {
        super(t);
    }

    public AbstractBaseException(String message, Throwable t) {
        super(message, t);
    }

    public abstract String getErrorId();
}