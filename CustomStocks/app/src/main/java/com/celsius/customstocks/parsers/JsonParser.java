package com.celsius.customstocks.parsers;

import com.celsius.customstocks.datamodels.Market;
import com.celsius.customstocks.datamodels.Symbol;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class JsonParser {

    @Inject
    public JsonParser() {}

    public ArrayList<Symbol> getAllSymbolsParsed(String getSymbolsFromIEXResponce) {
        JSONArray reader = null;
        ArrayList<Symbol> symbolArrayList = new ArrayList<>();

        try {
            reader = new JSONArray(getSymbolsFromIEXResponce);
            for (int i = 0; i < reader.length(); i++) {
                JSONObject jsonObject = reader.getJSONObject(i);
                Symbol symbol = new Symbol();

                symbol.setDate(String.valueOf(jsonObject.get("date")));
                symbol.setIexId(String.valueOf(jsonObject.get("iexId")));
                symbol.setIsEnabled(String.valueOf(jsonObject.get("isEnabled")));
                symbol.setName(String.valueOf(jsonObject.get("name")));
                symbol.setSymbol(String.valueOf(jsonObject.get("symbol")));
                symbol.setType(String.valueOf(jsonObject.get("type")));

                symbolArrayList.add(symbol);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return symbolArrayList;
    }

    public ArrayList<Market> getMarketsParsed(String getMarketsFromIEXResponce) {
        JSONArray reader = null;
        ArrayList<Market> marketsArrayList = new ArrayList<>();

        try {
            reader = new JSONArray(getMarketsFromIEXResponce);
            for (int i = 0; i < reader.length(); i++) {
                JSONObject jsonObject = reader.getJSONObject(i);
                Market market = new Market();

                market.setMic(String.valueOf(jsonObject.get("mic")));
                market.setTapeId(String.valueOf(jsonObject.get("tapeId")));
                market.setVolume(String.valueOf(jsonObject.get("venueName")));
                market.setVolume(String.valueOf(jsonObject.get("volume")));
                market.setTapeA(String.valueOf(jsonObject.get("tapeA")));
                market.setTapeB(String.valueOf(jsonObject.get("tapeB")));
                market.setTapeC(String.valueOf(jsonObject.get("tapeC")));
                market.setMarketPercent(String.valueOf(jsonObject.get("marketPercent")));
                market.setLastUpdated(String.valueOf(jsonObject.get("lastUpdated")));


                marketsArrayList.add(market);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return marketsArrayList;
    }

}
