package com.coffee.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * The persistent class for the category database table.
 * 
 */
@Entity
@Table(name="category")
//@NamedQuery(name="Category.findAll", query="SELECT  FROM Category c")
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler", "fieldHandler"})
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="category_id")
	private int categoryId;

	@Column(name="category_name")
	private String categoryName;

	//bi-directional many-to-one association to Coffee
	@OneToMany(mappedBy="category")
	private List<Coffee> coffees;

	public Category() {
	}

	public int getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<Coffee> getCoffees() {
		return this.coffees;
	}

	public void setCoffees(List<Coffee> coffees) {
		this.coffees = coffees;
	}

	public Coffee addCoffee(Coffee coffee) {
		getCoffees().add(coffee);
		coffee.setCategory(this);
		return coffee;
	}

	public Coffee removeCoffee(Coffee coffee) {
		getCoffees().remove(coffee);
		coffee.setCategory(null);

		return coffee;
	}

}