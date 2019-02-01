package com.celsius.customstocks.parsers;

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

}
