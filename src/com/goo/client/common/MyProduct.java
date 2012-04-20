package com.goo.client.common;

import java.io.Serializable;

public class MyProduct implements Serializable {

	private static final long serialVersionUID = -428808515501771772L;

	int id;
	String name;
	int price;

	
	public MyProduct() {

	}

	public MyProduct(int id, String name, int price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}	

}
