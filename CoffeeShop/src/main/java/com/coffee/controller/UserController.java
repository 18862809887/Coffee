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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.coffee.dao.UserinfoDao;
import com.coffee.dto.Msg;
import com.coffee.entity.Picture;
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
	private TokenService tokenService;
	
	@Autowired
	private MD5Service md5Service;
	
	
	@RequestMapping("/")
	public String Index(){
		return "login";
	}	
	
	@RequestMapping("/welcome")
	public String welcome(){
		return "welcome";
	}
	
	@RequestMapping("/addPicture")
	public String addPicture(){
		Userinfo userinfo  = new Userinfo();
		userinfo.setUserName("tingting");
		userinfo.setPassword("12345");
		userinfo.setEmail("1980721419@qq.com");
		userinfo.setTelephone("18862809887");
		Picture picture = new Picture();
		picture.setPictureName("touxiang");
		picture.setPicturePath("C://test/picture");
		picture.setSplit("1");
		userinfo.setPicture(picture);
		userinfoService.saveUser(userinfo);
		return "1";
	}
	
	@ResponseBody
	@RequestMapping("/login")
	public String  login(Userinfo user)
	{
		Map<String, Object> resultMap = new HashMap<>();
		List<Userinfo> userList = userinfoService.findUserByName(user.getUserName());
		if (userList.size()==0) {
			resultMap.put("message", "登陆失败，用户不存在");
			return JSON.toJSONString(resultMap);
		}
		else if(!md5Service.generate(user.getPassword(), userList.get(0).getSalt()).equals((userList.get(0)).getPassword())){
			resultMap.put("message", "登陆失败。密码错误");
		   return JSON.toJSONString(resultMap);
		}else {
			String token = tokenService.generateToken(userList.get(0));
			resultMap.put("token", token);
			System.out.println("expire:"+tokenService.getExpire());
			resultMap.put("expire",tokenService.getExpire());
			return JSON.toJSONString(resultMap);
		}
	}
	
	@ResponseBody
	@RequestMapping("/register")
	public Msg registe(Userinfo user){
		List<Userinfo> userList = userinfoService.findUserByName(user.getUserName());
		Msg msg = new Msg();
		if (userList.size()>0) {
			return msg.add("regist", "fail");//如果返回为0表示用户名已经存在
		}
		else if (user.getUserName()==null|| user.getPassword()==null || user.getUserName().trim()=="" || user.getPassword().trim()=="") {
			return msg.add("regist", "isNotNull");
		}
		else
		{
			System.out.println("username"+user.getUserName());
			System.out.println("password"+user.getPassword());
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
	 		System.out.println("加盐后的密码"+password);
	 		user.setSalt(salt);
	 		user.setPassword(password);
	 		userinfoService.saveUser(user);
	 		msg.add("regist", "success");
			return msg;
		}
		
	}
	
	
	

	
	
	
	@RequestMapping("/loginout")
	public String  loginOut(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/";
	}
	
	
}
