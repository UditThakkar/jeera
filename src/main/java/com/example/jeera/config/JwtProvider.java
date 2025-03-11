package com.example.jeera.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import javax.crypto.SecretKey;

import java.util.Collection;
import java.util.Date;

import static com.example.jeera.utils.Constant.SECRET_KEY;

public class JwtProvider {
    private static final SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

    public static String generateToken(Authentication authentication) {
        String jwt = Jwts.builder().issuedAt(new Date())
                .expiration(new Date(new Date().getTime() + 864000000))
                .claim("email", authentication.getName())
                .signWith(key)
                .compact();

        return jwt;
    }

    public static String getEmailFromJwtToken(String jwt) {
        Claims claims = Jwts.parser().verifyWith(key).build().parseSignedClaims(jwt).getPayload();
        return String.valueOf(claims.get("email"));
    }
}
