package com.goo.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;

public class Platinum extends Composite implements HasText {

	private static PlatinumUiBinder uiBinder = GWT
			.create(PlatinumUiBinder.class);

	interface PlatinumUiBinder extends UiBinder<Widget, Platinum> {
	}

	public Platinum() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	Button button;

	@UiField
	ListBox listBox;
	
	public Platinum(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
		button.setText(firstName);
	}

	@UiHandler("button")
	void onClick(ClickEvent e) {
		String rand = Integer.toString((int)(Math.random()*10000.));
		Window.alert("Oh hey " + rand);
		listBox.addItem("item"+rand);
	}

	public void setText(String text) {
		button.setText(text);
	}

	public String getText() {
		return button.getText();
	}
	
	 @UiHandler("submit")
	  void handleClick(ClickEvent e) {
	    Window.alert("Submitted:"+listBox.getItemText(listBox.getSelectedIndex()));	   
	  }

}
