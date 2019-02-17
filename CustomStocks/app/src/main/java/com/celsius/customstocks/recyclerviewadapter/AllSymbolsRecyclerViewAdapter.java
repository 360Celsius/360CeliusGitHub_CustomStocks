package com.celsius.customstocks.recyclerviewadapter;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.celsius.customstocks.BR;
import com.celsius.customstocks.R;
import com.celsius.customstocks.datamodels.Symbol;
import com.celsius.customstocks.iterfaces.AddRemoveStmbolCallbackInterface;
import com.celsius.customstocks.utils.Utils;
import com.celsius.customstocks.viewholders.AllSymbolsViewHolder;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public class AllSymbolsRecyclerViewAdapter extends RecyclerView.Adapter<AllSymbolsViewHolder> {

    private ArrayList<Symbol> allSymbolsList = new ArrayList<>();
    private Context context;
    private Utils utils;

    private AddRemoveStmbolCallbackInterface mAddRemoveStmbolCallbackInterface;


    public AllSymbolsRecyclerViewAdapter(ArrayList<Symbol> list, Utils utils, Context context, AddRemoveStmbolCallbackInterface addRemoveStmbolCallbackInterface) {
        this.allSymbolsList = list;
        this.context = context;
        this.utils = utils;
        this.mAddRemoveStmbolCallbackInterface = addRemoveStmbolCallbackInterface;
        setHasStableIds(true);
    }
    @NonNull
    @Override
    public AllSymbolsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.row_item_all_symbols, viewGroup, false);
        return new AllSymbolsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull AllSymbolsViewHolder allSymbolsViewHolder, int position) {

        ViewDataBinding viewDataBinding = allSymbolsViewHolder.getViewDataBinding();
        viewDataBinding.setVariable(BR.symbol, allSymbolsList.get(position));
        viewDataBinding.setVariable(BR.callback, mAddRemoveStmbolCallbackInterface);
    }

    @Override
    public int getItemCount() {
        return allSymbolsList.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public long getItemId(int position) {
        try {
            return Long.valueOf(allSymbolsList.get(position).getId());
        }catch (Exception e){
            return position;
        }
    }
}
