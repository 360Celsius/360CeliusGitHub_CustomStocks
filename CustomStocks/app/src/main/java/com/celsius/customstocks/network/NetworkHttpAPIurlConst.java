package com.celsius.customstocks.network;

public class NetworkHttpAPIurlConst {

    private static String BASIC_API_URL = "https://api.iextrading.com/1.0";

    //"https://api.iextrading.com/1.0/ref-data/symbols";
    //https://api.iextrading.com/1.0/stock/aapl/logo
    //https://api.iextrading.com/1.0/stock/aapl/price
    ///https://api.iextrading.com/1.0/stock/aapl/news


    private static NetworkHttpAPIurlConst _instance;


    private NetworkHttpAPIurlConst()
    {

    }

    public static NetworkHttpAPIurlConst getInstance()
    {
        if (_instance == null)
        {
            _instance = new NetworkHttpAPIurlConst();
        }
        return _instance;
    }

    public String getLogoBySymbolURL(String symbol){
        return BASIC_API_URL+"/stock/"+symbol+"/logo";
    }
    public String getSymbolsListURL(){
        return BASIC_API_URL+"/ref-data/symbols";
    }

    public String getNewsBySymbolURL(String symbol){
        return BASIC_API_URL+"/stock/"+symbol+"/news";
    }

    public String getPriceBySymbolYRL(String symbol){
        return BASIC_API_URL+"/stock/"+symbol+"/price";
    }

}
