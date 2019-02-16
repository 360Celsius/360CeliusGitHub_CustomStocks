package com.celsius.customstocks.services;

import android.app.IntentService;
import android.content.Intent;

import com.celsius.customstocks.application.CustomStockApplication;
import com.celsius.customstocks.datamodels.News;
import com.celsius.customstocks.datamodels.Symbol;
import com.celsius.customstocks.dbhelper.DBHelper;
import com.celsius.customstocks.network.NetworkHTTPRequests;
import com.celsius.customstocks.parsers.JsonParser;
import com.celsius.customstocks.utils.ReciverServiceConsts;

import java.util.ArrayList;

import javax.inject.Inject;

import androidx.annotation.Nullable;


public class PullNewsDataFromIEXService extends IntentService {

    @Inject NetworkHTTPRequests networkHTTPRequests;

    @Inject DBHelper helper;

    @Inject JsonParser jsonParser = null;

    public PullNewsDataFromIEXService() {
        super("PullNewsDataFromIEXService");
    }

    public PullNewsDataFromIEXService(String name) {
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

            case ReciverServiceConsts.GET_NEWS_DATA:
                ArrayList<Symbol> selectedSymbolList = helper.getAllSelectedSymbols();
                ArrayList<News>  listOfNewsFromSelectedQuotes = new ArrayList<>();

                for(int i=0;i<selectedSymbolList.size();i++) {
                    ArrayList<News>  listOfNewsFromSelectedQuotesTemp = new ArrayList<>();
                    listOfNewsFromSelectedQuotesTemp = jsonParser.getNewsParsed(networkHTTPRequests.getNews(selectedSymbolList.get(i).getSymbol()));

                    for(int j=0;j<listOfNewsFromSelectedQuotesTemp.size();j++){
                        listOfNewsFromSelectedQuotes.add(listOfNewsFromSelectedQuotesTemp.get(j));
                    }
                }

                helper.bulkInsertNewsToNewsDataTable(listOfNewsFromSelectedQuotes);

                break;
        }
    }
}
