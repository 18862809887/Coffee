package com.coffee.controller;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.coffee.dto.CategoryDto;
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
		/*List<CategoryDto> categoryDtos = new ArrayList<>();
		for (int i = 0; i < categories.size(); i++) {
			CategoryDto categoryDto = new CategoryDto();
			try {
				BeanUtils.copyProperties(categoryDto, categoryDtos.get(i));
				categoryDtos.add(categoryDto);
				
			} catch (IllegalAccessException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		//Category category = categories.get(0);
		//List<Coffee> coffees = category.getCoffees();
		//String categoryJson = JSON.toJSONString(categories);
		return categories;
	}
}
