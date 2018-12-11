package com.coffee.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.coffee.intercepter.AuthenticationInterceptor;


@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
	  @Override
	    public void addInterceptors(InterceptorRegistry registry) {
	        registry.addInterceptor(authenticationInterceptor())
	                .addPathPatterns("/**").excludePathPatterns("/").excludePathPatterns("/login");   
	    }
	    @Bean
	    public AuthenticationInterceptor authenticationInterceptor() {
	        return new AuthenticationInterceptor();
	    }
}

