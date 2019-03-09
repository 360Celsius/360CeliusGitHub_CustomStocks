package com.celsius.customstocks.recyclerviewadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.celsius.customstocks.BR;
import com.celsius.customstocks.R;
import com.celsius.customstocks.datamodels.Earning;
import com.celsius.customstocks.datamodels.Financial;
import com.celsius.customstocks.utils.Utils;
import com.celsius.customstocks.viewholders.EarningViewHolder;
import com.celsius.customstocks.viewholders.FinancialsViewHolder;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public class FinancialsRecyclerViewAdapter extends RecyclerView.Adapter<FinancialsViewHolder> {

    private ArrayList<Financial> financialsList = new ArrayList<>();
    private Context context;
    private Utils utils;

    public FinancialsRecyclerViewAdapter(ArrayList<Financial> financialsList, Utils utils, Context context) {
        this.financialsList = financialsList;
        this.context = context;
        this.utils = utils;
        setHasStableIds(true);
    }

    @NonNull
    @Override
    public FinancialsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.row_item_financials, viewGroup, false);
        return new FinancialsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FinancialsViewHolder financialsViewHolder, int position) {
        ViewDataBinding viewDataBinding = financialsViewHolder.getViewDataBinding();
        viewDataBinding.setVariable(BR.financials, financialsList.get(position));
    }


    @Override
    public int getItemCount() {
        return financialsList.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public long getItemId(int position) {
        try {
            return Long.valueOf(financialsList.get(position).getId());
        }catch (Exception e){
            return position;
        }
    }
}
