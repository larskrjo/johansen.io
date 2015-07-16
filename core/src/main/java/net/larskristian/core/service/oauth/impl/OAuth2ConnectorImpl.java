package net.larskristian.core.service.oauth.impl;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Joiner;
import net.larskristian.core.service.dto.AccessToken;
import net.larskristian.core.service.dto.SocialProfile;
import net.larskristian.core.service.oauth.OAuth2Connector;
import net.larskristian.framework.exception.ExceptionMessages;
import net.larskristian.framework.exception.type.io.IoException;
import net.larskristian.framework.number.NumberUtility;
import net.larskristian.framework.uri.UriUtility;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.Set;

/**
 * @author Lars K. Johansen
 */
@Service
public class OAuth2ConnectorImpl implements OAuth2Connector {

    @Override
    public String getLoginUrl(String url, String redirectUri, String clientId, Set<String> scopes) {
        StringBuffer authUrl = new StringBuffer(url);
        UriUtility.setParameter(authUrl, UriUtility.createParameter("state", "" + NumberUtility.getRandomInteger(10000, 1000000000)));
        UriUtility.setParameter(authUrl, UriUtility.createParameter("client_id", clientId));
        UriUtility.setParameter(authUrl, UriUtility.createParameter("redirect_uri", redirectUri));
        UriUtility.setParameter(authUrl, UriUtility.createParameter("response_type", "code"));
        UriUtility.setParameter(authUrl, UriUtility.createParameter("scope", Joiner.on(" ").join(scopes)));

        return authUrl.toString();
    }

    @Override
    public AccessToken getAccessToken(String url, String redirectUrl, String clientId, String clientSecret, String authorizationCode) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.set("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("client_id", clientId)
                .queryParam("client_secret", clientSecret)
                .queryParam("code", authorizationCode)
                .queryParam("grant_type", "authorization_code")
                .queryParam("redirect_uri", redirectUrl);

        HttpEntity<?> entity = new HttpEntity(headers);

        HttpEntity<String> response = restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.POST, entity, String.class);

        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        AccessToken value;
        try {
            value = mapper.readValue(response.getBody(), AccessToken.class);
        } catch (IOException e) {
            throw new IoException(ExceptionMessages.MESSAGE_IO_HTTP_FAILURE, e);
        }
        return value;
    }

    @Override
    public SocialProfile getProfile(String url, AccessToken accessToken) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.set("Authorization", "Bearer " + accessToken.getAccessToken());

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);

        HttpEntity<?> entity = new HttpEntity(headers);

        HttpEntity<String> response = restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.GET, entity, String.class);

        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        SocialProfile value;
        try {
            value = mapper.readValue(response.getBody(), SocialProfile.class);
        } catch (IOException e) {
            throw new IoException(ExceptionMessages.MESSAGE_IO_HTTP_FAILURE, e);
        }
        return value;
    }

}
