package com.coffee.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.imageio.spi.RegisterableService;
import javax.persistence.Index;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.User;
import org.mockito.internal.matchers.Find;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.coffee.dao.UserinfoDao;
import com.coffee.entity.Userinfo;
import com.coffee.service.MD5Service;
import com.coffee.service.TokenService;
import com.coffee.service.UserinfoService;

import ch.qos.logback.core.joran.conditional.IfAction;

@Controller
public class UserController {
	
	@Autowired 
	private UserinfoService userinfoService;
	
	@Autowired
	private UserinfoDao userinfoDao;
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private MD5Service md5Service;
	
	
	@RequestMapping("/")
	public String Index(){
		return "login";
	}
/*	@ResponseBody
	@RequestMapping("/findByusername")
	public Object Find(Userinfo userinfo){
		List<Object> userList = userinfoDao.findUserByUsername(userinfo.getUserName());
		return userList.get(0);
	}*/
	
	
	@RequestMapping("/welcome")
	public String welcome(){
		return "welcome";
	}
	
	
	@ResponseBody
	@RequestMapping("/login")
	public Object  login(Userinfo user)
	{
		JSONObject jsonObject = new JSONObject();
		List<Userinfo> userList = userinfoService.findUserByName(user.getUserName());
		if (userList.size()==0) {
			jsonObject.put("message", "登陆失败，用户不存在");
			return jsonObject;
		}
		else if(!user.getPassword().equals((userList.get(0)).getPassword())){
			jsonObject.put("message", "登陆失败。密码错误");
		   return jsonObject;
		}else {
			String token = tokenService.getToken(userList.get(0));
			jsonObject.put("token", token);
			jsonObject.put("user",JSON.toJSONString(userList.get(0)));
			return jsonObject;
		}
	}
	
	
	public String registe(Userinfo user){
		List<Userinfo> userList = userinfoService.findUserByName(user.getUserName());
		if (userList.size()>0) {
			return JSON.toJSONString("0");
		}
		else
		{
		
			String password = user.getPassword();
			Random r = new Random();
	 		StringBuilder sb = new StringBuilder(16);
	 		sb.append(r.nextInt(99999999)).append(r.nextInt(99999999));
	 		int len = sb.length();
	 		if (len < 16) {
	 			for (int i = 0; i < 16 - len; i++) {
	 				sb.append("0");
	 			}
	 		}
	 		String salt = sb.toString();
	 		password = md5Service.generate(password, salt);
	 		user.setSalt(salt);
	 		user.setPassword(password);
	 		userinfoService.saveUser(user);
	 		return JSON.toJSONString(1);
		}
		
	}
	
	
	@RequestMapping("/loginout")
	public String  loginOut(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/";
	}
	
	
}
