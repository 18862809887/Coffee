package com.coffee.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coffee.entity.Specification;

public interface SpecificationDao extends JpaRepository<Specification, Integer>{

}
