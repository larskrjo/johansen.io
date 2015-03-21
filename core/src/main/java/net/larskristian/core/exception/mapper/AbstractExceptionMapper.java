package net.larskristian.core.exception.mapper;

import com.google.common.base.Objects;
import net.larskristian.core.exception.mapper.response.ApiExceptionResponse;
import net.larskristian.framework.classes.ClassHelper;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Lars K. Johansen
 */
public abstract class AbstractExceptionMapper<T extends Exception> {

    public boolean supports(Exception exception) {
        return Objects.equal(ClassHelper.getGenericClass(this).getName(),
                exception.getClass().getName());
    }

    public abstract ApiExceptionResponse handleApiException(T exception, HttpServletResponse httpServletResponse, ApiExceptionResponse apiExceptionResponse);

    public abstract ModelAndView handleUIException(T exception, HttpServletResponse httpServletResponse, ModelAndView modelAndView);

}
