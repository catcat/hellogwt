package com.goo.client.common;

import java.io.Serializable;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BaseModelData;

public class MyProductModelData extends BaseModelData {
	
	private static final long serialVersionUID = -111808511501771772L;
	public MyProductModelData() {
		
	}
	
	public MyProductModelData(int id, String name, int price){
		set("id", id);
		set("name", name);
		set("price", price);
	}
	
	public int getId() {
		return (Integer)get("id");
	}
	public String getName() {
		return get("name");
	}
	public int getPrice() {
		return (Integer)get("price");
	}
}
