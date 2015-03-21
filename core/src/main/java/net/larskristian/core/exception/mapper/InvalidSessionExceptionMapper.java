package net.larskristian.core.exception.mapper;

import net.larskristian.core.exception.mapper.response.ApiExceptionResponse;
import net.larskristian.core.exception.type.session.InvalidSessionException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Lars K. Johansen
 */
@Component
public class InvalidSessionExceptionMapper extends AbstractExceptionMapper<InvalidSessionException> {

    @Override
    public ApiExceptionResponse handleApiException(InvalidSessionException exception, HttpServletResponse httpServletResponse, ApiExceptionResponse apiExceptionResponse) {
        return apiExceptionResponse;
    }

    @Override
    public ModelAndView handleUIException(InvalidSessionException exception, HttpServletResponse httpServletResponse, ModelAndView modelAndView) {
        return modelAndView;
    }

}
