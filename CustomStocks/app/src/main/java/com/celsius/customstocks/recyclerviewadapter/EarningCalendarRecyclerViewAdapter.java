package com.celsius.customstocks.recyclerviewadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.celsius.customstocks.BR;
import com.celsius.customstocks.R;
import com.celsius.customstocks.datamodels.Earning;
import com.celsius.customstocks.datamodels.News;
import com.celsius.customstocks.utils.Utils;
import com.celsius.customstocks.viewholders.EarningViewHolder;
import com.celsius.customstocks.viewholders.NewsViewHolder;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public class EarningCalendarRecyclerViewAdapter extends RecyclerView.Adapter<EarningViewHolder> {

    private ArrayList<Earning> earningList = new ArrayList<>();
    private Context context;
    private Utils utils;

    public EarningCalendarRecyclerViewAdapter(ArrayList<Earning> earningList, Utils utils, Context context) {
        this.earningList = earningList;
        this.context = context;
        this.utils = utils;
        setHasStableIds(true);
    }

    @NonNull
    @Override
    public EarningViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.row_item_earning, viewGroup, false);
        return new EarningViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull EarningViewHolder earningsViewHolder, int position) {
        ViewDataBinding viewDataBinding = earningsViewHolder.getViewDataBinding();
        viewDataBinding.setVariable(BR.earnings, earningList.get(position));
    }


    @Override
    public int getItemCount() {
        return earningList.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public long getItemId(int position) {
        try {
            return Long.valueOf(earningList.get(position).getId());
        }catch (Exception e){
            return position;
        }
    }
}
