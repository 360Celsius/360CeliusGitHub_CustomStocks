package com.celsius.customstocks.datamodels;

import com.celsius.customstocks.BR;
import com.celsius.customstocks.application.CustomStockApplication;
import com.celsius.customstocks.utils.Utils;

import javax.inject.Inject;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class Financial extends BaseObservable {

    private String reportDate;
    private String grossProfit;
    private String costOfRevenue;
    private String operatingRevenue;
    private String totalRevenue;
    private String operatingIncome;
    private String netIncome;
    private String researchAndDevelopment;
    private String operatingExpense;
    private String currentAssets;
    private String totalAssets;
    private String totalLiabilities;
    private String currentCash;
    private String currentDebt;
    private String totalCash;
    private String totalDebt;
    private String shareholderEquity;
    private String cashChange;
    private String cashFlow;
    private String operatingGainsLosses;

    private String id;

    private String symbol;
    private String symbolName;

    @Inject
    Utils utils;

    public Financial() {
        CustomStockApplication.getMyComponent().inject(this);
    }

    @Bindable
    public String getReportDate() {
        return reportDate;
    }

    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
        notifyPropertyChanged(BR.reportDate);
    }

    @Bindable
    public String getGrossProfit() {
        return grossProfit;
    }

    public void setGrossProfit(String grossProfit) {
        this.grossProfit = grossProfit;
        notifyPropertyChanged(BR.grossProfit);
    }

    @Bindable
    public String getCostOfRevenue() {
        return costOfRevenue;
    }

    public void setCostOfRevenue(String costOfRevenue) {
        this.costOfRevenue = costOfRevenue;
        notifyPropertyChanged(BR.costOfRevenue);
    }

    @Bindable
    public String getOperatingRevenue() {
        return operatingRevenue;
    }

    public void setOperatingRevenue(String operatingRevenue) {
        this.operatingRevenue = operatingRevenue;
        notifyPropertyChanged(BR.operatingRevenue);
    }

    @Bindable
    public String getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(String totalRevenue) {
        this.totalRevenue = totalRevenue;
        notifyPropertyChanged(BR.totalRevenue);
    }

    @Bindable
    public String getOperatingIncome() {
        return operatingIncome;
    }

    public void setOperatingIncome(String operatingIncome) {
        this.operatingIncome = operatingIncome;
        notifyPropertyChanged(BR.operatingIncome);
    }

    @Bindable
    public String getNetIncome() {
        return netIncome;
    }

    public void setNetIncome(String netIncome) {
        this.netIncome = netIncome;
        notifyPropertyChanged(BR.netIncome);
    }

    @Bindable
    public String getResearchAndDevelopment() {
        return researchAndDevelopment;
    }

    public void setResearchAndDevelopment(String researchAndDevelopment) {
        this.researchAndDevelopment = researchAndDevelopment;
        notifyPropertyChanged(BR.researchAndDevelopment);
    }

    @Bindable
    public String getOperatingExpense() {
        return operatingExpense;
    }

    public void setOperatingExpense(String operatingExpense) {
        this.operatingExpense = operatingExpense;
        notifyPropertyChanged(BR.operatingExpense);
    }

    @Bindable
    public String getCurrentAssets() {
        return currentAssets;
    }

    public void setCurrentAssets(String currentAssets) {
        this.currentAssets = currentAssets;
        notifyPropertyChanged(BR.currentAssets);
    }

    @Bindable
    public String getTotalAssets() {
        return totalAssets;
    }

    public void setTotalAssets(String totalAssets) {
        this.totalAssets = totalAssets;
        notifyPropertyChanged(BR.totalAssets);
    }

    @Bindable
    public String getTotalLiabilities() {
        return totalLiabilities;
    }

    public void setTotalLiabilities(String totalLiabilities) {
        this.totalLiabilities = totalLiabilities;
        notifyPropertyChanged(BR.totalLiabilities);
    }

    @Bindable
    public String getCurrentCash() {
        return currentCash;
    }

    public void setCurrentCash(String currentCash) {
        this.currentCash = currentCash;
        notifyPropertyChanged(BR.currentCash);
    }

    @Bindable
    public String getCurrentDebt() {
        return currentDebt;
    }

    public void setCurrentDebt(String currentDebt) {
        this.currentDebt = currentDebt;
        notifyPropertyChanged(BR.currentDebt);
    }

    @Bindable
    public String getTotalCash() {
        return totalCash;
    }

    public void setTotalCash(String totalCash) {
        this.totalCash = totalCash;
        notifyPropertyChanged(BR.totalCash);
    }

    @Bindable
    public String getTotalDebt() {
        return totalDebt;
    }

    public void setTotalDebt(String totalDebt) {
        this.totalDebt = totalDebt;
        notifyPropertyChanged(BR.totalDebt);
    }

    @Bindable
    public String getShareholderEquity() {
        return shareholderEquity;
    }

    public void setShareholderEquity(String shareholderEquity) {
        this.shareholderEquity = shareholderEquity;
        notifyPropertyChanged(BR.shareholderEquity);
    }

    @Bindable
    public String getCashChange() {
        return cashChange;
    }

    public void setCashChange(String cashChange) {
        this.cashChange = cashChange;
        notifyPropertyChanged(BR.cashChange);
    }

    @Bindable
    public String getCashFlow() {
        return cashFlow;
    }

    public void setCashFlow(String cashFlow) {
        this.cashFlow = cashFlow;
        notifyPropertyChanged(BR.cashFlow);
    }

    @Bindable
    public String getOperatingGainsLosses() {
        return operatingGainsLosses;
    }

    public void setOperatingGainsLosses(String operatingGainsLosses) {
        this.operatingGainsLosses = operatingGainsLosses;
        notifyPropertyChanged(BR.operatingGainsLosses);
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
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
        notifyPropertyChanged(BR.symbol);
    }

    @Bindable
    public String getSymbolName() {
        return symbolName;
    }

    public void setSymbolName(String symbolName) {
        this.symbolName = symbolName;
        notifyPropertyChanged(BR.symbolName);
    }
}
