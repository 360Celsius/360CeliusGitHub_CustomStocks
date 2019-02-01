package com.celsius.customstocks.datamodels;

import com.celsius.customstocks.BR;
import com.celsius.customstocks.application.CustomStockApplication;
import com.celsius.customstocks.utils.Utils;

import javax.inject.Inject;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class Symbol extends BaseObservable {

    private String symbol;
    private String name;
    private String date;
    private String isEnabled;
    private String type;
    private String iexId;
    private String isInPortfolio;

    @Inject
    Utils utils;

    public Symbol() {
        CustomStockApplication.getMyComponent().inject(this);
    }

    @Bindable
    public String getIsInPortfolio() {
        return isInPortfolio;
    }

    public void setIsInPortfolio(String isInPortfolio) {
        this.isInPortfolio = isInPortfolio;
        notifyPropertyChanged(BR.isInPortfolio);
    }

    @Bindable
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
        notifyPropertyChanged(BR.symbol);
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
        notifyPropertyChanged(BR.date);
    }

    @Bindable
    public String getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(String isEnabled) {
        this.isEnabled = isEnabled;
        notifyPropertyChanged(BR.isEnabled);
    }

    @Bindable
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = utils.convertShortTypeToLongType(type);
        notifyPropertyChanged(BR.type);
    }

    @Bindable
    public String getIexId() {
        return iexId;
    }

    public void setIexId(String iexId) {
        this.iexId = iexId;
        notifyPropertyChanged(BR.iexId);
    }
}
