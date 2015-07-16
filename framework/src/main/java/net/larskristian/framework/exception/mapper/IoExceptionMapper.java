package net.larskristian.framework.exception.mapper;

import net.larskristian.framework.exception.mapper.response.ApiExceptionResponse;
import net.larskristian.framework.exception.type.number.NumberException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Lars K. Johansen
 */
@Component
public class IoExceptionMapper extends AbstractExceptionMapper<NumberException> {

    @Override
    public ApiExceptionResponse handleApiException(NumberException exception, HttpServletResponse httpServletResponse, ApiExceptionResponse apiExceptionResponse) {
        httpServletResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        apiExceptionResponse.setErrorStatusCode(httpServletResponse.getStatus());
        return apiExceptionResponse;
    }

    @Override
    public ModelAndView handleUIException(NumberException exception, HttpServletResponse httpServletResponse, ModelAndView modelAndView) {
        httpServletResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        modelAndView.addObject("errorStatusCode", httpServletResponse.getStatus());
        return modelAndView;
    }

}
