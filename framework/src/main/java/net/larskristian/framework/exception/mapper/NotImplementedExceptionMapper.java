package net.larskristian.framework.exception.mapper;

import net.larskristian.framework.exception.mapper.response.ApiExceptionResponse;
import net.larskristian.framework.exception.type.NotImplementedException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Lars K. Johansen
 */
@Component
public class NotImplementedExceptionMapper extends AbstractExceptionMapper<NotImplementedException> {

    @Override
    public ApiExceptionResponse handleApiException(NotImplementedException exception, HttpServletResponse httpServletResponse, ApiExceptionResponse apiExceptionResponse) {
        httpServletResponse.setStatus(HttpStatus.NOT_IMPLEMENTED.value());
        apiExceptionResponse.setErrorStatusCode(httpServletResponse.getStatus());
        return apiExceptionResponse;
    }

    @Override
    public ModelAndView handleUIException(NotImplementedException exception, HttpServletResponse httpServletResponse, ModelAndView modelAndView) {
        httpServletResponse.setStatus(HttpStatus.NOT_IMPLEMENTED.value());
        modelAndView.addObject("errorStatusCode", httpServletResponse.getStatus());
        return modelAndView;
    }

}
