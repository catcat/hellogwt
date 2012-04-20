package com.goo.server;

import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.goo.client.GooService;
import com.goo.client.common.MyProduct;
import com.goo.client.common.MyProductModelData;
import com.goo.rawdata.MyGenerator;

public class GooServiceImpl extends RemoteServiceServlet implements GooService {
    // Implementation of sample interface method
    public String getMessage(String msg) {
        return "Client said: \"" + msg + "\"<br>Server answered: \"Hi!\"" + Math.random();
    }

	@Override
	public List<MyProduct> getMyProducts() {
		//todo
		return MyGenerator.generateProducts();
	}
	
	@Override
    public List<MyProductModelData> getMyProductModels() {
		/*
		try {
			Thread.sleep(1200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		*/
		return MyGenerator.generateProductModelData();
	}
	/*
	public MyProduct getProduct(String id) {
		return null;
	}*/
}