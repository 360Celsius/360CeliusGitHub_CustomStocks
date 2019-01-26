package com.celsius.customstocks.viewholders;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public class AllSymbolsViewHolder extends RecyclerView.ViewHolder {

    private ViewDataBinding mViewDataBinding;

    public AllSymbolsViewHolder(@NonNull  ViewDataBinding viewDataBinding) {
        super(viewDataBinding.getRoot());
        mViewDataBinding = viewDataBinding;
        mViewDataBinding.executePendingBindings();
    }

    public ViewDataBinding getViewDataBinding() {
        return mViewDataBinding;
    }

}
