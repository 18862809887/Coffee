package com.coffee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffee.dao.SpecificationDao;
import com.coffee.entity.Specification;

@Service
public class SpecificationService {
	@Autowired
	private SpecificationDao specificationDao;
	
	public List<Specification> querySpecification()
	{
		
		return specificationDao.findAll();
		
	}
	
	
}
