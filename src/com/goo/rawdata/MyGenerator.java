package com.goo.rawdata;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.extjs.gxt.ui.client.store.ListStore;
import com.goo.client.common.MyProduct;
import com.goo.client.common.MyProductModelData;


public class MyGenerator {
	
	public static List<MyProduct> generateProducts() {
		List<MyProduct> result = new ArrayList<MyProduct>();
		
		int n = inRange(10,15);
		
		for(int i =0; i<n; i++) {
			MyProduct p = new MyProduct();
			p.setId(i);
			p.setPrice(inRange(1000,20000));
			p.setName(randString());
			result.add(p);
		}	
		
		return result;
	}
	
	public static List<MyProductModelData> generateProductModelData() {
		List<MyProduct> products = generateProducts();
		List<MyProductModelData> result = new ArrayList<MyProductModelData>();
		for(MyProduct p: products) {
			MyProductModelData m = new MyProductModelData(p.getId(), p.getName(), p.getPrice());
			result.add(m);
		}		
		return result;
	}
	
	
	public static ListStore<MyProductModelData> createListStore() {
		ListStore<MyProductModelData> listStore = new ListStore<MyProductModelData>();  
		listStore.add(generateProductModelData());
		return listStore;
	} 
	
	
	public static int inRange(int from, int to) {
		int n = from + (int)Math.floor((to-from)* Math.random());
		return Math.abs(n);
	} 
	
	public static String randString() {
		return UUID.randomUUID().toString().substring(0,7).toLowerCase();
	}

}
