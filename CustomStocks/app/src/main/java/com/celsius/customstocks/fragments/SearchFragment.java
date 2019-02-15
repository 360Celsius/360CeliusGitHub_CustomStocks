package com.celsius.customstocks.fragments;


import android.os.Bundle;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.celsius.customstocks.R;
import com.celsius.customstocks.application.CustomStockApplication;
import com.celsius.customstocks.contentobservers.DataBaseContentObserver;
import com.celsius.customstocks.databinding.FragmentSearchBinding;
import com.celsius.customstocks.datamodels.LoadingWindownSymbol;
import com.celsius.customstocks.datamodels.Symbol;
import com.celsius.customstocks.dbhelper.DBContract;
import com.celsius.customstocks.iterfaces.ActionCallbackInterface;
import com.celsius.customstocks.recyclerviewadapter.AllSymbolsRecyclerViewAdapter;

import javax.inject.Inject;

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

    @Inject
    DataBaseContentObserver dataBaseContentObserver;

    private FragmentSearchBinding binding;
    private View view;

    private LoadingWindownSymbol data;

    ActionCallbackInterface actionCallbackInterface;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {


        CustomStockApplication.getMyComponent().inject(this);

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_search, container, false);
        view = binding.getRoot();

        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        actionCallbackInterface = new ActionCallbackInterface() {
            @Override
            public void onClick(Symbol symbol) {
                Log.e("test",symbol.getSymbol());
                helper.addSymbolToWatchList(symbol);
                updateSearchFragmetRecyclerView(false);
            }

        };

        recyclerViewAdapter = new AllSymbolsRecyclerViewAdapter(helper.getAllSymbols(),utils,getContext(), actionCallbackInterface);

        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        swipeRefreshLayout.setRefreshing(false);
        swipeRefreshLayout.setEnabled(false);

        getActivity().getContentResolver().registerContentObserver(DBContract.AllSymbols.CONTENT_URI, true,dataBaseContentObserver);

        data = new LoadingWindownSymbol();
        //here data must be an instance of the class MarsDataProvider
        binding.setLoadingWindownSymbol(data);

        updateUpdateProsessLine(false);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        getActivity().getContentResolver().unregisterContentObserver(dataBaseContentObserver);
    }


    public void updateUpdateProsessLine(boolean isToShow){
        data.setSymbolName(String.valueOf("Building Data "+helper.getLatesetInsertedSymbo().getSymbol()));
        data.setIsToShowWindow(isToShow);
    }

    public void updateSearchFragmetRecyclerView(boolean isToShowUpdateLine){
        recyclerViewAdapter = new AllSymbolsRecyclerViewAdapter(helper.getAllSymbols(),utils,getContext(), actionCallbackInterface);

        recyclerView.swapAdapter(recyclerViewAdapter,false);

        data.setIsToShowWindow(isToShowUpdateLine);
    }

}
