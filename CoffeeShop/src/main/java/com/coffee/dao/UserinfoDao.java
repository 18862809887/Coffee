package com.coffee.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.coffee.entity.Userinfo;


public interface UserinfoDao extends JpaRepository<Userinfo, Integer>{
	@Query(value = "select * from userinfo u where u.user_name =?1 " , nativeQuery = true )
	public List<Userinfo> findUserByUsername(String username);
	
	@Query(value = "select * from userinfo u where u.user_name =?1 " , nativeQuery = true )
	public List<Object> findUserByUsername1(String username);
}
