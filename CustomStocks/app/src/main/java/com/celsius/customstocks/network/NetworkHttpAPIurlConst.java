package com.celsius.customstocks.network;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class NetworkHttpAPIurlConst {

    private static String BASIC_API_URL = "https://api.iextrading.com/1.0";

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

    public String getVoluemeByVenueBySymbolURL(String symbol){
        return BASIC_API_URL+"/stock/"+symbol+"/volume-by-venue";
    }
    public String getEarningBySymbolURL(String symbol){
        return BASIC_API_URL+"/stock/"+symbol+"/earnings";
    }

    public String getFinancialsBySymbolURL(String symbol){
        return BASIC_API_URL+"/stock/"+symbol+"/financials";
    }

    public String getPriceBySymbolYRL(String symbol){
        return BASIC_API_URL+"/stock/"+symbol+"/quote";
    }

    public String getSymbolChartRL(String symbol){
        return BASIC_API_URL+"/stock/"+symbol+"/chart";
    }

}
