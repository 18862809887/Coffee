package com.coffee.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the coffee database table.
 * 
 */
@Entity
@Table(name = "coffee")
@NamedQuery(name = "Coffee.findAll", query = "SELECT c FROM Coffee c")
public class Coffee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "coffee_id")
	private int coffeeId;

	@Column(name = "coffee_name")
	private String coffeeName;

	@Column(name = "coffee_price")
	private double coffeePrice;

	// bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name = "categoryid")
	private Category category;

	// bi-directional many-to-one association to Picture
	@ManyToOne
	@JoinColumn(name = "pictureid")
	private Picture picture;

	// bi-directional many-to-one association to Orderitem
	@OneToMany(mappedBy = "coffee")
	private List<Orderitem> orderitems;

	// bi-directional many-to-one association to Shoppingcarditem
	@OneToMany(mappedBy = "coffee")
	private List<Shoppingcarditem> shoppingcarditems;

	@Column(name = "description")
	private String description;

	public Coffee() {
	}

	public int getCoffeeId() {
		return this.coffeeId;
	}

	public void setCoffeeId(int coffeeId) {
		this.coffeeId = coffeeId;
	}

	public String getCoffeeName() {
		return this.coffeeName;
	}

	public void setCoffeeName(String coffeeName) {
		this.coffeeName = coffeeName;
	}

	public double getCoffeePrice() {
		return this.coffeePrice;
	}

	public void setCoffeePrice(double coffeePrice) {
		this.coffeePrice = coffeePrice;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Picture getPicture() {
		return this.picture;
	}

	public void setPicture(Picture picture) {
		this.picture = picture;
	}

	public List<Orderitem> getOrderitems() {
		return this.orderitems;
	}

	public void setOrderitems(List<Orderitem> orderitems) {
		this.orderitems = orderitems;
	}

	public Orderitem addOrderitem(Orderitem orderitem) {
		getOrderitems().add(orderitem);
		orderitem.setCoffee(this);

		return orderitem;
	}

	public Orderitem removeOrderitem(Orderitem orderitem) {
		getOrderitems().remove(orderitem);
		orderitem.setCoffee(null);

		return orderitem;
	}

	public List<Shoppingcarditem> getShoppingcarditems() {
		return this.shoppingcarditems;
	}

	public void setShoppingcarditems(List<Shoppingcarditem> shoppingcarditems) {
		this.shoppingcarditems = shoppingcarditems;
	}

	public Shoppingcarditem addShoppingcarditem(Shoppingcarditem shoppingcarditem) {
		getShoppingcarditems().add(shoppingcarditem);
		shoppingcarditem.setCoffee(this);

		return shoppingcarditem;
	}

	public Shoppingcarditem removeShoppingcarditem(Shoppingcarditem shoppingcarditem) {
		getShoppingcarditems().remove(shoppingcarditem);
		shoppingcarditem.setCoffee(null);

		return shoppingcarditem;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}