package com.coffee.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * The persistent class for the orderitem database table.
 * 
 */
@Entity
@Table(name="orderitem")
@NamedQuery(name="Orderitem.findAll", query="SELECT o FROM Orderitem o")
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler", "fieldHandler"})
public class Orderitem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="item_id")
	private int itemId;

	//bi-directional many-to-one association to Coffee
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="coffeeid")
	private Coffee coffee;

	//bi-directional many-to-one association to Orderr
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="orderid")
	private Orderr orderr;

	//bi-directional many-to-one association to Specification
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="specid")
	private Specification specification;

	public Orderitem() {
	}

	public int getItemId() {
		return this.itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public Coffee getCoffee() {
		return this.coffee;
	}

	public void setCoffee(Coffee coffee) {
		this.coffee = coffee;
	}

	public Orderr getOrderr() {
		return this.orderr;
	}

	public void setOrderr(Orderr orderr) {
		this.orderr = orderr;
	}

	public Specification getSpecification() {
		return this.specification;
	}

	public void setSpecification(Specification specification) {
		this.specification = specification;
	}

}