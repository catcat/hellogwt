package com.goo.client.table;
import java.util.ArrayList;
import java.util.List;

import com.goo.client.common.MyProduct;

public class ProductsDataSource {
	private final List<MyProduct> rows;
	private List<String> header;

	public ProductsDataSource(List<MyProduct> rows) {
		header = new ArrayList<String>();
		header.add("Id");
		header.add("Name");
		header.add("Price");
		this.rows = rows;
	}

	public List<MyProduct> getProducts() {
		return rows;
	}

	public List<String> getTableHeader() {
		return header;
	}
}
