package com.oz.ozHouse.merchant.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.oz.ozHouse.merchant.Interceptor.LoginInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    
    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/merchant//store/storeHome") // 인터셉터를 적용할 경로 패턴
                .excludePathPatterns("/merchant/login"); // 인터셉터 적용 제외 경로
    }
}
