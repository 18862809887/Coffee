package com.coffee.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the orderr database table.
 * 
 */
@Entity
@Table(name="orderr")
@NamedQuery(name="Orderr.findAll", query="SELECT o FROM Orderr o")
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler", "fieldHandler"})
public class Orderr implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="order_id")
	private int orderId;

	@Column(name="order_time")
	private Timestamp orderTime;

	private double price;

	private String status;

	//bi-directional many-to-one association to Orderitem
	@JsonIgnore
	@OneToMany(mappedBy="orderr")
	private List<Orderitem> orderitems;

	//bi-directional many-to-one association to Address

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="addressid")
	private Address address;

	//bi-directional many-to-one association to Userinfo
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="userid")
	private Userinfo userinfo;

	public Orderr() {
	}

	public int getOrderId() {
		return this.orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Timestamp getOrderTime() {
		return this.orderTime;
	}

	public void setOrderTime(Timestamp orderTime) {
		this.orderTime = orderTime;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Orderitem> getOrderitems() {
		return this.orderitems;
	}

	public void setOrderitems(List<Orderitem> orderitems) {
		this.orderitems = orderitems;
	}

	public Orderitem addOrderitem(Orderitem orderitem) {
		getOrderitems().add(orderitem);
		orderitem.setOrderr(this);

		return orderitem;
	}

	public Orderitem removeOrderitem(Orderitem orderitem) {
		getOrderitems().remove(orderitem);
		orderitem.setOrderr(null);

		return orderitem;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Userinfo getUserinfo() {
		return this.userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

}