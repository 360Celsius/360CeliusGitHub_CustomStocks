package com.celsius.customstocks.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.celsius.customstocks.R;
import com.celsius.customstocks.databinding.FragmentNewsBinding;
import com.celsius.customstocks.databinding.FragmentStocksBinding;
import com.celsius.customstocks.recyclerviewadapter.NewsRecyclerViewAdapter;
import com.celsius.customstocks.recyclerviewadapter.StocksRecyclerViewAdapter;
import com.celsius.customstocks.services.PullNewsDataFromIEXService;
import com.celsius.customstocks.services.PullStocksDataFromIEXService;
import com.celsius.customstocks.utils.ReciverServiceConsts;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;


public class NewsFragment extends BaseFragment {


    public final static String TAG = "NewsFragment";
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    private FragmentNewsBinding binding;
    private View view;
    private NewsRecyclerViewAdapter recyclerViewAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_news, container, false);
        view = binding.getRoot();

        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setRefreshing(false);
        swipeRefreshLayout.setEnabled(false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);


        Intent intent = new Intent(getActivity(), PullNewsDataFromIEXService.class);
        intent.putExtra(ReciverServiceConsts.DATA_TYPE_KEY, ReciverServiceConsts.GET_NEWS_DATA);
        getActivity().startService(intent);


        recyclerViewAdapter = new NewsRecyclerViewAdapter(helper.getNews(),utils,getContext());
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }

    public void updateNewsFragmetRecyclerView(){
        recyclerViewAdapter = new NewsRecyclerViewAdapter(helper.getNews(),utils,getContext());
        recyclerView.swapAdapter(recyclerViewAdapter,false);
    }
}
