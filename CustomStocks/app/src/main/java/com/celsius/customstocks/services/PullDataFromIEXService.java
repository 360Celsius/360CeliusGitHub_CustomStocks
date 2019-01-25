package com.celsius.customstocks.services;

import android.app.IntentService;
import android.content.Intent;

import com.celsius.customstocks.BaseActivity;
import com.celsius.customstocks.datamodels.Symbol;
import com.celsius.customstocks.dbhelper.DBHelper;
import com.celsius.customstocks.network.NetworkHTTPRequests;
import com.celsius.customstocks.parsers.JsonParser;
import com.celsius.customstocks.utils.ReciverServiceConsts;

import java.util.ArrayList;

import androidx.annotation.Nullable;


public class PullDataFromIEXService extends IntentService {

    private static NetworkHTTPRequests networkHTTPRequests = null;
    public static final String GET_QOUTES_DATA = "GET_DATA";
    private DBHelper helper = null;
    private JsonParser jsonParser = null;

    private ArrayList<Symbol> allSymbolsParsed = null;

    public PullDataFromIEXService() {
        super("PullDataFromIEXService");
    }


    public PullDataFromIEXService(String name) {
        super(name);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        networkHTTPRequests = NetworkHTTPRequests.getInstance();
        helper = BaseActivity.helper;
        jsonParser = JsonParser.getInstance();
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        switch (intent.getStringExtra(ReciverServiceConsts.DATA_TYPE_KEY)) {
            case ReciverServiceConsts.GET_ALL_SYMBOLS:
                ArrayList<Symbol> symbolsList = jsonParser.getAllSymbolsParsed(networkHTTPRequests.getSymbolsFromIEX());

                Intent broadcastIntent = new Intent();
                broadcastIntent.setAction(GET_QOUTES_DATA);
                broadcastIntent.putExtra(ReciverServiceConsts.DATA_TYPE_KEY, ReciverServiceConsts.LOAD_MAIN_ACTIVITY);
                sendBroadcast(broadcastIntent);

                helper.bulkInsertAllSymbolsToSymbolsDataTable(symbolsList);
                break;
        }
    }
}
