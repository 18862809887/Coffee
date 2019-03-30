package com.coffee.controller;

import static org.mockito.Mockito.ignoreStubs;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coffee.dto.Msg;
import com.coffee.dto.SpecificationDto;
import com.coffee.entity.Specification;
import com.coffee.service.SpecificationService;

@Controller
public class SpecificationController {
	@Autowired
	private SpecificationService specificationService;
	
	@ResponseBody
	@RequestMapping("/findAllSpe")
	public List<SpecificationDto> findAllSpe()
	{	List<SpecificationDto> specificationDtos = new ArrayList<>();
 		List<Specification> specifications = specificationService.querySpecification();
		for(int i = 0 ; i < specifications.size() ; i++)
		{	Specification specification = specifications.get(i);
			String result = specification.getTemperature()+"+"+specification.getSugars()+"+"+specification.getVolume()+"+"+specification.getMilk();
			
			SpecificationDto specificationDto = new SpecificationDto();
			//msg.add("result", value)
			specificationDto.setSpecId(specification.getSpecId());
			specificationDto.setSpecification(result);
			specificationDtos.add(specificationDto);
		}
		return specificationDtos;
	}
	
}
