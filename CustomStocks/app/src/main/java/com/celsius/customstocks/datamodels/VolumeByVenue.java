package com.celsius.customstocks.datamodels;

import com.celsius.customstocks.BR;
import com.celsius.customstocks.application.CustomStockApplication;
import com.celsius.customstocks.utils.Utils;

import javax.inject.Inject;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class VolumeByVenue extends BaseObservable {

    private String symbol;
    private String volume;
    private String venue;
    private String venueName;
    private String marketPercent;
    private String avgMarketPercent;
    private String date;
    private String id;


    @Inject
    Utils utils;

    public VolumeByVenue() {
        CustomStockApplication.getMyComponent().inject(this);
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
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
        notifyPropertyChanged(BR.id);
    }

    @Bindable
    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
        notifyPropertyChanged(BR.volume);
    }

    @Bindable
    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
        notifyPropertyChanged(BR.venue);
    }

    @Bindable
    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
        notifyPropertyChanged(BR.venueName);
    }

    @Bindable
    public String getMarketPercent() {
        return marketPercent;
    }

    public void setMarketPercent(String marketPercent) {
        this.marketPercent = marketPercent;
        notifyPropertyChanged(BR.marketPercent);
    }

    @Bindable
    public String getAvgMarketPercent() {
        return avgMarketPercent;
    }

    public void setAvgMarketPercent(String avgMarketPercent) {
        this.avgMarketPercent = avgMarketPercent;
        notifyPropertyChanged(BR.avgMarketPercent);
    }

    @Bindable
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
        notifyPropertyChanged(BR.date);
    }

    public String getDecoratedDate(){
        if(date==null || date.isEmpty() || date.equals("null")){
            return "N/A";
        }else{
            return getDate();
        }
    }
}
