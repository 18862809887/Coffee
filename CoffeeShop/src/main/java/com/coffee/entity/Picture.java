package com.coffee.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


/**
 * The persistent class for the picture database table.
 * 
 */
@Entity
@Table(name="picture")
@NamedQuery(name="Picture.findAll", query="SELECT p FROM Picture p")
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler", "fieldHandler"})
public class Picture implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="picture_id")
	private int pictureId;

	@Column(name="picture_name")
	private String pictureName;

	@Column(name="picture_path")
	private String picturePath;

	private String split;

	//bi-directional many-to-one association to Coffee
	@JsonIgnore
	@OneToMany(mappedBy="picture")
	private List<Coffee> coffees;

	public Picture() {
	}

	public int getPictureId() {
		return this.pictureId;
	}

	public void setPictureId(int pictureId) {
		this.pictureId = pictureId;
	}

	public String getPictureName() {
		return this.pictureName;
	}

	public void setPictureName(String pictureName) {
		this.pictureName = pictureName;
	}

	public String getPicturePath() {
		return this.picturePath;
	}

	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}

	public String getSplit() {
		return this.split;
	}

	public void setSplit(String split) {
		this.split = split;
	}

	public List<Coffee> getCoffees() {
		return this.coffees;
	}

	public void setCoffees(List<Coffee> coffees) {
		this.coffees = coffees;
	}

	public Coffee addCoffee(Coffee coffee) {
		getCoffees().add(coffee);
		coffee.setPicture(this);

		return coffee;
	}

	public Coffee removeCoffee(Coffee coffee) {
		getCoffees().remove(coffee);
		coffee.setPicture(null);

		return coffee;
	}

}