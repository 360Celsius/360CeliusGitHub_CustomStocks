package com.celsius.customstocks.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.celsius.customstocks.R;
import com.celsius.customstocks.services.PullMarketsDataFromIEXService;
import com.celsius.customstocks.services.PullSrocksDataFromIEXService;
import com.celsius.customstocks.utils.ReciverServiceConsts;

import androidx.annotation.Nullable;


public class StocksFragment extends BaseFragment {

    public final static String TAG = "StocksFragment";
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_stocks, container, false);


        Intent intent = new Intent(getActivity(), PullSrocksDataFromIEXService.class);
        intent.putExtra(ReciverServiceConsts.DATA_TYPE_KEY, ReciverServiceConsts.GET_STOCKS_DATA);
        getActivity().startService(intent);

        return view;
    }
}
