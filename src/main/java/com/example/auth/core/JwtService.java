package com.example.auth.core;


import org.springframework.beans.factory.annotation.Value;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;

/*d

@Since 5/25/2026
@Author qle20

*/
@Service
public class JwtService {
    @Value("${secret.token}")
    private String secretKey;
    private static final long EXPIRATION_TIME = 86400000; // 24 hours

    private Key getSignInKey() {
        return Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    public String generateToken(String email){
        return io.jsonwebtoken.Jwts.builder()
                .setSubject(email)
                .signWith(getSignInKey())
                .setExpiration(new java.util.Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .compact();
    }
}
