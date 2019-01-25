package com.celsius.customstocks.utils;

public class Utils {
    private static Utils _instance;

    public static Utils getInstance()
    {
        if (_instance == null)
        {
            _instance = new Utils();
        }
        return _instance;
    }

    public Utils() {

    }


    public String convertShortTypeToLongType(String shortType){
        switch (shortType){
            case "ad":
                return "ADR";
            case "ce":
                return "Closed end fund";
            case "si":
                return "Secondary Issue";
            case "lp":
                return "Limited Partnerships";
            case "cs":
                return "Common Stock";
            case "et":
                return "ETF";
            case "re":
                return "REIT";
            default:
                return "N/A";
        }
    }
}
