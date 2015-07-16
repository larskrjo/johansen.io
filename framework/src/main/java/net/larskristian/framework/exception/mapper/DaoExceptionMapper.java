package net.larskristian.framework.exception.mapper;

import net.larskristian.framework.exception.type.dao.DaoException;
import net.larskristian.framework.exception.mapper.response.ApiExceptionResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Lars K. Johansen
 */
@Component
public class DaoExceptionMapper extends AbstractExceptionMapper<DaoException> {

    @Override
    public ApiExceptionResponse handleApiException(DaoException exception, HttpServletResponse httpServletResponse, ApiExceptionResponse apiExceptionResponse) {
        return apiExceptionResponse;
    }

    @Override
    public ModelAndView handleUIException(DaoException exception, HttpServletResponse httpServletResponse, ModelAndView modelAndView) {
        return modelAndView;
    }

}
