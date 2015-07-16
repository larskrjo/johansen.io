package net.larskristian.framework.uri;

/**
 * @author Lars K. Johansen
 */
public interface UriPaths {

    String ROOT = "/";

    /**
     * UI
     */
    String JSP_HOME = "home";

    String UI_HOME = ROOT;
    String UI_WILDCARD = "/**";
    String UI_ABOUT = "/about";
    String UI_LOGIN = "/login";
    String UI_ACCOUNT = "/account";
    String UI_CV = "/cv";

    // Social Authentication
    String UI_SOCIAL_INIT_LOGIN = "/social/login";
    String UI_SOCIAL_FINISH_LOGIN = "/social/finish";

    /**
     * API
     */
    String API_WILDCARD = "/api/v1/**";

    // Users
    String API_USER_ME = "/api/v1/users/me";
    String API_USER_ME_UPDATE = "/api/v1/users/me/{id}";

    // Authentication
    String API_AUTHENTICATE_USER = "/api/v1/session/authenticate";
    String API_INVALIDATE_SESSION = "/api/v1/session/invalidate/{sessionId}";

    // Resources
    String API_IMAGE_HEADER_COLLECTION = "/api/v1/image/header";
    String API_IMAGE_SECTION_COLLECTION = "/api/v1/image/section";
    String API_IMAGE_SECTION = "/api/v1/image/section/{id}";
    String API_IMAGE_FULL = "/api/v1/image/full/{id}";

}
