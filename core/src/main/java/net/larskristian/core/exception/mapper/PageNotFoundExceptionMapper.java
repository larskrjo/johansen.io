package net.larskristian.core.exception.mapper;

import net.larskristian.core.exception.mapper.response.ApiExceptionResponse;
import net.larskristian.core.exception.type.PageNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Lars K. Johansen
 */
@Component
public class PageNotFoundExceptionMapper extends AbstractExceptionMapper<PageNotFoundException> {

    @Override
    public ApiExceptionResponse handleApiException(PageNotFoundException exception, HttpServletResponse httpServletResponse, ApiExceptionResponse apiExceptionResponse) {
        httpServletResponse.setStatus(HttpStatus.NOT_FOUND.value());
        apiExceptionResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
        return apiExceptionResponse;
    }

    @Override
    public ModelAndView handleUIException(PageNotFoundException exception, HttpServletResponse httpServletResponse, ModelAndView modelAndView) {
        httpServletResponse.setStatus(HttpStatus.NOT_FOUND.value());
        modelAndView.addObject("statusCode", httpServletResponse.getStatus());
        return modelAndView;
    }

}
