package com.celsius.customstocks.recyclerviewadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.celsius.customstocks.BR;
import com.celsius.customstocks.R;
import com.celsius.customstocks.datamodels.News;
import com.celsius.customstocks.utils.Utils;
import com.celsius.customstocks.viewholders.NewsViewHolder;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public class NewsRecyclerViewAdapter extends RecyclerView.Adapter<NewsViewHolder> {

    private ArrayList<News> newsList = new ArrayList<>();
    private Context context;
    private Utils utils;


    public NewsRecyclerViewAdapter(ArrayList<News> newsList, Utils utils, Context context) {
        this.newsList = newsList;
        this.context = context;
        this.utils = utils;
        setHasStableIds(true);
    }
    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.row_item_news, viewGroup, false);
        return new NewsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder marketsViewHolder, int position) {
        ViewDataBinding viewDataBinding = marketsViewHolder.getViewDataBinding();
        viewDataBinding.setVariable(BR.news, newsList.get(position));
    }


    @Override
    public int getItemCount() {
        return newsList.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public long getItemId(int position) {
        try {
            return Long.valueOf(newsList.get(position).getId());
        }catch (Exception e){
            return position;
        }
    }
}
