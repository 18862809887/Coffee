/*package com.coffee.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.interceptor.LoginInterceptor;
@Configuration
public class LoginConfiguration extends WebMvcConfigurationSupport{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		System.out.println("2222");
		//注册拦截器
		LoginInterceptor loginInterceptor = new LoginInterceptor();
		
		InterceptorRegistration loginRegistry = registry.addInterceptor(loginInterceptor);
		
		//拦截路径
		loginRegistry.addPathPatterns("/**");
		System.out.println("1111");
		//排除路径
		loginRegistry.excludePathPatterns("/");
		loginRegistry.excludePathPatterns("/login");
		loginRegistry.excludePathPatterns("/loginout");
		//loginRegistry.excludePathPatterns("/welcome");
		
		//排除资源请求
		//loginRegistry.excludePathPatterns("")
		
	}
	
}
*/