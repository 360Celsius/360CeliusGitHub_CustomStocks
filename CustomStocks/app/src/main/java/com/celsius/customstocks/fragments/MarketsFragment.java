package com.celsius.customstocks.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.celsius.customstocks.R;

import androidx.annotation.Nullable;


public class MarketsFragment extends BaseFragment {

    public final static String TAG = "MarketsFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_markets, container, false);
        return view;
    }
}
