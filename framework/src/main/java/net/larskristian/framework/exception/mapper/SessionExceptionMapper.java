package net.larskristian.framework.exception.mapper;

import net.larskristian.framework.exception.mapper.response.ApiExceptionResponse;
import net.larskristian.framework.exception.type.session.SessionException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Lars K. Johansen
 */
@Component
public class SessionExceptionMapper extends AbstractExceptionMapper<SessionException> {

    @Override
    public ApiExceptionResponse handleApiException(SessionException exception, HttpServletResponse httpServletResponse, ApiExceptionResponse apiExceptionResponse) {
        return apiExceptionResponse;
    }

    @Override
    public ModelAndView handleUIException(SessionException exception, HttpServletResponse httpServletResponse, ModelAndView modelAndView) {
        return modelAndView;
    }

}
