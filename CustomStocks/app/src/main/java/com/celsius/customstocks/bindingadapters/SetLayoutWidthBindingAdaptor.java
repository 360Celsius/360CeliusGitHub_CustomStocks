package com.celsius.customstocks.bindingadapters;

import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.BindingAdapter;

public class SetLayoutWidthBindingAdaptor {
    @BindingAdapter("android:layout_width")
    public static void setLayoutHeight(View view, float height) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = (int) height;
        view.setLayoutParams(layoutParams);
    }
}
