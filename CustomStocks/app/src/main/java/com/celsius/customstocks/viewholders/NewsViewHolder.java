package com.celsius.customstocks.viewholders;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public class NewsViewHolder extends RecyclerView.ViewHolder{

    private ViewDataBinding mViewDataBinding;

    public NewsViewHolder(@NonNull ViewDataBinding viewDataBinding) {
        super(viewDataBinding.getRoot());
        mViewDataBinding = viewDataBinding;
        mViewDataBinding.executePendingBindings();
    }

    public ViewDataBinding getViewDataBinding() {
        return mViewDataBinding;
    }
}
