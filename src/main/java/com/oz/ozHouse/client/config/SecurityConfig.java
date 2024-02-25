package com.oz.ozHouse.client.config;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

import com.oz.ozHouse.client.security.CustomSocialLoginSuccessHandler;
 
@Configuration
@EnableWebSecurity
@PropertySources({
    @PropertySource("classpath:kakao.properties"),
    @PropertySource("classpath:application.properties")
})
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {    
	@Bean
	public AuthenticationSuccessHandler authenticationSuccessHandler() {
		return new CustomSocialLoginSuccessHandler();
	}
	
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
	        .csrf().disable() // csrf 토큰 사용 X
	        .cors().disable() // cors 방지
	        .headers().frameOptions().disable();
        
        
        http
	        .formLogin(login -> login	// form 방식 로그인 사용
	        		.loginPage("/member/login")
    				.loginProcessingUrl("/member/login")
			        .usernameParameter("memberId")	// [C] submit할 아이디
			        .passwordParameter("memberPasswd")	// [D] submit할 비밀번호
    				.defaultSuccessUrl("/main", true)
	        )
	        .logout(withDefaults()); 
        
        http
	        .oauth2Login()
	        		.loginPage("/member/login")
	        		.successHandler(authenticationSuccessHandler()); 
        			


        return http.build();
    }
    
    @Bean
    public WebSecurityCustomizer webSecurity() {
    	
    	// 정적 리소스 (css) 등 로그인 권한 필요 X
    	return (web) -> web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
	/*
	어노테이션을 이용한 권한 체크 : 로그인 처리가 되는 것을 확인했다면, 
	특정한 경로에 시큐리티를 적용해 보아야 한다.
	게시물 목록은 로그인 여부에 관계없이 볼 수 있지만 글 쓰기는 로그인한 사람만 되어야 한다.
	어노테이션을 이용하여!
	@EnableGlobalMethodSecurity
	*/
    
    //이중 슬래시
    @Bean
    public HttpFirewall allowUrlEncodedSlashHttpFirewall() {
        StrictHttpFirewall firewall = new StrictHttpFirewall();
        firewall.setAllowUrlEncodedDoubleSlash(true); // 이 부분을 true로 설정하여 URL 인코딩된 이중 슬래시를 허용하도록 변경
        firewall.setAllowUrlEncodedSlash(true); // 필요한 경우 URL 인코딩된 슬래시도 허용하도록 설정
        return firewall;
    }
    
    //웹소켓 연결을 위한 비동기 처리
    static {
        // 애플리케이션 시작 시 SecurityContextHolder의 전략을 MODE_INHERITABLETHREADLOCAL로 설정
        SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_INHERITABLETHREADLOCAL);
    }
}