package net.larskristian.ui.exception.resolver;

import net.larskristian.core.exception.BaseException;
import net.larskristian.core.exception.ExceptionMessages;
import net.larskristian.core.exception.mapper.AbstractExceptionMapper;
import net.larskristian.framework.path.UriPaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.Set;

/**
 * @author Lars K. Johansen
 */
@ControllerAdvice(annotations = Controller.class)
public class UIExceptionResolver {

    private static final Logger LOG = LogManager.getLogger(UIExceptionResolver.class);

    @Autowired
    private Set<AbstractExceptionMapper> exceptionMappers;

    /**
     * Handle exceptions thrown by handlers originating from the UI.
     */
    @ExceptionHandler(value = Exception.class)
    public ModelAndView handleException(Exception exception, HttpServletResponse httpServletResponse) {
        LOG.info("Exception caught in UIExceptionResolver with message={}.", exception.getMessage());
        LOG.debug("Exception caught in UIExceptionResolver.", exception);

        httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
        ModelAndView mav = createModelAndViewErrors(exception, httpServletResponse);

        for (AbstractExceptionMapper mapper : exceptionMappers) {
            if (mapper.supports(exception)) { // Only one mapper should support it.
                return mapper.handleUIException(exception, httpServletResponse, mav);
            }
        }
        return mav;
    }

    private ModelAndView createModelAndViewErrors(Exception exception, HttpServletResponse httpServletResponse) {
        ModelAndView mav = new ModelAndView(UriPaths.JSP_HOME);
        mav.addObject("hasError", true);
        mav.addObject("statusCode", httpServletResponse.getStatus());
        mav.addObject("errorCode",
                exception instanceof BaseException ?
                ((BaseException) exception).getErrorId() :
                ExceptionMessages.ERROR_EXCEPTION);
        mav.addObject("errorMessage", exception.getMessage());
        return mav;
    }

}