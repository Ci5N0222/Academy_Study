package com.kedu.config.filters;

import com.kedu.services.MembersService;
import com.kedu.utils.JWTUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JWTAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JWTUtil jwt;

    @Autowired
    private MembersService membersService;

    /** Request Header에서 token 값을 뽑아오는 메서드 **/
    private String expractToken(HttpServletRequest request) {
        String auth = request.getHeader("Authorization");
        if(auth != null && auth.startsWith("Bearer ")) {
            return auth.substring(7);
        }

        return null;
    }

    /**
     *  !! Spring Security 는 토큰이 유효하냐? 또는 세션에 LoginID가 있느냐 없느냐? 를 인증 기준으로 사용하지 않음
     *  SecurityContextHolder에 Authentication 객체가 들어있는지 안들어있는지를 인증 여부로 판단한다.
     */

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = expractToken(request);

        /** 유효한 토큰일 경우 **/
        if(token != null && jwt.isVerified(token)) {
            String id = jwt.getSubject(token);
            UserDetails user = membersService.loadUserByUsername(id);

            // Spring Security 에서 인증된 사용자를 저장하는 방법
            Authentication auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());  // Authentication 객체를 상속 받은 객체
            SecurityContextHolder.getContext().setAuthentication(auth);
        }

        filterChain.doFilter(request, response);
    }
}
