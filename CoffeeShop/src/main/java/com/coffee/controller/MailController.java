package com.coffee.controller;

import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisServer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coffee.dto.Msg;
import com.coffee.entity.RedisUser;
import com.coffee.entity.Userinfo;
import com.coffee.service.MailService;
import com.coffee.service.RedisUserService;







@Controller
public class MailController {
	@Autowired
	private MailService mailService;
	
	@Autowired
	private RedisUserService redisServer;
	@ResponseBody
	@RequestMapping("/getCheckCode")
	public Msg getCheckCode(Userinfo userinfo,String email)
	{
		String checkCode = String.valueOf(new Random().nextInt(899999)+100000);
		System.out.println(email);
		Msg reMessage = new Msg();
		String message = "您的注册验证码为: "+checkCode;
		try {
			mailService.sendSimpleMail(email, "注册验证码", message);
			RedisUser user = new RedisUser();
			user.setName(userinfo.getUserName());
			user.setCode(checkCode);
			Date date = new Date();
			user.setDate(date);
			redisServer.saveUser(user);
		} catch (Exception e) {
			return reMessage.add("result", "fail");
		}

        return reMessage.add("result", "success");
	}
	
	@RequestMapping("send")
	public String send()
	{
		return "sendMail";
	}

}
