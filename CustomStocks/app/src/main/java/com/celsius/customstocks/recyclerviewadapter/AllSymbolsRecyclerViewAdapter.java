package com.celsius.customstocks.recyclerviewadapter;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.celsius.customstocks.R;
import com.celsius.customstocks.datamodels.Symbol;
import com.celsius.customstocks.utils.Utils;
import com.celsius.customstocks.viewholders.AllSymbolsViewHolder;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AllSymbolsRecyclerViewAdapter extends RecyclerView.Adapter<AllSymbolsViewHolder> {

    private ArrayList<Symbol> allSymbolsList = new ArrayList<>();
    private Context context;
    private Utils utils;

    public AllSymbolsRecyclerViewAdapter(ArrayList<Symbol> list, Utils utils, Context context) {
        this.allSymbolsList = list;
        this.context = context;
        this.utils = utils;
    }
    @NonNull
    @Override
    public AllSymbolsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.all_symbols_row_item, viewGroup, false);
        AllSymbolsViewHolder holder = new AllSymbolsViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AllSymbolsViewHolder allSymbolsViewHolder, int position) {
        allSymbolsViewHolder.symbol.setText(allSymbolsList.get(position).getSymbol());
        allSymbolsViewHolder.symbolName.setText(allSymbolsList.get(position).getName());
        allSymbolsViewHolder.symbolType.setText(utils.convertShortTypeToLongType( allSymbolsList.get(position).getType()) );

    }

    @Override
    public int getItemCount() {
        return allSymbolsList.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
