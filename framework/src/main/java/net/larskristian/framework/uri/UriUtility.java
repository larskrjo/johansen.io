package net.larskristian.framework.uri;

import com.google.common.base.Charsets;
import net.larskristian.framework.exception.ExceptionMessages;
import net.larskristian.framework.exception.type.io.IoException;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author Lars K. Johansen
 */
public final class UriUtility {

    private static final String URL_ENCODING = Charsets.UTF_8.name();

    private UriUtility() {
        // Utility class
    }

    public static String getHost(String hostName, int port) {
        return getHost(hostName, port, null);
    }

    public static String getHost(String hostName, int port, String path) {
        if (hostName.startsWith("http://") || hostName.startsWith("https://")) {
            return getHost(hostName, port, path, null);
        }
        return getHost(hostName, port, path, "http://");
    }

    public static String getHost(String hostName, int port, String path, String protocol) {
        StringBuffer host = new StringBuffer();
        host.append(hostName).append(':').append(port);
        if (protocol != null) {
            host.insert(0, protocol);
        }
        if (path != null) {
            host.append(path);
        }
        return host.toString();
    }

    public static String addPath(String baseUrl, String path) {
        return baseUrl + path;
    }

    public static String createParameter(String parameterName, String parameterValue) {
        return encodeParameter(parameterName) + "=" + encodeParameter(parameterValue);
    }

    public static void setParameter(StringBuffer url, String parameter) {
        if (url.toString().contains("?")) {
            url.append('&').append(parameter);
        } else {
            url.append('?').append(parameter);
        }
    }

    public static String encodeParameter(String parameter) {
        String encodedParameter;
        try {
            encodedParameter = URLEncoder.encode(parameter, URL_ENCODING).replace("%25", "%");
        } catch (UnsupportedEncodingException e) {
            throw new IoException(ExceptionMessages.MESSAGE_IO_UNKNOWN_ENCODING, e);
        }
        return encodedParameter;
    }
}
