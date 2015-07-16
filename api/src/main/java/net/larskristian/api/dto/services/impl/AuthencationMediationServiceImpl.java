package net.larskristian.api.dto.services.impl;

import net.larskristian.api.dto.Credentials;
import net.larskristian.api.dto.services.AuthenticationMediationService;
import net.larskristian.core.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Lars K. Johansen
 */
@Component
public class AuthencationMediationServiceImpl implements AuthenticationMediationService {

    @Autowired
    private AuthenticationService authenticationService;

    @Override
    public void authenticate(Credentials credentials) {
        authenticationService.authenticate(credentials.getEmail(), credentials.getPassword());
    }
}
