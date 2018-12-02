package com.coffee.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the address database table.
 * 
 */
@Entity
@Table(name="address")
@NamedQuery(name="Address.findAll", query="SELECT a FROM Address a")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="address_id")
	private int addressId;

	@Column(name="address_name")
	private String addressName;

	//bi-directional many-to-one association to Userinfo
	@ManyToOne
	@JoinColumn(name="userid")
	private Userinfo userinfo;

	//bi-directional many-to-one association to Orderr
	@OneToMany(mappedBy="address")
	private List<Orderr> orderrs;

	public Address() {
	}

	public int getAddressId() {
		return this.addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getAddressName() {
		return this.addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	public Userinfo getUserinfo() {
		return this.userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	public List<Orderr> getOrderrs() {
		return this.orderrs;
	}

	public void setOrderrs(List<Orderr> orderrs) {
		this.orderrs = orderrs;
	}

	public Orderr addOrderr(Orderr orderr) {
		getOrderrs().add(orderr);
		orderr.setAddress(this);

		return orderr;
	}

	public Orderr removeOrderr(Orderr orderr) {
		getOrderrs().remove(orderr);
		orderr.setAddress(null);

		return orderr;
	}

}