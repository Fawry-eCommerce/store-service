package com.fawry.store.interceptor;

import com.fawry.store.exception.UnauthorizedException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@Setter
public class SecurityInterceptor implements HandlerInterceptor {

//    private AuthProxy authProxy; // TODO: solve dependency cycle injection

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)  {
//        String token = request.getHeader("Authorization");
//        if (token == null || token.isEmpty()) {
//            throw new UnauthorizedException();
//        }
//
////         if (!authProxy.hasAnyRole("SUPER", "ADVANCED", "NORMAL", token)) {
////             response.setStatus(HttpServletResponse.SC_FORBIDDEN);
////             return false;
////         }

        return true;
    }

}
