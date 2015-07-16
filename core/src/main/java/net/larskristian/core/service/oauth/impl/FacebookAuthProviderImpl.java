package net.larskristian.core.service.oauth.impl;

import com.google.common.collect.Sets;
import net.larskristian.core.dao.dto.User;
import net.larskristian.core.manager.impl.UserManagerImpl;
import net.larskristian.core.service.UserService;
import net.larskristian.core.service.dto.AccessToken;
import net.larskristian.core.service.dto.SocialProfile;
import net.larskristian.core.service.oauth.OAuth2Connector;
import net.larskristian.core.service.oauth.SocialAuthProvider;
import net.larskristian.framework.exception.ExceptionMessages;
import net.larskristian.framework.exception.type.session.SessionException;
import net.larskristian.framework.uri.UriPaths;
import net.larskristian.framework.uri.UriUtility;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Lars K. Johansen
 */
@Service
public class FacebookAuthProviderImpl implements SocialAuthProvider {

    @Autowired
    private UserService userService;

    @Autowired
    private OAuth2Connector oAuth2Connector;

    private static final String CLIENT_ID = System.getenv("FACEBOOK_APP_ID");
    private static final String CLIENT_SECRET = System.getenv("FACEBOOK_APP_ID_SECRET");

    private static final String FACEBOOK_API_VERSION = "2.4";
    private static final String FACEBOOK_AUTHORIZATION_URI = "https://www.facebook.com/dialog/oauth";
    private static final String FACEBOOK_ACCESS_CODE_URI = "https://graph.facebook.com/v" + FACEBOOK_API_VERSION + "/oauth/access_token";
    private static final String FACEBOOK_PROFILE_URI = "https://graph.facebook.com/v2.4/me?fields=email,last_name,first_name,picture.height(300)";

    private static final String FACEBOOK_PERMISSIONS_WEBSITE = "https://www.facebook.com/settings/?tab=applications";

    @Override
    public String getLoginUrl(String baseUrl) {
        String redirectUrl = UriUtility.addPath(baseUrl, UriPaths.UI_SOCIAL_FINISH_LOGIN);
        return oAuth2Connector.getLoginUrl(FACEBOOK_AUTHORIZATION_URI, redirectUrl, CLIENT_ID, Sets.newHashSet("public_profile", "email"));
    }

    @Override
    public User finishLogin(String baseUrl, String authorizationCode) {
        String redirectUrl = UriUtility.addPath(baseUrl, UriPaths.UI_SOCIAL_FINISH_LOGIN);
        AccessToken accessToken = oAuth2Connector.getAccessToken(FACEBOOK_ACCESS_CODE_URI, redirectUrl, CLIENT_ID, CLIENT_SECRET, authorizationCode);
        SocialProfile profile = oAuth2Connector.getProfile(FACEBOOK_PROFILE_URI, accessToken);
        if (StringUtils.isBlank(profile.getEmail())) {
            throw new SessionException(String.format(ExceptionMessages.MESSAGE_INVALID_SOCIAL_LOGIN_NOT_ENOUGH_PERMISSION, FACEBOOK_PERMISSIONS_WEBSITE));
        }
        User currentUser = userService.getUserWithEmail(profile.getEmail());
        if (currentUser != null) {
            currentUser = updateUserFromProfile(currentUser, profile);
        } else {
            currentUser = createUserFromProfile(profile);
        }
        return currentUser;
    }

    private User updateUserFromProfile(User currentUser, SocialProfile profile) {
        User user = getMediatedUser(profile);
        user.setId(currentUser.getId());
        user.setPassword(currentUser.getPassword());
        user.setLocale(currentUser.getLocale());
        return userService.updateUser(user.getEmail(), user);
    }

    private User createUserFromProfile(SocialProfile profile) {
        User user = getMediatedUser(profile);
        user.setLocale(UserManagerImpl.DEFAULT_LOCALE);
        return userService.createUser(user);
    }

    private User getMediatedUser(SocialProfile profile) {
        User user = new User();
        user.setEmail(profile.getEmail());
        user.setFirstName(profile.getFirstName());
        user.setLastName(profile.getLastName());
        user.setProfilePicture(profile.getPicture().getData().getUrl());
        return user;
    }

}
