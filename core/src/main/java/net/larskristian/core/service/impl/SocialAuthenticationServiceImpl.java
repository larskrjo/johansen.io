package net.larskristian.core.service.impl;

import net.larskristian.core.dao.dto.User;
import net.larskristian.core.manager.SessionManager;
import net.larskristian.core.service.SocialAuthenticationService;
import net.larskristian.core.service.oauth.SocialAuthProvider;
import net.larskristian.framework.uri.UriPaths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Lars K. Johansen
 */
@Service
public class SocialAuthenticationServiceImpl implements SocialAuthenticationService {

    @Autowired
    private SocialAuthProvider socialAuthProvider;

    @Autowired
    private SessionManager sessionManager;

    @Override
    public String getLoginUrl(String baseUrl) {
        return socialAuthProvider.getLoginUrl(baseUrl);
    }

    @Override
    public String finishLogin(String baseUrl, String authorizationCode) {
        User user = socialAuthProvider.finishLogin(baseUrl, authorizationCode);
        sessionManager.createSession(user.getId());
        return UriPaths.UI_ACCOUNT;
    }
}
