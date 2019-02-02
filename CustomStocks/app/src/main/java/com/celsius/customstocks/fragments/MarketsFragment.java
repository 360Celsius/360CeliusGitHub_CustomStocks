package com.celsius.customstocks.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.celsius.customstocks.R;
import com.celsius.customstocks.services.PullDataFromIEXService;
import com.celsius.customstocks.utils.ReciverServiceConsts;

import androidx.annotation.Nullable;


public class MarketsFragment extends BaseFragment {

    public final static String TAG = "MarketsFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_markets, container, false);

        Intent intent = new Intent(getActivity(), PullDataFromIEXService.class);
        intent.putExtra(ReciverServiceConsts.DATA_TYPE_KEY, ReciverServiceConsts.GET_MARKERTS_DATA);
        getActivity().startService(intent);

        return view;
    }
}
