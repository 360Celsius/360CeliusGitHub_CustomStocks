package com.celsius.customstocks.datamodels;

import com.celsius.customstocks.BR;
import com.celsius.customstocks.application.CustomStockApplication;
import com.celsius.customstocks.utils.Utils;

import javax.inject.Inject;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class Earning extends BaseObservable {

    private String symbol;
    private String actualEPS;
    private String consensusEPS;
    private String estimatedEPS;
    private String announceTime;
    private String numberOfEstimates;
    private String ePSSurpriseDollar;
    private String ePSReportDate;
    private String fiscalPeriod;
    private String fiscalEndDate;
    private String yearAgo;
    private String yearAgoChangePercent;
    private String estimatedChangePercent;
    private String symbolId;

    private String id;

    @Inject
    Utils utils;

    public Earning() {
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
    public String getActualEPS() {
        return actualEPS;
    }

    public void setActualEPS(String actualEPS) {
        this.actualEPS = actualEPS;
        notifyPropertyChanged(BR.actualEPS);
    }

    @Bindable
    public String getConsensusEPS() {
        return consensusEPS;
    }

    public void setConsensusEPS(String consensusEPS) {
        this.consensusEPS = consensusEPS;
        notifyPropertyChanged(BR.consensusEPS);
    }

    @Bindable
    public String getEstimatedEPS() {
        return estimatedEPS;
    }

    public void setEstimatedEPS(String estimatedEPS) {
        this.estimatedEPS = estimatedEPS;
        notifyPropertyChanged(BR.estimatedEPS);
    }

    @Bindable
    public String getAnnounceTime() {
        return announceTime;
    }

    public void setAnnounceTime(String announceTime) {
        this.announceTime = announceTime;
        notifyPropertyChanged(BR.announceTime);
    }

    @Bindable
    public String getNumberOfEstimates() {
        return numberOfEstimates;
    }

    public void setNumberOfEstimates(String numberOfEstimates) {
        this.numberOfEstimates = numberOfEstimates;
        notifyPropertyChanged(BR.numberOfEstimates);
    }

    @Bindable
    public String getePSSurpriseDollar() {
        return ePSSurpriseDollar;
    }

    public void setePSSurpriseDollar(String ePSSurpriseDollar) {
        this.ePSSurpriseDollar = ePSSurpriseDollar;
        notifyPropertyChanged(BR.ePSSurpriseDollar);
    }

    @Bindable
    public String getePSReportDate() {
        return ePSReportDate;
    }

    public void setePSReportDate(String ePSReportDate) {
        this.ePSReportDate = ePSReportDate;
        notifyPropertyChanged(BR.ePSReportDate);
    }

    @Bindable
    public String getFiscalPeriod() {
        return fiscalPeriod;
    }

    public void setFiscalPeriod(String fiscalPeriod) {
        this.fiscalPeriod = fiscalPeriod;
        notifyPropertyChanged(BR.fiscalPeriod);
    }

    @Bindable
    public String getFiscalEndDate() {
        return fiscalEndDate;
    }

    public void setFiscalEndDate(String fiscalEndDate) {
        this.fiscalEndDate = fiscalEndDate;
        notifyPropertyChanged(BR.fiscalEndDate);
    }

    @Bindable
    public String getYearAgo() {
        return yearAgo;
    }

    public void setYearAgo(String yearAgo) {
        this.yearAgo = yearAgo;
        notifyPropertyChanged(BR.yearAgo);
    }

    @Bindable
    public String getYearAgoChangePercent() {
        return yearAgoChangePercent;
    }

    public void setYearAgoChangePercent(String yearAgoChangePercent) {
        this.yearAgoChangePercent = yearAgoChangePercent;
        notifyPropertyChanged(BR.yearAgoChangePercent);
    }

    @Bindable
    public String getEstimatedChangePercent() {
        return estimatedChangePercent;
    }

    public void setEstimatedChangePercent(String estimatedChangePercent) {
        this.estimatedChangePercent = estimatedChangePercent;
        notifyPropertyChanged(BR.estimatedChangePercent);
    }

    @Bindable
    public String getSymbolId() {
        return symbolId;
    }

    public void setSymbolId(String symbolId) {
        this.symbolId = symbolId;
        notifyPropertyChanged(BR.symbolId);
    }

    @Bindable
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
        notifyPropertyChanged(BR.id);
    }
}
