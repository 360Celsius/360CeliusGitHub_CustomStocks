package com.celsius.customstocks.utils;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Utils {

    @Inject
    public Utils() {
    }

    public String convertShortTypeToLongType(String shortType){

        if(shortType.contains("ad") || shortType.contains("ADR")){
            return "ADR";
        }else if (shortType.contains("ce") || shortType.contains("Closed end fund")){
            return "Closed end fund";
        }else if (shortType.contains("si") || shortType.contains("Secondary Issue")){
            return "Secondary Issue";
        }else if (shortType.contains("lp") || shortType.contains("Limited Partnerships")){
            return "Limited Partnerships";
        }else if (shortType.contains("cs") || shortType.contains("Common Stock")){
            return "Common Stock";
        }else if (shortType.contains("et") || shortType.contains("ETF")){
            return "ETF";
        }else if (shortType.contains("re") || shortType.contains("REIT")){
            return "REIT";
        }else {
            return "N/A";
        }
    }
}
