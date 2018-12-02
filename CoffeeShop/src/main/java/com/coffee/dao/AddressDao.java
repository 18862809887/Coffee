package com.coffee.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffee.entity.Address;

public interface AddressDao extends JpaRepository<Address,Integer>{
	
}
