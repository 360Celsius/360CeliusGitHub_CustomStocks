package com.celsius.customstocks.recyclerviewadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.celsius.customstocks.BR;
import com.celsius.customstocks.R;
import com.celsius.customstocks.datamodels.Market;
import com.celsius.customstocks.datamodels.Symbol;
import com.celsius.customstocks.iterfaces.ActionCallbackInterface;
import com.celsius.customstocks.utils.Utils;
import com.celsius.customstocks.viewholders.AllSymbolsViewHolder;
import com.celsius.customstocks.viewholders.MarketsViewHolder;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public class MarketsRecyclerViewAdapter extends RecyclerView.Adapter<MarketsViewHolder> {

    private ArrayList<Market> marketsList = new ArrayList<>();
    private Context context;
    private Utils utils;


    public MarketsRecyclerViewAdapter(ArrayList<Market> marketsList, Utils utils, Context context) {
        this.marketsList = marketsList;
        this.context = context;
        this.utils = utils;

    }
    @NonNull
    @Override
    public MarketsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.markets_row_item, viewGroup, false);
        return new MarketsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MarketsViewHolder marketsViewHolder, int position) {

        ViewDataBinding viewDataBinding = marketsViewHolder.getViewDataBinding();
        viewDataBinding.setVariable(BR.market, marketsList.get(position));
    }

    @Override
    public int getItemCount() {
        return marketsList.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
