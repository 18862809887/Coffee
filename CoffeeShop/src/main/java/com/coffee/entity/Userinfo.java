package com.coffee.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


/**
 * The persistent class for the userinfo database table.
 * 
 */
@Entity
@Table(name="userinfo")
@NamedQuery(name="Userinfo.findAll", query="SELECT u FROM Userinfo u")
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler", "fieldHandler"})
public class Userinfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private int userId;

	private String email;

	private String password;

	private String privilege;

	private String telephone;

	@Column(name="user_name")
	private String userName;
	
	private String salt;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pictureId")
    private Picture picture;
	//bi-directional many-to-one association to Address
	@JsonIgnore
	@OneToMany(mappedBy="userinfo")
	private List<Address> addresses;

	//bi-directional many-to-one association to Orderr
	@JsonIgnore
	@OneToMany(mappedBy="userinfo")
	private List<Orderr> orderrs;

	//bi-directional many-to-one association to Shoppingcard
	@JsonIgnore
	@OneToMany(mappedBy="userinfo")
	private List<Shoppingcard> shoppingcards;

	public Userinfo() {
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrivilege() {
		return this.privilege;
	}

	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Address addAddress(Address address) {
		getAddresses().add(address);
		address.setUserinfo(this);

		return address;
	}

	public Address removeAddress(Address address) {
		getAddresses().remove(address);
		address.setUserinfo(null);

		return address;
	}

	public List<Orderr> getOrderrs() {
		return this.orderrs;
	}

	public void setOrderrs(List<Orderr> orderrs) {
		this.orderrs = orderrs;
	}

	public Orderr addOrderr(Orderr orderr) {
		getOrderrs().add(orderr);
		orderr.setUserinfo(this);

		return orderr;
	}

	public Orderr removeOrderr(Orderr orderr) {
		getOrderrs().remove(orderr);
		orderr.setUserinfo(null);

		return orderr;
	}

	public List<Shoppingcard> getShoppingcards() {
		return this.shoppingcards;
	}

	public void setShoppingcards(List<Shoppingcard> shoppingcards) {
		this.shoppingcards = shoppingcards;
	}

	public Shoppingcard addShoppingcard(Shoppingcard shoppingcard) {
		getShoppingcards().add(shoppingcard);
		shoppingcard.setUserinfo(this);

		return shoppingcard;
	}

	public Shoppingcard removeShoppingcard(Shoppingcard shoppingcard) {
		getShoppingcards().remove(shoppingcard);
		shoppingcard.setUserinfo(null);

		return shoppingcard;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Picture getPicture() {
		return picture;
	}

	public void setPicture(Picture picture) {
		this.picture = picture;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}