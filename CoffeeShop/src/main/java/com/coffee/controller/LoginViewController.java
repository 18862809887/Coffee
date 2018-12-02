package com.coffee.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginViewController {
	private String rightUserNameString = "admin";
	private String rightPassWordString = "admin";
	
	@RequestMapping("/login")
	public String  login(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username);
		System.out.println(password);
		if (null == username||null == password) {
			return "redirect:/";
		}
		
		if (!password.equals(rightPassWordString) ||!username.equals(rightUserNameString)) {
			return "redirect:/";
		}
		System.out.println("1111");
		request.getSession().setAttribute("loginName", "admin");

			return "redirect:/welcome";
	}
	
	@RequestMapping("/loginout")
	public String  loginOut(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/";
	}
	
	
}
