package com.coffee.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
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
	public List<CoffeeDto> findAllByid(int categoryid){
		List<Coffee> coffees = coffeeService.findAllByid(categoryid);
		List<CoffeeDto> coffeeDtos = new ArrayList<>();
		for (int i = 0; i < coffees.size(); i++) {
			CoffeeDto coffeeDto = new CoffeeDto();
			Coffee coffee = coffees.get(i);
			try {
				BeanUtils.copyProperties(coffeeDto,coffee);
			//	System.out.println(coffeeDto.toString());
				
				
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			coffeeDtos.add(coffeeDto);
		}
		return coffeeDtos;
	}
	
	
}
