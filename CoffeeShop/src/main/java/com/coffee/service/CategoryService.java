package com.coffee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffee.dao.CategoryDao;
import com.coffee.entity.Category;


@Service
public class CategoryService {
	@Autowired
	private CategoryDao categoryDao;
	
	public List<Category> findAllCateory()
	{
		return categoryDao.findAll();
	}
	
	
}
