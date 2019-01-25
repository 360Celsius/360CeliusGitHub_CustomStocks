package com.celsius.customstocks.fragments;

import android.app.Activity;
import com.celsius.customstocks.iterfaces.DbHelperInterface;
import com.celsius.customstocks.iterfaces.UtilsInterface;

import androidx.fragment.app.Fragment;


public class BaseFragment extends Fragment {

    public DbHelperInterface mCallback = null;
    public UtilsInterface utils = null;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mCallback = (DbHelperInterface) activity;
        utils = (UtilsInterface) activity;

    }

}
