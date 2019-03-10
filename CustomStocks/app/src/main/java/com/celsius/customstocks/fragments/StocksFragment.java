package com.celsius.customstocks.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.celsius.customstocks.FromSideMenueActivity;
import com.celsius.customstocks.QuoteActivity;
import com.celsius.customstocks.R;
import com.celsius.customstocks.databinding.FragmentMarketsBinding;
import com.celsius.customstocks.databinding.FragmentStocksBinding;
import com.celsius.customstocks.datamodels.Quote;
import com.celsius.customstocks.iterfaces.EnterQuoteCallbackInterface;
import com.celsius.customstocks.recyclerviewadapter.MarketsRecyclerViewAdapter;
import com.celsius.customstocks.recyclerviewadapter.StocksRecyclerViewAdapter;
import com.celsius.customstocks.services.PullStocksDataFromIEXService;
import com.celsius.customstocks.utils.ReciverServiceConsts;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import static com.celsius.customstocks.utils.ReciverServiceConsts.DATA_TYPE_KEY;
import static com.celsius.customstocks.utils.ReciverServiceConsts.FRAGMENT_NAME;
import static com.celsius.customstocks.utils.ReciverServiceConsts.FRAGMENT_NAME_MARKETS;
import static com.celsius.customstocks.utils.ReciverServiceConsts.OPEN_SIDE_MENU_ACTIVITY_WITH_MARKETS;
import static com.celsius.customstocks.utils.ReciverServiceConsts.OPEN_SIDE_QUOTE_ACTIVITY;
import static com.celsius.customstocks.utils.ReciverServiceConsts.QUOTE_DATA;


public class StocksFragment extends BaseFragment {

    public final static String TAG = "StocksFragment";
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    private FragmentStocksBinding binding;
    private View view;
    private StocksRecyclerViewAdapter recyclerViewAdapter;

    EnterQuoteCallbackInterface enterQuoteCallbackInterface;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_stocks, container, false);
        view = binding.getRoot();

        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setRefreshing(false);
        swipeRefreshLayout.setEnabled(false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        enterQuoteCallbackInterface = new EnterQuoteCallbackInterface() {
            @Override
            public void onClick(Quote quote) {
                Log.e("TEST",String.valueOf(quote.getSymbol()));
                Intent intent = new Intent(getContext(), QuoteActivity.class);
                intent.putExtra(DATA_TYPE_KEY,OPEN_SIDE_QUOTE_ACTIVITY);
                intent.putExtra(QUOTE_DATA,quote);
                startActivity(intent);
            }
        };

        Intent intent = new Intent(getActivity(), PullStocksDataFromIEXService.class);
        intent.putExtra(ReciverServiceConsts.DATA_TYPE_KEY, ReciverServiceConsts.GET_STOCKS_DATA);
        getActivity().startService(intent);


        recyclerViewAdapter = new StocksRecyclerViewAdapter(helper.getQuotes(),utils,getContext(),enterQuoteCallbackInterface);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }

    public void updateStocksFragmetRecyclerView(){
        recyclerViewAdapter = new StocksRecyclerViewAdapter(helper.getQuotes(),utils,getContext(),enterQuoteCallbackInterface);
        recyclerView.swapAdapter(recyclerViewAdapter,false);
    }
}
