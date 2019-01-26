package com.celsius.customstocks.fragments;


import android.os.Bundle;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.celsius.customstocks.R;
import com.celsius.customstocks.contentobservers.DataBaseContentObserver;
import com.celsius.customstocks.databinding.FragmentSearchBinding;
import com.celsius.customstocks.datamodels.LoadingWindownSymbol;
import com.celsius.customstocks.dbhelper.DBContract;
import com.celsius.customstocks.recyclerviewadapter.AllSymbolsRecyclerViewAdapter;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;


public class SearchFragment extends BaseFragment {

    public final static String TAG = "SearchFragment";
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    private AllSymbolsRecyclerViewAdapter recyclerViewAdapter;

    private DataBaseContentObserver dataBaseContentObserver;
    private FragmentSearchBinding binding;
    private View view;

    @Nullable

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_search, container, false);
        view = binding.getRoot();

        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        recyclerViewAdapter = new AllSymbolsRecyclerViewAdapter(mCallback.getDataBasehelper().getAllSymbols(),utils.getUtils(),getContext());

        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        swipeRefreshLayout.setRefreshing(false);
        swipeRefreshLayout.setEnabled(false);

        dataBaseContentObserver =  new DataBaseContentObserver(new Handler(),getActivity());
        getActivity().getContentResolver().registerContentObserver(DBContract.AllSymbols.CONTENT_URI, true,dataBaseContentObserver);

        updateUpdateProsessLine(false);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        getActivity().getContentResolver().unregisterContentObserver(dataBaseContentObserver);
    }


    public void updateUpdateProsessLine(boolean isToShow){
        LoadingWindownSymbol data = new LoadingWindownSymbol();
        data.setSymbolName(String.valueOf("Building Data "+mCallback.getDataBasehelper().getLatesetInsertedSymbo().getSymbol()));
        data.setIsToShowWindow(isToShow);
        //here data must be an instance of the class MarsDataProvider
        binding.setLoadingWindownSymbol(data);
    }

}
