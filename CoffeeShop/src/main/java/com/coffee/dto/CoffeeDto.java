package com.coffee.dto;

import com.coffee.entity.Category;
import com.coffee.entity.Picture;

public class CoffeeDto {
	
	private int coffeeId;
	

	private String coffeeName;

	

	private double coffeePrice;
	
	

	
	
	
	//private Category category;
	
	private Picture picture;

	public int getCoffeeId() {
		return coffeeId;
		
	}

	public void setCoffeeId(int coffeeId) {
		this.coffeeId = coffeeId;
	}

	public String getCoffeeName() {
		return coffeeName;
	}

	public void setCoffeeName(String coffeeName) {
		this.coffeeName = coffeeName;
	}

	public double getCoffeePrice() {
		return coffeePrice;
	}

	public void setCoffeePrice(double coffeePrice) {
		this.coffeePrice = coffeePrice;
	}




/*	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}*/

	public Picture getPicture() {
		return picture;
	}

	public void setPicture(Picture picture) {
		this.picture = picture;
	}

/*	@Override
	public String toString() {
		return "CoffeeDto [coffeeId=" + coffeeId + ", coffeeName=" + coffeeName + ", coffeePrice=" + coffeePrice
				+ ", category=" + category + ", picture=" + picture + "]";
	}*/


	
	
	
	


}
