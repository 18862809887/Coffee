package com.coffee.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="coffee")
public class CoffeeDto {
	@Id
	@Column(name="coffee_id")
	private int coffeeId;
	
	@Column(name="coffee_name")
	private String coffeeName;

	
	@Column(name="coffee_price")
	private double coffeePrice;
	
	@Column(name="categoryid")
	private int categoryid;
	
	@Column(name="pictureid")
	private int pictureid;

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

	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	public int getPictureid() {
		return pictureid;
	}

	public void setPictureid(int pictureid) {
		this.pictureid = pictureid;
	}


	
	
	
	


}
