package com.goo.client.table;

import java.util.List;

import com.goo.client.common.MyProduct;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class MyTableCallback implements AsyncCallback<List<MyProduct>>{

	private MyTable table;

	public MyTableCallback(MyTable table) {
		this.table = table;
	}

	@Override
	public void onFailure(Throwable caught) {
		Window.alert(caught.getMessage());
	}

	@Override
	public void onSuccess(List<MyProduct> products) {
		ProductsDataSource datasource = new ProductsDataSource(products);
		table.setInput(datasource);
		for (MyProduct p : products) {
			GWT.log(p.getName());
		}		
	}

}
