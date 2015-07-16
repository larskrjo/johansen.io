package net.larskristian.framework.exception.mapper.response;

/**
 * @author Lars K. Johansen
 */
public class ApiExceptionResponse {

    private int errorStatusCode;
    private String errorCode;
    private String errorMessage;

    public ApiExceptionResponse(int errorStatusCode, String errorCode, String errorMessage) {
        this.errorStatusCode = errorStatusCode;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public ApiExceptionResponse() {
        // Default constructor
    }

    public int getErrorStatusCode() {
        return errorStatusCode;
    }

    public void setErrorStatusCode(int errorStatusCode) {
        this.errorStatusCode = errorStatusCode;
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
