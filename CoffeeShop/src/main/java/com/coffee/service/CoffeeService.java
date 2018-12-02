package com.coffee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffee.dao.CoffeeDao;
import com.coffee.dto.CoffeeDto;
import com.coffee.entity.Coffee;

@Service
public class CoffeeService {

		@Autowired
		private CoffeeDao coffeeDao;
		
		public List<Object> findAllByCategoryid(int categoryId){
			return coffeeDao.findAllByCategoryid(categoryId);
		}
		
		public List<Coffee> findAllByid(int categoryId){
			return coffeeDao.findAllByid(categoryId);
		}
}
