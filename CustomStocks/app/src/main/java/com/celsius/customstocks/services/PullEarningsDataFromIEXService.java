package com.celsius.customstocks.services;

import android.app.IntentService;
import android.content.Intent;

import com.celsius.customstocks.application.CustomStockApplication;
import com.celsius.customstocks.datamodels.Earning;
import com.celsius.customstocks.datamodels.Symbol;
import com.celsius.customstocks.dbhelper.DBHelper;
import com.celsius.customstocks.network.NetworkHTTPRequests;
import com.celsius.customstocks.parsers.JsonParser;
import com.celsius.customstocks.utils.ReciverServiceConsts;

import java.util.ArrayList;

import javax.inject.Inject;

import androidx.annotation.Nullable;

import static com.celsius.customstocks.utils.ReciverServiceConsts.GET_QOUTES_DATA;


public class PullEarningsDataFromIEXService extends IntentService {

    @Inject NetworkHTTPRequests networkHTTPRequests;

    @Inject DBHelper helper;

    @Inject JsonParser jsonParser = null;

    public PullEarningsDataFromIEXService() {
        super("PullEarningsDataFromIEXService");
    }

    public PullEarningsDataFromIEXService(String name) {
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

            case ReciverServiceConsts.GET_EARNINGS_DATA:
                ArrayList<Symbol> selectedSymbolList = helper.getAllSelectedSymbols();
                ArrayList<Earning>  listOfEarningFromSelectedQuotes = new ArrayList<>();

                for(int i=0;i<selectedSymbolList.size();i++) {
                    ArrayList<Earning>  listOfEarningsFromSelectedQuotesTemp = new ArrayList<>();
                    listOfEarningsFromSelectedQuotesTemp = jsonParser.getEarningParsed(networkHTTPRequests.getEarning(selectedSymbolList.get(i).getSymbol()) , selectedSymbolList.get(i).getName());

                    for(int j=0;j<listOfEarningsFromSelectedQuotesTemp.size();j++){
                        listOfEarningFromSelectedQuotes.add(listOfEarningsFromSelectedQuotesTemp.get(j));
                    }
                }

                helper.bulkInsertEarningsToEarningsDataTable(listOfEarningFromSelectedQuotes);

                broadcastIntent.setAction(GET_QOUTES_DATA);
                broadcastIntent.putExtra(ReciverServiceConsts.DATA_TYPE_KEY, ReciverServiceConsts.RELOAD_EARNINGS_FRAGMNET);
                sendBroadcast(broadcastIntent);

                break;
        }
    }
}
