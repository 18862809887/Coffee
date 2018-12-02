package com.coffee.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the specification database table.
 * 
 */
@Entity
@Table(name="specification")
@NamedQuery(name="Specification.findAll", query="SELECT s FROM Specification s")
public class Specification implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="spec_id")
	private int specId;

	private String milk;

	private String sugars;

	private String temperature;

	private String volume;

	//bi-directional many-to-one association to Orderitem
	@OneToMany(mappedBy="specification")
	private List<Orderitem> orderitems;

	//bi-directional many-to-one association to Shoppingcarditem
	@OneToMany(mappedBy="specification")
	private List<Shoppingcarditem> shoppingcarditems;

	public Specification() {
	}

	public int getSpecId() {
		return this.specId;
	}

	public void setSpecId(int specId) {
		this.specId = specId;
	}

	public String getMilk() {
		return this.milk;
	}

	public void setMilk(String milk) {
		this.milk = milk;
	}

	public String getSugars() {
		return this.sugars;
	}

	public void setSugars(String sugars) {
		this.sugars = sugars;
	}

	public String getTemperature() {
		return this.temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getVolume() {
		return this.volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public List<Orderitem> getOrderitems() {
		return this.orderitems;
	}

	public void setOrderitems(List<Orderitem> orderitems) {
		this.orderitems = orderitems;
	}

	public Orderitem addOrderitem(Orderitem orderitem) {
		getOrderitems().add(orderitem);
		orderitem.setSpecification(this);

		return orderitem;
	}

	public Orderitem removeOrderitem(Orderitem orderitem) {
		getOrderitems().remove(orderitem);
		orderitem.setSpecification(null);

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
		shoppingcarditem.setSpecification(this);

		return shoppingcarditem;
	}

	public Shoppingcarditem removeShoppingcarditem(Shoppingcarditem shoppingcarditem) {
		getShoppingcarditems().remove(shoppingcarditem);
		shoppingcarditem.setSpecification(null);

		return shoppingcarditem;
	}

}