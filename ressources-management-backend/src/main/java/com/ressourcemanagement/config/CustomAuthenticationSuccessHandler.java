package com.ressourcemanagement.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;
import java.util.Collection;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for (GrantedAuthority grantedAuthority : authorities) {
            if (grantedAuthority.getAuthority().equals("RESPONSABLE")) {
                response.sendRedirect("/responsable");
                break;
            } else if (grantedAuthority.getAuthority().equals("ENSEIGNANT")) {
                response.sendRedirect("/enseignant");
                break;
            } else if (grantedAuthority.getAuthority().equals("TECHNICIEN")) {
                response.sendRedirect("/technicien");
            } else {
                throw new IllegalStateException();
            }
        }
    }
}