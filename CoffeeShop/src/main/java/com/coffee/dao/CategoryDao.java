package com.coffee.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.coffee.entity.Category;


public interface CategoryDao extends JpaRepository<Category, Integer>{
	/*@Query(value="select c.category_id , c.category_name from category c "  )
	public List<Object> findAllCategory();*/
}
