package com.coffee.controller;


import javax.servlet.http.HttpServletRequest;

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
	
	@Autowired
	private HttpServletRequest request;
	
	/*@ResponseBody
	@RequestMapping("/addAddress")
	public String addAddress(Address address){
		String token = request.getHeader("token");
		System.out.println("wq123");
		return addressService.addAddress(address,);
	}*/
}
