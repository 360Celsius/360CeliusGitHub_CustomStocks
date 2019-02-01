package com.celsius.customstocks.fragments;

import android.app.Activity;

import com.celsius.customstocks.application.CustomStockApplication;
import com.celsius.customstocks.dbhelper.DBHelper;
import com.celsius.customstocks.iterfaces.UtilsInterface;

import javax.inject.Inject;

import androidx.fragment.app.Fragment;


public class BaseFragment extends Fragment {

    public UtilsInterface utils = null;
    @Inject
    public DBHelper helper;


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        CustomStockApplication.getMyComponent().inject(this);

        utils = (UtilsInterface) activity;

    }

}
