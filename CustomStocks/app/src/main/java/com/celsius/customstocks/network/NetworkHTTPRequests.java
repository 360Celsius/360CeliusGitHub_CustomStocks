package com.celsius.customstocks.network;

import com.celsius.customstocks.application.CustomStockApplication;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class NetworkHTTPRequests {

    @Inject
    NetworkHTTPConnection networkHTTPConnection;

    @Inject
    NetworkHttpAPIurlConst networkHttpAPIurlConst;

    @Inject
    public NetworkHTTPRequests() {
        CustomStockApplication.getMyComponent().inject(this);
    }


   public String getSymbolsFromIEX(){
        String responce = null;
        String url = networkHttpAPIurlConst.getSymbolsListURL();
        responce = networkHTTPConnection.getHttp(url);
        return responce;
   }

    public String getMarketsFromIEX(){
        String responce = null;
        String url = networkHttpAPIurlConst.getMarketsListURL();
        responce = networkHTTPConnection.getHttp(url);
        return responce;
    }

    public String getQuote(String stock){
        String responce = null;
        String url = networkHttpAPIurlConst.getPriceBySymbolYRL(stock);
        responce = networkHTTPConnection.getHttp(url);
        return responce;
    }

    public String getNews(String stock){
        String responce = null;
        String url = networkHttpAPIurlConst.getNewsBySymbolURL(stock);
        responce = networkHTTPConnection.getHttp(url);
        return responce;
    }

    public String getEarning(String stock){
        String responce = null;
        String url = networkHttpAPIurlConst.getEarningBySymbolURL(stock);
        responce = networkHTTPConnection.getHttp(url);
        return responce;
    }
}
