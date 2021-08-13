package com.cv.theque.cv_theque.config;


import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

class AuditorAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        KeycloakAuthenticationToken keycloakAuthenticationToken = (KeycloakAuthenticationToken) authentication;
        KeycloakSecurityContext details = keycloakAuthenticationToken.getAccount().getKeycloakSecurityContext();
        String username = details.getToken().getPreferredUsername();
        return Optional.of(username);
//        // Can use Spring Security to return currently logged in user
    }
}