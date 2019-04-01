package com.celsius.customstocks.datamodels;

import com.celsius.customstocks.BR;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class Chart extends BaseObservable {

    private String date;
    private String open;
    private String high;
    private String low;
    private String close;
    private String volume;
    private String unadjustedVolume;
    private String change;
    private String changePercent;
    private String vwap;
    private String label;
    private String changeOverTime;

    @Bindable
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
        notifyPropertyChanged(BR.date);
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
    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
        notifyPropertyChanged(BR.close);
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
    public String getUnadjustedVolume() {
        return unadjustedVolume;
    }

    public void setUnadjustedVolume(String unadjustedVolume) {
        this.unadjustedVolume = unadjustedVolume;
        notifyPropertyChanged(BR.unadjustedVolume);
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
    public String getVwap() {
        return vwap;
    }

    public void setVwap(String vwap) {
        this.vwap = vwap;
        notifyPropertyChanged(BR.vwap);
    }

    @Bindable
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
        notifyPropertyChanged(BR.isDrawerOpen);
    }

    @Bindable
    public String getChangeOverTime() {
        return changeOverTime;
    }

    public void setChangeOverTime(String changeOverTime) {
        this.changeOverTime = changeOverTime;
        notifyPropertyChanged(BR.changeOverTime);
    }
}
