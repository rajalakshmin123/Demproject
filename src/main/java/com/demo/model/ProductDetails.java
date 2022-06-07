package com.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product",schema="nintriva")
public class ProductDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false)
	private int id;
	
	@Column(name="product_name")
	private String product_name;
	private int price;
	private String picture;
	private String description;
	private String retailerid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRetailerid() {
		return retailerid;
	}
	public void setRetailerid(String retailerid) {
		this.retailerid = retailerid;
	}
	@Override
	public String toString() {
		return "ProductDetails [id=" + id + ", product_name=" + product_name + ", price=" + price + ", picture="
				+ picture + ", description=" + description + ", retailerid=" + retailerid + "]";
	}
}
