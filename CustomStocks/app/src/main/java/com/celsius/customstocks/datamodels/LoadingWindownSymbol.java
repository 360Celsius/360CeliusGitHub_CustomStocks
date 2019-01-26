package com.celsius.customstocks.datamodels;

import com.celsius.customstocks.BR;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class LoadingWindownSymbol extends BaseObservable {

    private String symbolName;
    private boolean isToShowWindow = false;

    @Bindable
    public boolean getIsToShowWindow() {
        return isToShowWindow;
    }

    public void setIsToShowWindow(boolean isToShowWindow) {
        this.isToShowWindow = isToShowWindow;
        notifyPropertyChanged(BR.isToShowWindow);
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
