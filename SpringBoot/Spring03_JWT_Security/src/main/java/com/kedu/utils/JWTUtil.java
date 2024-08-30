package com.kedu.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTUtil {

    // 로큰이 만료되기 까지 걸리는 시간 값
    private long expiration = 86400;

    private Algorithm algo;

    private JWTVerifier verifier;

    public JWTUtil(@Value("${jwt.secret}")String secret) {
        this.algo = Algorithm.HMAC256(secret);
        this.verifier = JWT.require(algo).build();
    }

    
    /** 토큰을 생성하는 메서드 **/
    public String createToken(String id) {
        return JWT.create()
                .withSubject(id)
//                .withClaim("name", "name")
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + (expiration*1000)))
                .sign(this.algo);
        /**
         *  JWT 3가지 영역
         *  1. Header
         *      - JWT, HMAC256
         *  2. Payload
         *      - 추가한 정보 ( Subject, Issued, Expires )
         *      - Base64 Encoding ( random text )
         *  3. Signature
         *      - Header 와  payload와 secret key를 사용하여 암호화
         *
         *  withClaim을 통해 원하는 값을 넣을 수 있다.
         */
    }

    /** 토큰을 검증하는 메서드 **/
    public DecodedJWT verify(String token) {
        
        // Signature를 통해 유효한 토큰인지 검증
        return this.verifier.verify(token);
    }

    public boolean isVerified(String token) {
        try {
            this.verifier.verify(token);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    /**  **/
    public String getSubject(String token) {
        return this.verifier.verify(token).getSubject();
    }


}
