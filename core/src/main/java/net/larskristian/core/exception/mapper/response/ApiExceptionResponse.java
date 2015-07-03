package net.larskristian.core.exception.mapper.response;

/**
 * @author Lars K. Johansen
 */
public class ApiExceptionResponse {

    private int statusCode;
    private String errorCode;
    private String errorMessage;

    public ApiExceptionResponse(int statusCode, String errorCode, String errorMessage) {
        this.statusCode = statusCode;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public ApiExceptionResponse() {
        // Default constructor
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
