package com.celsius.customstocks.fragments;

import android.app.Activity;

import com.celsius.customstocks.application.CustomStockApplication;
import com.celsius.customstocks.dbhelper.DBHelper;
import com.celsius.customstocks.utils.Utils;

import javax.inject.Inject;

import androidx.fragment.app.Fragment;


public class BaseFragment extends Fragment {

    @Inject
    public Utils utils;

    @Inject
    public DBHelper helper;


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        CustomStockApplication.getMyComponent().inject(this);

    }

}
