package net.larskristian.ui.facade.authentication.social;

import net.larskristian.core.context.SessionContext;
import net.larskristian.core.manager.CookieManager;
import net.larskristian.core.service.SocialAuthenticationService;
import net.larskristian.framework.uri.UriPaths;
import net.larskristian.framework.uri.UriUtility;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Lars K. Johansen
 */
@Controller
@RequestMapping(value = UriPaths.ROOT)
public class SocialAuthenticationFacade {

    private static final Logger LOG = LogManager.getLogger(SocialAuthenticationFacade.class);

    @Autowired
    private SocialAuthenticationService socialAuthenticationService;

    @Autowired
    private SessionContext sessionContext;

    @Autowired
    private CookieManager cookieManager;

    @RequestMapping(value = UriPaths.UI_SOCIAL_INIT_LOGIN, method = RequestMethod.GET)
    public String initLogin(HttpServletRequest request) {
        LOG.info("Entered SocialAuthenticationFacade.getLoginUrl");
        return "redirect:" + socialAuthenticationService.getLoginUrl(UriUtility.getHost(request.getServerName(), request.getServerPort()));
    }

    @RequestMapping(value = UriPaths.UI_SOCIAL_FINISH_LOGIN, method = RequestMethod.GET)
    public String finishLogin(HttpServletRequest request, HttpServletResponse response,
                              @RequestParam(required = false) String code,
                              @RequestParam(required = false) String error) {
        LOG.info("Entered SocialAuthenticationFacade.finishLogin");
        if (StringUtils.isNotBlank(error)) {
            return "redirect:" + UriPaths.UI_ACCOUNT;
        }
        String redirectUrl = socialAuthenticationService.finishLogin(UriUtility.getHost(request.getServerName(), request.getServerPort()), code);
        if (sessionContext.isAuthenticated()) {
            cookieManager.addSessionCookie(CookieManager.SESSION_COOKIE_NAME, sessionContext.getExternalSessionId(), false, request, response);
        }
        return "redirect:" + redirectUrl;
    }
}
