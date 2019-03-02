package com.celsius.customstocks.datamodels;

import com.celsius.customstocks.BR;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class DrawerState extends BaseObservable {

    private boolean isDrawerOpen = false;

    @Bindable
    public boolean getIsDrawerOpen() {
        return isDrawerOpen;
    }

    public void setIsDrawerOpen(boolean isDrawerOpen) {
        this.isDrawerOpen = isDrawerOpen;
        notifyPropertyChanged(BR.isDrawerOpen);
    }


}
