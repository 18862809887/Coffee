package com.coffee.service;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.coffee.entity.Userinfo;

@Service("TokenService")
public class TokenService {
	public String getToken(Userinfo user){
		String token="";
		token = JWT.create().withAudience(user.getUserName()).sign(Algorithm.HMAC256(user.getPassword()));
		
		return token;
	}
}
