package com.coffee.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.coffee.entity.Userinfo;

public interface UserinfoDao extends JpaRepository<Userinfo, Integer>{
	
}
