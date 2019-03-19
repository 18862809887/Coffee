package com.coffee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.coffee.entity.Category;
import com.coffee.entity.Coffee;
import com.coffee.service.CategoryService;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CategoryController {
	@Autowired
	private CategoryService categoryService;



	@RequestMapping("/ListCategory")
	public List<Category> findAllCategory()
	{
		List<Category> categories= categoryService.findAllCateory();
		//Category category = categories.get(0);
		//List<Coffee> coffees = category.getCoffees();
		//String categoryJson = JSON.toJSONString(categories);
		return categories;
	}
}
