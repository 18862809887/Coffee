package com.coffee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffee.dao.UserinfoDao;

@Service
public class UserinfoService  {
	@Autowired
	private UserinfoDao userinfoDao;
	
	
}
