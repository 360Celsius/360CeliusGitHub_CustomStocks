package com.celsius.customstocks.application;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.celsius.customstocks.contentobservers.DataBaseContentObserver;
import com.celsius.customstocks.dbhelper.DBHelper;
import com.celsius.customstocks.iterfaces.CustomStocksComponents;
import com.celsius.customstocks.iterfaces.DaggerCustomStocksComponents;
import com.celsius.customstocks.modules.ContextModule;
import com.celsius.customstocks.modules.DBContentObserverModule;
import com.celsius.customstocks.modules.DatabaseModule;

public class CustomStockApplication extends Application {

    private static CustomStocksComponents component;



    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("Test","CustomStockApplication been fired !!!");

        component = DaggerCustomStocksComponents.builder()
                .contextModule(new ContextModule(getApplicationContext()))
                .databaseModule(new DatabaseModule(new DBHelper(getApplicationContext())))
                .dBContentObserverModule(new DBContentObserverModule(new DataBaseContentObserver( new Handler(),getApplicationContext() )))
                .build();
    }

    public static CustomStocksComponents getMyComponent() {
        return component;
    }


}
