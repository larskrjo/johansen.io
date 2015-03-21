package net.larskristian.api.exception.resolver;

import net.larskristian.core.exception.BaseException;
import net.larskristian.core.exception.ExceptionMessages;
import net.larskristian.core.exception.mapper.AbstractExceptionMapper;
import net.larskristian.core.exception.mapper.response.ApiExceptionResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Set;

/**
 * @author Lars K. Johansen
 */
@ControllerAdvice(annotations = RestController.class)
public class ApiExceptionResolver {

    private static final Logger LOG = LogManager.getLogger(ApiExceptionResolver.class);

    @Autowired
    private Set<AbstractExceptionMapper> exceptionMappers;

    /**
     * Handle exceptions thrown by handlers originating from the API.
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ApiExceptionResponse handleException(Exception exception, HttpServletResponse httpServletResponse) {
        LOG.info("Exception caught in ApiExceptionResolver with message={}.", exception.getMessage());
        LOG.debug("Exception caught in ApiExceptionResolver.", exception);

        httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
        ApiExceptionResponse apiExceptionResponse = createApiExceptionResponse(exception, httpServletResponse);

        for (AbstractExceptionMapper mapper : exceptionMappers) {
            if (mapper.supports(exception)) { // Only one mapper should support it.
                return mapper.handleApiException(exception, httpServletResponse, apiExceptionResponse);
            }
        }
        return apiExceptionResponse;
    }

    private ApiExceptionResponse createApiExceptionResponse(Exception exception, HttpServletResponse httpServletResponse) {
        ApiExceptionResponse apiExceptionResponse = new ApiExceptionResponse();
        apiExceptionResponse.setStatusCode(httpServletResponse.getStatus());
        apiExceptionResponse.setErrorCode(exception instanceof BaseException ?
                ((BaseException) exception).getErrorId() :
                ExceptionMessages.ERROR_EXCEPTION);
        apiExceptionResponse.setErrorMessage(exception.getMessage());
        return apiExceptionResponse;
    }

}