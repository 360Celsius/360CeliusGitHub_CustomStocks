package com.celsius.customstocks.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.celsius.customstocks.R;
import com.celsius.customstocks.databinding.FragmentEarningCalendarBinding;
import com.celsius.customstocks.databinding.FragmentFinancialsBinding;
import com.celsius.customstocks.recyclerviewadapter.EarningCalendarRecyclerViewAdapter;
import com.celsius.customstocks.recyclerviewadapter.FinancialsRecyclerViewAdapter;
import com.celsius.customstocks.services.PullEarningsDataFromIEXService;
import com.celsius.customstocks.services.PullFinancialsDataFromIEXService;
import com.celsius.customstocks.utils.ReciverServiceConsts;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;


public class FinancialsFragment extends BaseFragment {


    public final static String TAG = "EarningCalendarFragment";
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    private FragmentFinancialsBinding binding;
    private View view;
    private FinancialsRecyclerViewAdapter recyclerViewAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_financials, container, false);
        view = binding.getRoot();

        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setRefreshing(false);
        swipeRefreshLayout.setEnabled(false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);


        Intent intent = new Intent(getActivity(), PullFinancialsDataFromIEXService.class);
        intent.putExtra(ReciverServiceConsts.DATA_TYPE_KEY, ReciverServiceConsts.GET_FINANCIALS_DATA);
        getActivity().startService(intent);


        recyclerViewAdapter = new FinancialsRecyclerViewAdapter(helper.getFinancials(),utils,getContext());
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }

    public void updateFinancialsFragmetRecyclerView(){
        recyclerViewAdapter = new FinancialsRecyclerViewAdapter(helper.getFinancials(),utils,getContext());
        recyclerView.swapAdapter(recyclerViewAdapter,false);
    }
}
