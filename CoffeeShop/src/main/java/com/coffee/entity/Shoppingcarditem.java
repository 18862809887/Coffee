package com.coffee.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the shoppingcarditem database table.
 * 
 */
@Entity
@Table(name="shoppingcarditem")
@NamedQuery(name="Shoppingcarditem.findAll", query="SELECT s FROM Shoppingcarditem s")
public class Shoppingcarditem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="carditem_id")
	private int carditemId;

	//bi-directional many-to-one association to Coffee
	@ManyToOne
	@JoinColumn(name="coffeeid")
	private Coffee coffee;

	//bi-directional many-to-one association to Shoppingcard
	@ManyToOne
	@JoinColumn(name="cardid")
	private Shoppingcard shoppingcard;

	//bi-directional many-to-one association to Specification
	@ManyToOne
	@JoinColumn(name="specid")
	private Specification specification;

	public Shoppingcarditem() {
	}

	public int getCarditemId() {
		return this.carditemId;
	}

	public void setCarditemId(int carditemId) {
		this.carditemId = carditemId;
	}

	public Coffee getCoffee() {
		return this.coffee;
	}

	public void setCoffee(Coffee coffee) {
		this.coffee = coffee;
	}

	public Shoppingcard getShoppingcard() {
		return this.shoppingcard;
	}

	public void setShoppingcard(Shoppingcard shoppingcard) {
		this.shoppingcard = shoppingcard;
	}

	public Specification getSpecification() {
		return this.specification;
	}

	public void setSpecification(Specification specification) {
		this.specification = specification;
	}

}