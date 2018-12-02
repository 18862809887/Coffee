package com.coffee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffee.dao.AddressDao;
import com.coffee.entity.Address;

@Service
public class AddressService {
	@Autowired
	private AddressDao addressDao;
	
	public String addAddress (Address address){
		addressDao.save(address);
		return "success";
	}
}
