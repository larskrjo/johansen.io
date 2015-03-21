package net.larskristian.core.exception;

/**
 * @author Lars K. Johansen
 */
public abstract class BaseException extends RuntimeException {

    public BaseException(String message) {
        super(message);
    }

    public BaseException(Throwable t) {
        super(t);
    }

    public BaseException(String message, Throwable t) {
        super(message, t);
    }

    public abstract String getErrorId();
}
