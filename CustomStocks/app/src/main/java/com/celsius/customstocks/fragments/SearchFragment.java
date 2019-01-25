package com.celsius.customstocks.fragments;


import android.os.Bundle;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.celsius.customstocks.R;
import com.celsius.customstocks.dbhelper.DBContract;
import com.celsius.customstocks.recyclerviewadapter.AllSymbolsRecyclerViewAdapter;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;


public class SearchFragment extends BaseFragment {

    public final static String TAG = "SearchFragment";
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    private AllSymbolsRecyclerViewAdapter recyclerViewAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        recyclerViewAdapter = new AllSymbolsRecyclerViewAdapter(mCallback.getDataBasehelper().getAllSymbols(),utils.getUtils(),getContext());

        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        swipeRefreshLayout.setRefreshing(false);
        swipeRefreshLayout.setEnabled(false);

        return view;
    }
}
