package com.codegym.security.jwt;

import com.codegym.security.userprincal.USerPrinciple;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtProvider.class);

    private String jwtSecret = "SangDD.laptopStore";

    private int jwtExpiration = 86400;

    public String createToken(Authentication authentication) {
        USerPrinciple uSerPrinciple = (USerPrinciple) authentication.getPrincipal();
        return Jwts.builder().setSubject(uSerPrinciple.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + jwtExpiration*1000))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public Boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        } catch (SignatureException e) {
            LOGGER.error("invalid jwt signature", e);
        } catch (MalformedJwtException e) {
            LOGGER.error("invalid jwt MalformedJwtException", e);
        } catch (ExpiredJwtException e) {
            LOGGER.error("invalid jwt ExpiredJwtException", e);
        } catch (UnsupportedJwtException e) {
            LOGGER.error("invalid jwt UnsupportedJwtException", e);
        } catch (IllegalArgumentException e) {
            LOGGER.error("invalid jwt IllegalArgumentException", e);
        }
        return false;
    }

    public String getUserNameFromToken(String token) {
        String userName = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
        return userName;
    }
}
