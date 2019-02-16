package com.celsius.customstocks.recyclerviewadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.celsius.customstocks.BR;
import com.celsius.customstocks.R;
import com.celsius.customstocks.datamodels.Market;
import com.celsius.customstocks.datamodels.Quote;
import com.celsius.customstocks.utils.Utils;
import com.celsius.customstocks.viewholders.MarketsViewHolder;
import com.celsius.customstocks.viewholders.QuotesViewHolder;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public class StocksRecyclerViewAdapter extends RecyclerView.Adapter<QuotesViewHolder> {

    private ArrayList<Quote> quoteList = new ArrayList<>();
    private Context context;
    private Utils utils;


    public StocksRecyclerViewAdapter(ArrayList<Quote> quoteList, Utils utils, Context context) {
        this.quoteList = quoteList;
        this.context = context;
        this.utils = utils;
        setHasStableIds(true);
    }
    @NonNull
    @Override
    public QuotesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.quote_row_item, viewGroup, false);
        return new QuotesViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull QuotesViewHolder marketsViewHolder, int position) {
        ViewDataBinding viewDataBinding = marketsViewHolder.getViewDataBinding();
        viewDataBinding.setVariable(BR.quote, quoteList.get(position));
    }


    @Override
    public int getItemCount() {
        return quoteList.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public long getItemId(int position) {
        try {
            return Long.valueOf(quoteList.get(position).getId());
        }catch (Exception e){
            return position;
        }
    }
}
