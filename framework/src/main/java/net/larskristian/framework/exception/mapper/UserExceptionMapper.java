package net.larskristian.framework.exception.mapper;

import net.larskristian.framework.exception.mapper.response.ApiExceptionResponse;
import net.larskristian.framework.exception.type.user.UserException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Lars K. Johansen
 */
@Component
public class UserExceptionMapper extends AbstractExceptionMapper<UserException> {

    @Override
    public ApiExceptionResponse handleApiException(UserException exception, HttpServletResponse httpServletResponse, ApiExceptionResponse apiExceptionResponse) {
        return apiExceptionResponse;
    }

    @Override
    public ModelAndView handleUIException(UserException exception, HttpServletResponse httpServletResponse, ModelAndView modelAndView) {
        return modelAndView;
    }

}
