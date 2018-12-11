package com.coffee.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coffee.entity.Address;
import com.coffee.service.AddressService;

@Controller
public class AddressController {
	@Autowired
	private AddressService addressService;
	
	@ResponseBody
	@RequestMapping("/addAddress")
	public String addAddress(Address address ,int userId){
		System.out.println("wq123");
		return addressService.addAddress(address,userId);
		/*return "success";*/
	}
}
