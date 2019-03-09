package com.celsius.customstocks.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.celsius.customstocks.R;
import com.celsius.customstocks.databinding.FragmentSettingsBinding;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

public class SettingsFragment extends BaseFragment {

    public final static String TAG = "SettingsFragment";
    private View view;
    private FragmentSettingsBinding binding;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_settings, container, false);
        view = binding.getRoot();

        return view;
    }
}
