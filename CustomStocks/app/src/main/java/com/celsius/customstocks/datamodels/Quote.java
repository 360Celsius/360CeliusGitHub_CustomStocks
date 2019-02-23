package com.celsius.customstocks.datamodels;

import com.celsius.customstocks.BR;
import com.celsius.customstocks.application.CustomStockApplication;
import com.celsius.customstocks.utils.Utils;

import javax.inject.Inject;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class Quote extends BaseObservable {

    private String symbol;
    private String companyName;
    private String primaryExchange;
    private String sector;
    private String calculationPrice;
    private String open;
    private String openTime;
    private String close;
    private String closeTime;
    private String high;
    private String low;
    private String latestPrice;
    private String latestSource;
    private String latestTime;
    private String latestUpdate;
    private String latestVolume;
    private String iexRealtimePrice;
    private String iexRealtimeSize;
    private String iexLastUpdated;
    private String delayedPrice;
    private String delayedPriceTime;
    private String extendedPrice;
    private String extendedChange;
    private String extendedChangePercent;
    private String extendedPriceTime;
    private String previousClose;
    private String change;
    private String changePercent;
    private String iexMarketPercent;
    private String iexVolume;
    private String avgTotalVolume;
    private String iexBidPrice;
    private String iexBidSize;
    private String iexAskPrice;
    private String iexAskSize;
    private String marketCap;
    private String peRatio;
    private String week52High;
    private String week52Low;
    private String ytdChange;
    private String id;

    @Inject
    Utils utils;

    public Quote() {
        CustomStockApplication.getMyComponent().inject(this);
    }

    @Bindable
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
        notifyPropertyChanged(BR.companyName);
    }

    @Bindable
    public String getPrimaryExchange() {
        return primaryExchange;
    }

    public void setPrimaryExchange(String primaryExchange) {
        this.primaryExchange = primaryExchange;
        notifyPropertyChanged(BR.primaryExchange);
    }

    @Bindable
    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
        notifyPropertyChanged(BR.sector);
    }

    @Bindable
    public String getCalculationPrice() {
        return calculationPrice;
    }

    public void setCalculationPrice(String calculationPrice) {
        this.calculationPrice = calculationPrice;
        notifyPropertyChanged(BR.calculationPrice);
    }

    @Bindable
    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
        notifyPropertyChanged(BR.open);
    }

    @Bindable
    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
        notifyPropertyChanged(BR.openTime);
    }

    @Bindable
    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
        notifyPropertyChanged(BR.close);
    }

    @Bindable
    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
        notifyPropertyChanged(BR.closeTime);
    }

    @Bindable
    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
        notifyPropertyChanged(BR.high);
    }

    @Bindable
    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
        notifyPropertyChanged(BR.low);
    }

    @Bindable
    public String getLatestPrice() {
        return latestPrice;
    }

    public void setLatestPrice(String latestPrice) {
        this.latestPrice = latestPrice;
        notifyPropertyChanged(BR.latestPrice);
    }

    @Bindable
    public String getLatestSource() {
        return latestSource;
    }

    public void setLatestSource(String latestSource) {
        this.latestSource = latestSource;
        notifyPropertyChanged(BR.latestSource);
    }

    @Bindable
    public String getLatestTime() {
        return latestTime;
    }

    public void setLatestTime(String latestTime) {
        this.latestTime = latestTime;
        notifyPropertyChanged(BR.latestTime);
    }

    @Bindable
    public String getLatestUpdate() {
        return utils.milisecondsTGoDate(latestUpdate);
    }

    public void setLatestUpdate(String latestUpdate) {
        this.latestUpdate = latestUpdate;
        notifyPropertyChanged(BR.latestUpdate);
    }

    @Bindable
    public String getLatestVolume() {
        return latestVolume;
    }

    public void setLatestVolume(String latestVolume) {
        this.latestVolume = latestVolume;
        notifyPropertyChanged(BR.latestVolume);
    }

    @Bindable
    public String getIexRealtimePrice() {
        return iexRealtimePrice;
    }

    public void setIexRealtimePrice(String iexRealtimePrice) {
        this.iexRealtimePrice = iexRealtimePrice;
        notifyPropertyChanged(BR.iexRealtimePrice);
    }

    @Bindable
    public String getIexRealtimeSize() {
        return iexRealtimeSize;
    }

    public void setIexRealtimeSize(String iexRealtimeSize) {
        this.iexRealtimeSize = iexRealtimeSize;
        notifyPropertyChanged(BR.iexRealtimeSize);
    }

    @Bindable
    public String getIexLastUpdated() {
        return iexLastUpdated;
    }

    public void setIexLastUpdated(String iexLastUpdated) {
        this.iexLastUpdated = iexLastUpdated;
        notifyPropertyChanged(BR.iexLastUpdated);
    }

    @Bindable
    public String getDelayedPrice() {
        return delayedPrice;
    }

    public void setDelayedPrice(String delayedPrice) {
        this.delayedPrice = delayedPrice;
        notifyPropertyChanged(BR.delayedPrice);
    }

    @Bindable
    public String getDelayedPriceTime() {
        return delayedPriceTime;
    }

    public void setDelayedPriceTime(String delayedPriceTime) {
        this.delayedPriceTime = delayedPriceTime;
        notifyPropertyChanged(BR.companyName);
    }

    @Bindable
    public String getExtendedPrice() {
        return extendedPrice;
    }

    public void setExtendedPrice(String extendedPrice) {
        this.extendedPrice = extendedPrice;
        notifyPropertyChanged(BR.extendedPrice);
    }

    @Bindable
    public String getExtendedChange() {
        return extendedChange;
    }

    public void setExtendedChange(String extendedChange) {
        this.extendedChange = extendedChange;
        notifyPropertyChanged(BR.extendedChange);
    }

    @Bindable
    public String getExtendedChangePercent() {
        return extendedChangePercent;
    }

    public void setExtendedChangePercent(String extendedChangePercent) {
        this.extendedChangePercent = extendedChangePercent;
        notifyPropertyChanged(BR.extendedChangePercent);
    }

    @Bindable
    public String getExtendedPriceTime() {
        return extendedPriceTime;
    }

    public void setExtendedPriceTime(String extendedPriceTime) {
        this.extendedPriceTime = extendedPriceTime;
        notifyPropertyChanged(BR.extendedPriceTime);
    }

    @Bindable
    public String getPreviousClose() {
        return previousClose;
    }

    public void setPreviousClose(String previousClose) {
        this.previousClose = previousClose;
        notifyPropertyChanged(BR.previousClose);
    }

    @Bindable
    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
        notifyPropertyChanged(BR.change);
    }

    @Bindable
    public String getChangePercent() {
        return changePercent;
    }

    public void setChangePercent(String changePercent) {
        this.changePercent = changePercent;
        notifyPropertyChanged(BR.changePercent);
    }

    @Bindable
    public String getIexMarketPercent() {
        return iexMarketPercent;
    }

    public void setIexMarketPercent(String iexMarketPercent) {
        this.iexMarketPercent = iexMarketPercent;
        notifyPropertyChanged(BR.iexMarketPercent);
    }

    @Bindable
    public String getIexVolume() {
        return iexVolume;
    }

    public void setIexVolume(String iexVolume) {
        this.iexVolume = iexVolume;
        notifyPropertyChanged(BR.iexVolume);
    }

    @Bindable
    public String getAvgTotalVolume() {
        return avgTotalVolume;
    }

    public void setAvgTotalVolume(String avgTotalVolume) {
        this.avgTotalVolume = avgTotalVolume;
        notifyPropertyChanged(BR.avgTotalVolume);
    }

    @Bindable
    public String getIexBidPrice() {
        return iexBidPrice;
    }

    public void setIexBidPrice(String iexBidPrice) {
        this.iexBidPrice = iexBidPrice;
        notifyPropertyChanged(BR.iexBidPrice);
    }

    @Bindable
    public String getIexBidSize() {
        return iexBidSize;
    }

    public void setIexBidSize(String iexBidSize) {
        this.iexBidSize = iexBidSize;
        notifyPropertyChanged(BR.iexBidSize);
    }

    @Bindable
    public String getIexAskPrice() {
        return iexAskPrice;
    }

    public void setIexAskPrice(String iexAskPrice) {
        this.iexAskPrice = iexAskPrice;
        notifyPropertyChanged(BR.iexAskPrice);
    }

    @Bindable
    public String getIexAskSize() {
        return iexAskSize;
    }

    public void setIexAskSize(String iexAskSize) {
        this.iexAskSize = iexAskSize;
        notifyPropertyChanged(BR.iexAskSize);
    }

    @Bindable
    public String getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(String marketCap) {
        this.marketCap = marketCap;
        notifyPropertyChanged(BR.marketCap);
    }

    @Bindable
    public String getPeRatio() {
        return peRatio;
    }

    public void setPeRatio(String peRatio) {
        this.peRatio = peRatio;
        notifyPropertyChanged(BR.peRatio);
    }

    @Bindable
    public String getWeek52High() {
        return week52High;
    }

    public void setWeek52High(String week52High) {
        this.week52High = week52High;
        notifyPropertyChanged(BR.week52High);
    }

    @Bindable
    public String getWeek52Low() {
        return week52Low;
    }

    public void setWeek52Low(String week52Low) {
        this.week52Low = week52Low;
        notifyPropertyChanged(BR.week52Low);
    }

    @Bindable
    public String getYtdChange() {
        return ytdChange;
    }

    public void setYtdChange(String ytdChange) {
        this.ytdChange = ytdChange;
        notifyPropertyChanged(BR.ytdChange);
    }
}
