package com.goo.client;

import com.goo.client.common.MyProduct;
import com.goo.client.common.MyProductModelData;
import com.goo.client.table.MyTable;
import com.goo.client.table.MyTableCallback;
import com.goo.client.table.ProductsDataSource;
import com.goo.rawdata.MyGenerator;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Window;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.datepicker.client.DatePicker;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.menu.ColorMenu;
import com.extjs.gxt.ui.client.widget.table.Table;
import com.extjs.gxt.ui.client.widget.table.TableColumnModel;
import com.extjs.gxt.ui.client.widget.table.TableColumn;
import com.extjs.gxt.ui.client.widget.treegrid.EditorTreeGrid;
import com.extjs.gxt.ui.client.data.BaseListLoader;
import com.extjs.gxt.ui.client.data.DataProxy;
import com.extjs.gxt.ui.client.data.DataReader;
import com.extjs.gxt.ui.client.data.MemoryProxy;
import com.extjs.gxt.ui.client.data.ModelData;
import com.extjs.gxt.ui.client.data.RpcProxy;
import com.extjs.gxt.ui.client.store.TreeStore;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.TimeField;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.grid.EditorGrid;
import com.extjs.gxt.ui.client.store.ListStore;
import java.util.Collections;
import com.extjs.gxt.ui.client.widget.layout.TableLayout;
import com.extjs.gxt.ui.client.widget.Text;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.widget.button.ToggleButton;
import com.extjs.gxt.ui.client.widget.Slider;
import com.extjs.gxt.ui.client.widget.ProgressBar;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class Goo implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		final Button buttonA = new Button("ButtonA");

		final Image img = new Image();

		final Label label = new Label();
		final MyTable myTable = new MyTable(null);
		buttonA.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				buttonA.setHeight("120");
			}
		});

		// Assume that the host HTML has elements defined whose
		// IDs are "slot1", "slot2". In a real app, you probably would not want
		// to hard-code IDs. Instead, you could, for example, search for all
		// elements with a particular CSS class and replace them with widgets.
		//
		RootPanel rootPanel = RootPanel.get("slot1");
		RootPanel.get("slot1").add(img);
		RootPanel.get().add(label);

		Platinum w = new Platinum();
		RootPanel.get("slot3").add(w);

		RpcProxy rpcProxy = new RpcProxy() {
			@Override
			protected void load(Object loadConfig, AsyncCallback callback) {
				// gooService.App.getInstance().getMyProductModels(new
				// MyExtCallback(listStore));
				// service.getPosts((PagingLoadConfig) loadConfig, callback);
				GooService.App.getInstance().getMyProductModels(callback);
			}
		};

		List<MyProductModelData> stub = new ArrayList<MyProductModelData>();
		stub.add(new MyProductModelData(3, "Vova", 222));
		stub.add(new MyProductModelData(33, "Sasha", 232));
		stub.add(new MyProductModelData(35, "Pasha", 1122));

		MemoryProxy memProxy = new MemoryProxy(stub);

		DataProxy proxy = rpcProxy;

		// BasePagingLoader.load(0, 10);
		final BaseListLoader loader = new BaseListLoader(proxy);
		loader.setRemoteSort(false);
		loader.load();

		ListStore<MyProductModelData> listStore = new ListStore<MyProductModelData>(
				loader);
		// final ListStore<MyProductModelData> listStore = new
		// ListStore<MyProductModelData>();

		List<ColumnConfig> columns = new ArrayList<ColumnConfig>();
		ColumnConfig idColumn = new ColumnConfig("id", "Id", 32);
		ColumnConfig nameColumn = new ColumnConfig("name", "Name", 142);
		nameColumn.setAlignment(HorizontalAlignment.CENTER);
		ColumnConfig priceColumn = new ColumnConfig("price", "Price", 80);
		priceColumn.setRenderer(new GridCellRenderer() {

			@Override
			public Object render(ModelData model, String property,
					ColumnData config, int rowIndex, int colIndex,
					ListStore store,
					com.extjs.gxt.ui.client.widget.grid.Grid grid) {
				MyProductModelData md = (MyProductModelData) model;

				int p = md.getPrice();

				return "<span style=\"color:" + (p < 11000 ? "blue" : "green")
						+ "\"> $ " + p + " </span>";
			}

		});

		columns.add(idColumn);
		columns.add(nameColumn);
		columns.add(priceColumn);
		// listStore.add(MyGenerator.generateProductModelData());
		final com.extjs.gxt.ui.client.widget.grid.Grid<MyProductModelData> gridExt = new com.extjs.gxt.ui.client.widget.grid.Grid<MyProductModelData>(
				listStore, new ColumnModel(columns));

		rootPanel.add(gridExt);
		gridExt.setSize("256px", "512px");
		rootPanel.setWidgetPosition(gridExt, 0, 211);

		gridExt.setBorders(true);

		rootPanel.add(myTable);

		final ListBox comboBox = new ListBox();
		rootPanel.add(comboBox);
		comboBox.addItem("red");
		comboBox.addItem("green");
		comboBox.addItem("blue");
		final TextBox txtbxHellogwt = new TextBox();
		rootPanel.add(txtbxHellogwt);
		txtbxHellogwt.setText("HelloGWT");

		Hyperlink hprlnkNewHyperlink = new Hyperlink("New hyperlink", false,
				"newHistoryToken");
		rootPanel.add(hprlnkNewHyperlink);
		final Button button = new Button("Click me");
		rootPanel.add(button);

		Button btnGoOut = new Button("Reload table");
		rootPanel.add(btnGoOut);
		btnGoOut.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				GooService.App.getInstance().getMyProducts(
						new MyTableCallback(myTable));
				loader.load();

				// gooService.App.getInstance().getMyProductModels(new
				// MyExtCallback(listStore));
			}
		});
		btnGoOut.setSize("67px", "22px");

		Grid gridNative = new Grid(5, 5);
		rootPanel.add(gridNative);
		gridNative.setText(3, 2, "ololo");
		gridNative.setText(1, 4, "ololo1");
		gridNative.addStyleName("simple_grid_test");

		button.addClickHandler(new ClickHandler() {
			final String none = "There is nothing to watch";

			public void onClick(ClickEvent event) {
				GWT.log("click!");
				if (label.getText().equals(none)) {
					GooService.App.getInstance().getMessage("Hello, World!",
							new MyAsyncCallback(label));
					String color = comboBox.getItemText(comboBox
							.getSelectedIndex());
					txtbxHellogwt.setText("Hello Ajax " + color);
					label.getElement().getStyle()
							.setProperty("border", "3px dotted " + color);

				} else {
					label.setText(none);
				}
			}
		});

	}

	private static class MyAsyncCallback implements AsyncCallback<String> {
		private Label label;

		public MyAsyncCallback(Label label) {
			this.label = label;
		}

		@Override
		public void onSuccess(String result) {
			label.getElement().setInnerHTML(result);
		}

		@Override
		public void onFailure(Throwable throwable) {
			label.setText("Failed to receive answer from server!");
		}
	}
}

class MyExtCallback implements AsyncCallback<List<MyProductModelData>> {

	ListStore<MyProductModelData> listStore;

	public MyExtCallback(ListStore<MyProductModelData> listStore) {
		this.listStore = listStore;
	}

	@Override
	public void onFailure(Throwable caught) {
		Window.alert(caught.getMessage());
	}

	@Override
	public void onSuccess(List<MyProductModelData> ms) {
		listStore.removeAll();
		listStore.add(ms);
	}

}
