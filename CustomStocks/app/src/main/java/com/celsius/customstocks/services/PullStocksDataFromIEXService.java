package com.celsius.customstocks.services;

import android.app.IntentService;
import android.content.Intent;

import com.celsius.customstocks.application.CustomStockApplication;
import com.celsius.customstocks.datamodels.Quote;
import com.celsius.customstocks.datamodels.Symbol;
import com.celsius.customstocks.dbhelper.DBHelper;
import com.celsius.customstocks.network.NetworkHTTPRequests;
import com.celsius.customstocks.parsers.JsonParser;
import com.celsius.customstocks.utils.ReciverServiceConsts;

import java.util.ArrayList;

import javax.inject.Inject;

import androidx.annotation.Nullable;

import static com.celsius.customstocks.utils.ReciverServiceConsts.GET_QOUTES_DATA;


public class PullStocksDataFromIEXService extends IntentService {

    @Inject NetworkHTTPRequests networkHTTPRequests;

    @Inject DBHelper helper;

    @Inject JsonParser jsonParser = null;

    public PullStocksDataFromIEXService() {
        super("PullStocksDataFromIEXService");
    }

    public PullStocksDataFromIEXService(String name) {
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

                ArrayList<Symbol> selectedSymbolList = helper.getAllSelectedSymbols();
                ArrayList<Quote>  listOfSelectedQuotes = new ArrayList<>();

                for(int i=0;i<selectedSymbolList.size();i++) {
                    listOfSelectedQuotes.add(jsonParser.getQuotesParsed(networkHTTPRequests.getQuote(selectedSymbolList.get(i).getSymbol())));
                }
                helper.bulkInserSelectedQuotestoQuotesDataTable(listOfSelectedQuotes);

                broadcastIntent.setAction(GET_QOUTES_DATA);
                broadcastIntent.putExtra(ReciverServiceConsts.DATA_TYPE_KEY, ReciverServiceConsts.RELOAD_QUOTES_FRAGMNET);
                sendBroadcast(broadcastIntent);
                break;
        }
    }
}
