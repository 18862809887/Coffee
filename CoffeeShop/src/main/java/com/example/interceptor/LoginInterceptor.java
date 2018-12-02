package com.example.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Object loginName = request.getSession().getAttribute("loginName");
		if (null == loginName || !(loginName instanceof String)) {
			//未登录，重定向到登陆页面
			response.sendRedirect("/");
			return false;
		}
		String userName = (String)loginName;
		System.out.println("但钱用户已登录，登陆的用户名为"+userName);
		return true;
	}

}
