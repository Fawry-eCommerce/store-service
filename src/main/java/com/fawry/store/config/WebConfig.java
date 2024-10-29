package com.fawry.store.config;

import com.fawry.store.interceptor.SecurityInterceptor;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

    private final SecurityInterceptor securityInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                if (!request.getMethod().equalsIgnoreCase("GET")
                        || request.getRequestURI().contains("consumptions")) {
                    return securityInterceptor.preHandle(request, response, handler);
                }
                return true;
            }
        }).addPathPatterns("/stores/**")
                .addPathPatterns("/stocks/**");
    }

}
