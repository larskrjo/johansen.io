package net.larskristian.core.exception.type;

import net.larskristian.core.exception.AbstractBaseException;
import net.larskristian.core.exception.ExceptionMessages;

/**
 * @author Lars K. Johansen
 */
public class PageNotFoundException extends AbstractBaseException {

    public PageNotFoundException(String message) {
        super(message);
    }

    public PageNotFoundException(Throwable t) {
        super(t);
    }

    public PageNotFoundException(String message, Throwable t) {
        super(message, t);
    }

    @Override
    public String getErrorId() {
        return ExceptionMessages.ERROR_PAGE_NOT_FOUND_EXCEPTION;
    }
}
