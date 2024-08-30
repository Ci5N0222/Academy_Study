package com.kedu.interceptors;

import com.kedu.commons.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoginValidator implements HandlerInterceptor {

    @Autowired
    private JwtUtil jwt;

    private String expractToken(HttpServletRequest request) {
        String auth = request.getHeader("Authorization");
        if(auth != null && auth.startsWith("Bearer ")) {
            return auth.substring(7);
        }
        return null;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // preflight : 브라우저 보안 검증을 위해 브라우저가 먼저 통신
        /** 브라우저의 preflight request가 들어오면 OK 응답을 보내주는 로직 **/
        if(request.getMethod().equalsIgnoreCase("OPTIONS")) {
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }
        
        String token = this.expractToken(request);
        System.out.println("token ===== " + token);

        if(token != null) {
            /** 검증 로직 **/
            try {
                String loginID = jwt.verify(token).getSubject();
                request.setAttribute("loginID", loginID);
                return true;

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("토큰 유효성 문제");
            }

        } else {
            // 비 로그인
        }
        
        /** 로그인 인증 실패 **/
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        return false;
    }
}
