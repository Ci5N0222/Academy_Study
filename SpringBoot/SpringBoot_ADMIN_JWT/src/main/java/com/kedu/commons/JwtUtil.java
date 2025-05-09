package com.kedu.commons;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    private long expiration = 86400;
    private Algorithm algo;
    private JWTVerifier verifier;

    public JwtUtil(@Value("${jwt.secret}") String secret) {
        this.algo = Algorithm.HMAC256(secret);
        this.verifier = JWT.require(algo).build();
    }

    public String createToken(String id) {
        return JWT.create()
                .withSubject(id)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + expiration*1000))
                .sign(this.algo);
    }

    public DecodedJWT verify(String token) {
        return this.verifier.verify(token);
    }

    public String getSubject(String token) {
        return this.verifier.verify(token).getSubject();
    }

}
