package com.dvfu.digital_platform_core.security.auth;

import org.springframework.security.authentication.AbstractAuthenticationToken;


public class AnonAuthentication extends AbstractAuthenticationToken {

    private static final long serialVersionUID = -7156048126414519693L;

    public AnonAuthentication() {
        super( null );
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }

    @Override
    public boolean isAuthenticated() {
        return true;
    }

}
