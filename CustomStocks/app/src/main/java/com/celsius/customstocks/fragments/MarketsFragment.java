package com.celsius.customstocks.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.celsius.customstocks.R;
import com.celsius.customstocks.databinding.FragmentMarketsBinding;
import com.celsius.customstocks.recyclerviewadapter.AllSymbolsRecyclerViewAdapter;
import com.celsius.customstocks.recyclerviewadapter.MarketsRecyclerViewAdapter;
import com.celsius.customstocks.services.PullMarketsDataFromIEXService;
import com.celsius.customstocks.services.PullSymbolsDataFromIEXService;
import com.celsius.customstocks.utils.ReciverServiceConsts;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;


public class MarketsFragment extends BaseFragment {

    public final static String TAG = "MarketsFragment";
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    private FragmentMarketsBinding binding;
    private View view;
    private MarketsRecyclerViewAdapter recyclerViewAdapter;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_markets, container, false);
        view = binding.getRoot();

        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setRefreshing(false);
        swipeRefreshLayout.setEnabled(false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        Intent intent = new Intent(getActivity(), PullMarketsDataFromIEXService.class);
        intent.putExtra(ReciverServiceConsts.DATA_TYPE_KEY, ReciverServiceConsts.GET_MARKERTS_DATA);
        getActivity().startService(intent);


        updateMarketsFragmetRecyclerView();


        return view;
    }

    public void updateMarketsFragmetRecyclerView(){
        recyclerViewAdapter = new MarketsRecyclerViewAdapter(helper.getMarkets(),utils,getContext());
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

    }
}
