package com.celsius.customstocks.datamodels;

import com.celsius.customstocks.BR;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class FragmentNameOnActionBar extends BaseObservable {

    private String fragmentName;

    @Bindable
    public String getFragmentName() {
        return fragmentName;
    }

    public void setFragmentName(String fragmentName) {
        this.fragmentName = fragmentName;
        notifyPropertyChanged(BR.fragmentName);
    }
}
