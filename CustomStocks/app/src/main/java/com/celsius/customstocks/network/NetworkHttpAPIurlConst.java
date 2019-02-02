package com.celsius.customstocks.network;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class NetworkHttpAPIurlConst {

    private static String BASIC_API_URL = "https://api.iextrading.com/1.0";

    //"https://api.iextrading.com/1.0/ref-data/symbols";
    //https://api.iextrading.com/1.0/stock/aapl/logo
    //https://api.iextrading.com/1.0/stock/aapl/price
    ///https://api.iextrading.com/1.0/stock/aapl/news

    @Inject
    public NetworkHttpAPIurlConst() {}

    public String getLogoBySymbolURL(String symbol){
        return BASIC_API_URL+"/stock/"+symbol+"/logo";
    }
    public String getSymbolsListURL(){
        return BASIC_API_URL+"/ref-data/symbols";
    }

    public String getMarketsListURL(){
        return BASIC_API_URL+"/market";
    }

    public String getNewsBySymbolURL(String symbol){
        return BASIC_API_URL+"/stock/"+symbol+"/news";
    }

    public String getPriceBySymbolYRL(String symbol){
        return BASIC_API_URL+"/stock/"+symbol+"/price";
    }

}
