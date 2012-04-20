package com.goo.client.table;

import java.util.List;

import com.goo.client.common.MyProduct;
import com.google.gwt.user.client.ui.FlexTable;


public class MyTable extends FlexTable {
	ProductsDataSource input;

	public MyTable(ProductsDataSource input) {
		super();
		setCellPadding(1);
		setCellSpacing(0);
		setWidth("100%");
		setInput(input);
		addStyleName("simple_grid_test");
	}

	public void setInput(ProductsDataSource input) {
		for (int i = this.getRowCount(); i > 0; i--) {
			this.removeRow(0);
		}
		if (input == null) {
			return;
		}

		int row = 0;
		List<String> headers = input.getTableHeader();
		if (headers != null) {
			int i = 0;
			for (String string : headers) {
				this.setText(row, i, string);
				i++;
			}
			row++;
		}
		// Make the table header look nicer
		this.getRowFormatter().addStyleName(0, "tableHeader");

		List<MyProduct>rows = input.getProducts();
		int i = 1;
		for (MyProduct p : rows) {
			this.setText(i, 0, Integer.toString(p.getId()));
			this.setText(i, 1, p.getName());
			this.setText(i, 2, Integer.toString(p.getPrice()));
			i++;
		}
		this.input = input;
	}
}