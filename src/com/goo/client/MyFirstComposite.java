package com.goo.client;

import com.extjs.gxt.ui.client.widget.Composite;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.Text;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.ListView;
import com.extjs.gxt.ui.client.store.ListStore;

public class MyFirstComposite extends Composite {

	public MyFirstComposite() {
		
		FormPanel frmpnlMyfirstform = new FormPanel();
		frmpnlMyfirstform.setHeading("MyFirstForm");
		frmpnlMyfirstform.setCollapsible(true);
		
		Text txtNewText = new Text("New Text");
		frmpnlMyfirstform.add(txtNewText, new FormData("100%"));
		
		Button btnNewButton = new Button("New Button");
		frmpnlMyfirstform.add(btnNewButton, new FormData("100%"));
		
		ListView listView = new ListView(new ListStore());

		frmpnlMyfirstform.add(listView, new FormData("100% -180"));
		initComponent(frmpnlMyfirstform);
	}

}
