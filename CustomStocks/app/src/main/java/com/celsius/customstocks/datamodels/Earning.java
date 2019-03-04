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
    private String epsSurpriseDollar;
    private String epsReportDate;
    private String fiscalPeriod;
    private String fiscalEndDate;
    private String yearAgo;
    private String yearAgoChangePercent;
    private String estimatedChangePercent;
    private String symbolId;

    private String id;

    private boolean isToShowDateHeader = false;

    @Inject
    Utils utils;

    public Earning() {
        CustomStockApplication.getMyComponent().inject(this);
    }

    @Bindable
    public boolean getIsToShowDateHeader(){
        return isToShowDateHeader;
    }

    public void setIsToShowDateHeader(boolean isToShowDateHeader){
        this.isToShowDateHeader = isToShowDateHeader;
        notifyPropertyChanged(BR.isToShowDateHeader);
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
    public String getEpsSurpriseDollar() {
        return epsSurpriseDollar;
    }

    public void setEpsSurpriseDollar(String epsSurpriseDollar) {
        this.epsSurpriseDollar = epsSurpriseDollar;
        notifyPropertyChanged(BR.epsSurpriseDollar);
    }

    @Bindable
    public String getEpsReportDate() {
        return epsReportDate;
    }

    public void setEpsReportDate(String epsReportDate) {
        this.epsReportDate = epsReportDate;
        notifyPropertyChanged(BR.epsReportDate);
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

    public String getFormatedDate(){
        String formatedDate = null;
        String month = epsReportDate.substring(0,epsReportDate.length()-3).split("-")[1];
        String year = epsReportDate.substring(0,epsReportDate.length()-3).split("-")[0];

        switch (month){
            case "01":
                formatedDate = "January "+year;
                break;
            case "02":
                formatedDate = "February "+year;
                break;
            case "03":
                formatedDate = "March "+year;
                break;
            case "04":
                formatedDate = "April "+year;
                break;
            case "05":
                formatedDate = "May "+year;
                break;
            case "06":
                formatedDate = "June "+year;
                break;
            case "07":
                formatedDate = "July "+year;
                break;
            case "08":
                formatedDate = "August "+year;
                break;
            case "09":
                formatedDate = "September "+year;
                break;
            case "10":
                formatedDate = "October "+year;
                break;
            case "11":
                formatedDate = "November "+year;
                break;
            case "12":
                formatedDate = "December "+year;
                break;

            default:
                formatedDate = month + "/" +year;
        }
        return formatedDate;
    }

    public boolean isActualEspDown(){
        if (actualEPS.contains("-"))
            return true;
        else
            return false;
    }

}
