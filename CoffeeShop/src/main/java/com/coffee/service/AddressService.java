package com.coffee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffee.dao.AddressDao;
import com.coffee.entity.Address;
import com.coffee.entity.Userinfo;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AddressService {
	@Autowired
	private AddressDao addressDao;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	//PROPAGATION_REQUIRED
	//如果当前没有事务，就新建一个事务，如果已经存在一个事务中，加入到这个事务中。这是最常见的选择。
	public String addAddress (Address address,int userId){
		Userinfo userinfo = new Userinfo();
		userinfo.setUserId(userId);
		address.setUserinfo(userinfo);

	/*	addressDao.save(address);*/
		addressDao.saveAndFlush(address);
		return "success";
	}
}
