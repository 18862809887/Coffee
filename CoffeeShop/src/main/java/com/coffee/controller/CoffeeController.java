package com.coffee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.coffee.dto.CoffeeDto;
import com.coffee.entity.Coffee;
import com.coffee.service.CoffeeService;

@Controller
public class CoffeeController {
	@Autowired
	private CoffeeService coffeeService;
	
	@ResponseBody
	@RequestMapping("/findCoffeeByid")
	public String findAllByid(int categoryid){
		List<Coffee> coffees = coffeeService.findAllByid(categoryid);
		String coffeeJson = JSON.toJSONString(coffees);
		return coffeeJson;
	}
	
	
}
