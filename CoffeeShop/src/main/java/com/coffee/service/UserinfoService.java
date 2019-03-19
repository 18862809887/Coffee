package com.coffee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffee.dao.UserinfoDao;
import com.coffee.entity.Userinfo;

@Service
public class UserinfoService  {
	@Autowired
	private UserinfoDao userinfoDao;
	
	public List<Userinfo> findUserByName(String username){
		return userinfoDao.findUserByUsername(username);
	}
	
	public Userinfo saveUser (Userinfo userinfo){
		return userinfoDao.save(userinfo);
		
	}
}
