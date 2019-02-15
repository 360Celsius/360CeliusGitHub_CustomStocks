package com.celsius.customstocks.services;

import android.app.IntentService;
import android.content.Intent;

import com.celsius.customstocks.application.CustomStockApplication;
import com.celsius.customstocks.datamodels.Market;
import com.celsius.customstocks.dbhelper.DBHelper;
import com.celsius.customstocks.network.NetworkHTTPRequests;
import com.celsius.customstocks.parsers.JsonParser;
import com.celsius.customstocks.utils.ReciverServiceConsts;

import java.util.ArrayList;

import javax.inject.Inject;

import androidx.annotation.Nullable;

import static com.celsius.customstocks.utils.ReciverServiceConsts.GET_QOUTES_DATA;


public class PullSrocksDataFromIEXService extends IntentService {

    @Inject NetworkHTTPRequests networkHTTPRequests;

    @Inject DBHelper helper;

    @Inject JsonParser jsonParser = null;

    public PullSrocksDataFromIEXService() {
        super("PullSrocksDataFromIEXService");
    }

    public PullSrocksDataFromIEXService(String name) {
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

            case ReciverServiceConsts.GET_STOCKS_DATA:

                helper.getAllSelectedSymbols();

                break;
        }
    }
}
