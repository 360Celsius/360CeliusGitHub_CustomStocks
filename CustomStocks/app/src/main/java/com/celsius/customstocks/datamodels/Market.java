package com.celsius.customstocks.datamodels;

import com.celsius.customstocks.BR;

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
        return marketPercent;
    }

    public void setMarketPercent(String marketPercent) {
        this.marketPercent = marketPercent;
        notifyPropertyChanged(BR.marketPercent);

    }

    @Bindable
    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
        notifyPropertyChanged(BR.lastUpdated);

    }
}