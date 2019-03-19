package com.coffee.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


/**
 * The persistent class for the shoppingcard database table.
 * 
 */
@Entity
@Table(name="shoppingcard")
@NamedQuery(name="Shoppingcard.findAll", query="SELECT s FROM Shoppingcard s")
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler", "fieldHandler"})
public class Shoppingcard implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="card_id")
	private int cardId;

	//bi-directional many-to-one association to Userinfo
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="userid")
	private Userinfo userinfo;

	//bi-directional many-to-one association to Shoppingcarditem
	@JsonIgnore
	@OneToMany(mappedBy="shoppingcard")
	private List<Shoppingcarditem> shoppingcarditems;

	public Shoppingcard() {
	}

	public int getCardId() {
		return this.cardId;
	}

	public void setCardId(int cardId) {
		this.cardId = cardId;
	}

	public Userinfo getUserinfo() {
		return this.userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	public List<Shoppingcarditem> getShoppingcarditems() {
		return this.shoppingcarditems;
	}

	public void setShoppingcarditems(List<Shoppingcarditem> shoppingcarditems) {
		this.shoppingcarditems = shoppingcarditems;
	}

	public Shoppingcarditem addShoppingcarditem(Shoppingcarditem shoppingcarditem) {
		getShoppingcarditems().add(shoppingcarditem);
		shoppingcarditem.setShoppingcard(this);

		return shoppingcarditem;
	}

	public Shoppingcarditem removeShoppingcarditem(Shoppingcarditem shoppingcarditem) {
		getShoppingcarditems().remove(shoppingcarditem);
		shoppingcarditem.setShoppingcard(null);

		return shoppingcarditem;
	}

}