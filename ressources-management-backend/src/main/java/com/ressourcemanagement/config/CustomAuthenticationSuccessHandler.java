package com.ressourcemanagement.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;
import java.util.Collection;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler, AuthenticationFailureHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for (GrantedAuthority grantedAuthority : authorities) {
            if (grantedAuthority.getAuthority().equals("ROLE_RESPONSABLE")) {
                response.sendRedirect("/responsable");
                break;
            } else if (grantedAuthority.getAuthority().equals("ROLE_ENSEIGNANT")) {
                response.sendRedirect("/enseignant");
                break;
            } else if (grantedAuthority.getAuthority().equals("ROLE_TECHNICIEN")) {
                response.sendRedirect("/technicien");
                break;
            } else if (grantedAuthority.getAuthority().equals("ROLE_FOURNISSEUR")) {
                response.sendRedirect("/fournisseur");
                break;
            } else {
                throw new IllegalStateException();
            }
        }
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        if (exception instanceof BadCredentialsException) {
            response.sendRedirect("/login?error");
        } else {
            response.sendRedirect("/login?error=unknown");
        }
    }
}