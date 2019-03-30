package com.coffee.dto;

import java.io.Serializable;
import java.util.List;

import com.coffee.entity.Coffee;

public class CategoryDto implements Serializable{


	private static final long serialVersionUID = 1L;

	private int categoryId;
	
	private String categoryName;
	
	private List<Coffee> coffees;

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<Coffee> getCoffees() {
		return coffees;
	}

	public void setCoffees(List<Coffee> coffees) {
		this.coffees = coffees;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
