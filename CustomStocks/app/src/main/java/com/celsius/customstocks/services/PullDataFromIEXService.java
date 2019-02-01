package com.celsius.customstocks.services;

import android.app.IntentService;
import android.content.Intent;

import com.celsius.customstocks.application.CustomStockApplication;
import com.celsius.customstocks.datamodels.Symbol;
import com.celsius.customstocks.dbhelper.DBHelper;
import com.celsius.customstocks.network.NetworkHTTPRequests;
import com.celsius.customstocks.parsers.JsonParser;
import com.celsius.customstocks.utils.ReciverServiceConsts;

import java.util.ArrayList;

import javax.inject.Inject;

import androidx.annotation.Nullable;


public class PullDataFromIEXService extends IntentService {

    @Inject NetworkHTTPRequests networkHTTPRequests;
    public static final String GET_QOUTES_DATA = "GET_DATA";


    @Inject DBHelper helper;

    @Inject JsonParser jsonParser = null;

    public PullDataFromIEXService() {
        super("PullDataFromIEXService");
    }

    public PullDataFromIEXService(String name) {
        super(name);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        CustomStockApplication.getMyComponent().inject(this);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        Intent broadcastIntent = new Intent();
        switch (intent.getStringExtra(ReciverServiceConsts.DATA_TYPE_KEY)) {
            case ReciverServiceConsts.GET_ALL_SYMBOLS:
                ArrayList<Symbol> symbolsList = jsonParser.getAllSymbolsParsed(networkHTTPRequests.getSymbolsFromIEX());


                broadcastIntent.setAction(GET_QOUTES_DATA);
                broadcastIntent.putExtra(ReciverServiceConsts.DATA_TYPE_KEY, ReciverServiceConsts.LOAD_MAIN_ACTIVITY);
                sendBroadcast(broadcastIntent);

                helper.bulkInsertAllSymbolsToSymbolsDataTable(symbolsList);

                broadcastIntent.setAction(GET_QOUTES_DATA);
                broadcastIntent.putExtra(ReciverServiceConsts.DATA_TYPE_KEY, ReciverServiceConsts.RELOAD_SEARCH_FRAGMNET_ALL_SYMBOLS_ADDED);
                sendBroadcast(broadcastIntent);
                break;
        }
    }
}
