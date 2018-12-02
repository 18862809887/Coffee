package com.coffee.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.coffee.dto.CoffeeDto;
import com.coffee.entity.Category;
import com.coffee.entity.Coffee;

public interface CoffeeDao extends JpaRepository<Coffee, Integer>{
	@Query(value="select c.coffee_id , c.coffee_name , c.coffee_price , c.categoryid , c.pictureid , c.description from coffee c where c.categoryid =?1", nativeQuery= true)
	public List<Object> findAllByCategoryid(int categoryId);

	@Query(value="select * from coffee c where c.categoryid =?1", nativeQuery= true)
	public List<Coffee> findAllByid(int categoryId);
	
	/*@Query (value="select s from coffee c inner join c.category where c.coffee_id=?1",nativeQuery=true)
	public List<Category> findAlll(int coffeeid);*/
}
