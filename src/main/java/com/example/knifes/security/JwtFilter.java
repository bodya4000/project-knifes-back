package com.example.knifes.security;

import io.jsonwebtoken.MalformedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Logger;

@Component
public class JwtFilter extends OncePerRequestFilter {

    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String BEARER = "Bearer";

    private final JwtParser jwtParser;

    private static final Logger logger = Logger.getLogger(JwtFilter.class.getName());


    public JwtFilter(JwtParser jwtParser) {
        this.jwtParser = jwtParser;
    }


    private record JwtAndUsername(String jwt, String username){}
    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain) throws ServletException, IOException {
        Enumeration<String> headerNames = request.getHeaderNames();
        List<String> headers = new ArrayList<>();
        while (headerNames.hasMoreElements()) {
            headers.add(headerNames.nextElement());
        }
        String authHeader = request.getHeader(AUTHORIZATION_HEADER);
        JwtAndUsername jwtAndUsername = parseJwtAndUsernameFromAuthHeader(authHeader);

        String jwt = jwtAndUsername.jwt();
        String username = jwtAndUsername.username();

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            addUsersAuthTokenToContext(jwt, username);
        }
        filterChain.doFilter(request, response);
    }

    private void addUsersAuthTokenToContext(String jwt, String username) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                username,
                null,
                jwtParser.extractRoles(jwt).stream().map(SimpleGrantedAuthority::new).toList());
        SecurityContextHolder.getContext().setAuthentication(token);}

    private JwtAndUsername parseJwtAndUsernameFromAuthHeader(String authHeader) {
        if (authHeader!= null && authHeader.startsWith(BEARER)){
            String jwtToken = authHeader.substring(7);
            boolean isJWtTokenValid = validateJwtToken(jwtToken);
            if (isJWtTokenValid) {
                String username = parseUsernameFromJwt(jwtToken);
                return new JwtAndUsername(jwtToken, username);
            }
        }
        return new JwtAndUsername(null, null);
    }

    private String parseUsernameFromJwt(String jwt) {
        return jwtParser.extractUsername(jwt);
    }

    private boolean validateJwtToken(String jwt) {
        try {
            if (jwtParser.extractExpiration(jwt).before(new Date())) {
                throw new RuntimeException("expired access token");
            }
            return true;
        } catch (MalformedJwtException malformedJwtException) {
            return false;
        }
    }

}