package net.larskristian.core.exception;

/**
 * @author Lars K. Johansen
 */
public interface ExceptionMessages {

    String ERROR_EXCEPTION = "000000";

    String ERROR_INVALID_SESSION_EXCEPTION = "000001";
    String MESSAGE_INVALID_SESSION = "User did not have a cookie.";

    String ERROR_DAO_EXCEPTION = "000002";
    String MESSAGE_DAO_COLUMN_NOT_PRESENT = "Mandatory column not present in query.";
    String MESSAGE_DAO_VALUE_NOT_PRESENT = "Mandatory value for column '%s' not present in query.";
    String MESSAGE_DAO_OBJECT_NOT_FOUND = "Object not found in the database.";
    String MESSAGE_DAO_RESULT_NOT_UNIQUE = "The result set is not unique.";

    String ERROR_PAGE_NOT_FOUND_EXCEPTION = "000003";
    String MESSAGE_PAGE_NOT_FOUND = "The requested page was not found.";
}
