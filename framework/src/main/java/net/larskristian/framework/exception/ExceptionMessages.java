package net.larskristian.framework.exception;

/**
 * @author Lars K. Johansen
 */
public interface ExceptionMessages {

    String ERROR_EXCEPTION = "000000";

    String ERROR_SESSION_EXCEPTION = "000001";
    String MESSAGE_INVALID_SESSION = "User did not have a cookie.";
    String MESSAGE_INVALID_SOCIAL_LOGIN_NOT_ENOUGH_PERMISSION = "User did not provide enough permissions to sign in. " +
            "Please go to '%s' and remove the app, so you can accept all permissions during next login.";

    String ERROR_DAO_EXCEPTION = "000002";
    String MESSAGE_DAO_OBJECT_NOT_PRESENT = "Mandatory object not present in database call.";
    String MESSAGE_DAO_COLUMN_NOT_PRESENT = "Mandatory column not present in query.";
    String MESSAGE_DAO_VALUE_NOT_PRESENT = "Mandatory value for column '%s' not present in query.";
    String MESSAGE_DAO_OBJECT_NOT_FOUND = "Object not found in the database.";
    String MESSAGE_DAO_RESULT_NOT_UNIQUE = "The result set is not unique.";

    String ERROR_PAGE_NOT_FOUND_EXCEPTION = "000003";
    String MESSAGE_PAGE_NOT_FOUND = "The requested page was not found.";
    String MESSAGE_ENDPOINT_NOT_FOUND = "The requested endpoint does not exist.";

    String ERROR_NUMBER_EXCEPTION = "000004";
    String MESSAGE_NUMBER_RESULT_NOT_POSSIBLE = "Impossible calculation.";

    String ERROR_IO_EXCEPTION = "000005";
    String MESSAGE_IO_UNKNOWN_ENCODING = "Unknown encoding schema.";
    String MESSAGE_IO_HTTP_FAILURE = "Something went wrong during I/O.";

    String ERROR_USER_EXCEPTION = "000006";
    String MESSAGE_USER_DID_NOT_EXIST_EXCEPTION = "User did not exist.";

    String ERROR_NOT_IMPLEMENTED_EXCEPTION = "000007";
    String MESSAGE_METHOD_NOT_IMPLEMENTED_EXCEPTION = "The requested method is not implemented.";

}
