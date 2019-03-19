package com.coffee.dao;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.coffee.entity.Category;


public interface CategoryDao extends JpaRepository<Category, Integer>{
	
	@Query(value="select * from category c " , nativeQuery= true)
	List<Category> findAllCategory();
}
