package com.dvfu.digital_platform_core.security.auth;

import com.dvfu.digital_platform_core.dao.User;
import com.dvfu.digital_platform_core.dao.UserTokenState;
import com.dvfu.digital_platform_core.security.TokenHelper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Value("${jwt.expires_in}")
    private int EXPIRES_IN;

    @Value("${jwt.cookie}")
    private String TOKEN_COOKIE;

    @Autowired
    private TokenHelper tokenHelper;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        clearAuthenticationAttributes(request);
        User user = (User) authentication.getPrincipal();

        String jws = tokenHelper.generateToken(user.getUsername());

        // Create token auth Cookie
        Cookie authCookie = new Cookie(TOKEN_COOKIE, (jws));

        authCookie.setHttpOnly(true);

        authCookie.setMaxAge(EXPIRES_IN);

        authCookie.setPath("/");
        // Add cookie to response
        response.addCookie(authCookie);

        // JWT is also in the response
        UserTokenState userTokenState = new UserTokenState(jws, EXPIRES_IN);
        String jwtResponse = objectMapper.writeValueAsString(userTokenState);
        response.setContentType("application/json");
        response.getWriter().write(jwtResponse);

    }
}