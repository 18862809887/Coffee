package com.coffee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.coffee.entity.Category;
import com.coffee.service.CategoryService;


@Controller
public class CategoryController {
	@Autowired
	private CategoryService categoryService;

	@ResponseBody
	@RequestMapping("/ListCategory")
	public String findAllCategory()
	{
		List<Category> categories = categoryService.findAllCateory();
		String categoryJson = JSON.toJSONString(categories);
		return categoryJson;
	}
}
