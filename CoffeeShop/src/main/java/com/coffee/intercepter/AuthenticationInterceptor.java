package com.coffee.intercepter;

import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.coffee.dao.UserinfoDao;
import com.coffee.entity.Userinfo;
import com.coffee.service.UserinfoService;


public class AuthenticationInterceptor implements HandlerInterceptor {
	@Autowired
	private UserinfoService userinfoService;

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			Object object) throws Exception {
		// TODO Auto-generated method stub
		// return HandlerInterceptor.super.preHandle(request, response,
		// handler);
		System.out.println("进入拦截器");
		String token = httpServletRequest.getHeader("token");
		System.out.println("获取token" + token);

		if (token == null) {
			httpServletResponse.sendRedirect("/");
			return false;
		} else {
			// 获取 token 中的 user id
			String username;
			try {
				username = JWT.decode(token).getAudience().get(0);
			} catch (JWTDecodeException j) {
				throw new RuntimeException("401");
			}
			List<Userinfo> user = userinfoService.findUserByName(username);
			if (user.size() == 0) {
				throw new RuntimeException("用户不存在，请重新登录");
			}
			// 验证 token
			JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256((user.get(0)).getPassword())).build();
			try {
				jwtVerifier.verify(token);
			} catch (JWTVerificationException e) {
				throw new RuntimeException("401");
			}
			return true;
		}
	}

}
