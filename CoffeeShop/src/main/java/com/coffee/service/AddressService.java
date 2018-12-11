package com.coffee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffee.dao.AddressDao;
import com.coffee.entity.Address;
import com.coffee.entity.Userinfo;

@Service
public class AddressService {
	@Autowired
	private AddressDao addressDao;
	
	public String addAddress (Address address,int userId){
		Userinfo userinfo = new Userinfo();
		userinfo.setUserId(userId);
		address.setUserinfo(userinfo);
	/*	addressDao.save(address);*/
		addressDao.saveAndFlush(address);
		return "success";
	}
}
