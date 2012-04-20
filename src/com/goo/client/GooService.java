package com.goo.client;

import java.util.List;

import com.goo.client.common.MyProduct;
import com.goo.client.common.MyProductModelData;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("GooService")
public interface GooService extends RemoteService {
    // Sample interface method of remote interface
    String getMessage(String msg);
    List<MyProduct> getMyProducts();
    List<MyProductModelData> getMyProductModels();
    /**
     * Utility/Convenience class.
     * Use gooService.App.getInstance() to access static instance of gooServiceAsync
     */
    public static class App {
        private static GooServiceAsync ourInstance = GWT.create(GooService.class);

        public static synchronized GooServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
