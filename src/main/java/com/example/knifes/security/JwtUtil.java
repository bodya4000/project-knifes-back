package com.example.knifes.security;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.time.Duration;
import java.util.Date;

@Component
public class JwtUtil {
    private String secret = "W5Eca1S9aAf8l8Q6tVV1g5KrJyHUZ+BYi/GRpm1KhdQ=";

    private Duration jwtLifetime = Duration.ofMinutes(1);

    public Key getSignKey(){
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public Date issuedAt(){
        return new Date(System.currentTimeMillis());
    }

    public Date expiration(){
        return new Date(System.currentTimeMillis()+jwtLifetime.toMillis());
    }

}