package net.larskristian.framework.exception.mapper;

import net.larskristian.framework.exception.mapper.response.ApiExceptionResponse;
import net.larskristian.framework.exception.type.number.NumberException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Lars K. Johansen
 */
@Component
public class NumberExceptionMapper extends AbstractExceptionMapper<NumberException> {

    @Override
    public ApiExceptionResponse handleApiException(NumberException exception, HttpServletResponse httpServletResponse, ApiExceptionResponse apiExceptionResponse) {
        return apiExceptionResponse;
    }

    @Override
    public ModelAndView handleUIException(NumberException exception, HttpServletResponse httpServletResponse, ModelAndView modelAndView) {
        return modelAndView;
    }

}
