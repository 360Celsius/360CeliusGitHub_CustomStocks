package com.celsius.customstocks.services;

import android.app.IntentService;
import android.content.Intent;

import com.celsius.customstocks.application.CustomStockApplication;
import com.celsius.customstocks.datamodels.Market;
import com.celsius.customstocks.datamodels.Symbol;
import com.celsius.customstocks.dbhelper.DBHelper;
import com.celsius.customstocks.network.NetworkHTTPRequests;
import com.celsius.customstocks.parsers.JsonParser;
import com.celsius.customstocks.utils.ReciverServiceConsts;

import java.util.ArrayList;

import javax.inject.Inject;

import androidx.annotation.Nullable;

import static com.celsius.customstocks.utils.ReciverServiceConsts.GET_QOUTES_DATA;


public class PullMarketsDataFromIEXService extends IntentService {

    @Inject NetworkHTTPRequests networkHTTPRequests;


    @Inject DBHelper helper;

    @Inject JsonParser jsonParser = null;

    public PullMarketsDataFromIEXService() {
        super("PullMarketsDataFromIEXService");
    }

    public PullMarketsDataFromIEXService(String name) {
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

            case ReciverServiceConsts.GET_MARKERTS_DATA:

                ArrayList<Market> marketssList = jsonParser.getMarketsParsed(networkHTTPRequests.getMarketsFromIEX());

                helper.bulkInsertMarketsToMarketsDataTable(marketssList);

                //TODO
                broadcastIntent.setAction(GET_QOUTES_DATA);
                broadcastIntent.putExtra(ReciverServiceConsts.DATA_TYPE_KEY, ReciverServiceConsts.RELOAD_MARKETS_FRAGMNET);
                sendBroadcast(broadcastIntent);

                break;
        }
    }
}
