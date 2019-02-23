package com.celsius.customstocks.bindingadapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;

public class SetTextColorBindingAdaptor {
    @BindingAdapter("android:textColor")
    public static void setTextColor(TextView textView, int color) {
        textView.setTextColor(color);
    }
}
