package com.example.knifes.security;


import com.example.knifes.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class TokenFactory {

    private final JwtUtil jwtUtil;
    private final JwtBuilder jwtBuilder;

    public TokenFactory(JwtUtil jwtUtil, JwtBuilder jwtBuilder) {

        this.jwtUtil = jwtUtil;
        this.jwtBuilder = jwtBuilder;
    }

    public String createJwt(User user) {
        Map<String, Object> claims = new HashMap<>();

        List<String> roles = user.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .toList();
        claims.put("roles", roles);

        return jwtBuilder.buildJwt(claims, user.getUsername());
    }
}