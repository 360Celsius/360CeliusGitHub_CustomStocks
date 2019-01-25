package com.celsius.customstocks.datamodels;

public class Symbol {

    private String symbol;
    private String name;
    private String date;
    private String isEnabled;
    private String type;
    private String iexId;
    private String isInPortfolio;

    public String getIsInPortfolio() {
        return isInPortfolio;
    }

    public void setIsInPortfolio(String isInPortfolio) {
        this.isInPortfolio = isInPortfolio;
    }


    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(String isEnabled) {
        this.isEnabled = isEnabled;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIexId() {
        return iexId;
    }

    public void setIexId(String iexId) {
        this.iexId = iexId;
    }
}
