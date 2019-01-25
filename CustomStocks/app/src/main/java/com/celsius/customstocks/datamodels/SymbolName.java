package com.celsius.customstocks.datamodels;

import com.celsius.customstocks.BR;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class SymbolName extends BaseObservable {

    private String symbolName;

    public SymbolName(){

    }

    public SymbolName(String symbolName) {
        this.symbolName = symbolName;
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
