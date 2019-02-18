package com.celsius.customstocks.datamodels;

import com.celsius.customstocks.BR;
import com.celsius.customstocks.application.CustomStockApplication;
import com.celsius.customstocks.utils.Utils;

import javax.inject.Inject;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class Market extends BaseObservable {

    private String mic;
    private String tapeId;
    private String venueName;
    private String volume;
    private String tapeA;
    private String tapeB;
    private String tapeC;
    private String marketPercent;
    private String lastUpdated;
    private String id;


    @Inject
    Utils utils;

    public Market() {
        CustomStockApplication.getMyComponent().inject(this);
    }

    public int getTapePercentage (String volume, String tape){
        double percentage = 0;
        double vol = Double.valueOf(volume);
        double tap = Double.valueOf(tape);

        percentage = (tap/vol)*100;

        if(percentage>0 && percentage  <=10)
            return 10;
        else if(percentage>10 && percentage  <=20)
            return 20;
        else if(percentage>20 && percentage  <=30)
            return 30;
        else if(percentage>30 && percentage  <=40)
            return 40;
        else if(percentage>40 && percentage  <=50)
            return 50;
        else if(percentage>60 && percentage  <=70)
            return 60;
        else if(percentage>70 && percentage  <=80)
            return 70;
        else if(percentage>80 && percentage  <=90)
            return 80;
        else if(percentage>90 && percentage  <100)
            return 90;
        else
            return 100;

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
    public String getMic() {
        return mic;
    }

    public void setMic(String mic) {
        this.mic = mic;
        notifyPropertyChanged(BR.mic);

    }

    @Bindable
    public String getTapeId() {
        return tapeId;
    }

    public void setTapeId(String tapeId) {
        this.tapeId = tapeId;
        notifyPropertyChanged(BR.tapeId);

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
    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
        notifyPropertyChanged(BR.volume);

    }

    @Bindable
    public String getTapeA() {
        return tapeA;
    }

    public void setTapeA(String tapeA) {
        this.tapeA = tapeA;
        notifyPropertyChanged(BR.tapeA);

    }

    @Bindable
    public String getTapeB() {
        return tapeB;
    }

    public void setTapeB(String tapeB) {
        this.tapeB = tapeB;
        notifyPropertyChanged(BR.tapeB);

    }

    @Bindable
    public String getTapeC() {
        return tapeC;
    }

    public void setTapeC(String tapeC) {
        this.tapeC = tapeC;
        notifyPropertyChanged(BR.tapeC);

    }

    @Bindable
    public String getMarketPercent() {
        if(marketPercent.contains("%"))
            return marketPercent;
        else
            return marketPercent+" %";
    }

    public void setMarketPercent(String marketPercent) {
        this.marketPercent = marketPercent;
        notifyPropertyChanged(BR.marketPercent);

    }

    @Bindable
    public String getLastUpdated() {
        return utils.milisecondsTGoDate(lastUpdated);
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
        notifyPropertyChanged(BR.lastUpdated);

    }
}
