package com.celsius.customstocks.datamodels;

import com.celsius.customstocks.BR;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class QuoteNameOnActionBar extends BaseObservable {

    private String quoteName;

    @Bindable
    public String getQuoteName() {
        return quoteName;
    }

    public void setQuoteName(String quoteName) {
        this.quoteName = quoteName;
        notifyPropertyChanged(BR.quoteName);
    }
}
