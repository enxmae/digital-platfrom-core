package com.dvfu.digital_platform_core.security.auth;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;



public class TokenBasedAuthentication extends AbstractAuthenticationToken {

    private static final long serialVersionUID = 4196693492815240311L;

    private String token;
    private final UserDetails principle;

    public TokenBasedAuthentication( UserDetails principle ) {
        super( principle.getAuthorities() );
        this.principle = principle;
    }

    public String getToken() {
        return token;
    }

    public void setToken( String token ) {
        this.token = token;
    }

    @Override
    public boolean isAuthenticated() {
        return true;
    }

    @Override
    public Object getCredentials() {
        return token;
    }

    @Override
    public UserDetails getPrincipal() {
        return principle;
    }

}
