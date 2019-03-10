package com.celsius.customstocks.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.celsius.customstocks.R;
import com.celsius.customstocks.databinding.FragmentQuoteBinding;
import com.celsius.customstocks.databinding.FragmentSettingsBinding;
import com.celsius.customstocks.datamodels.Quote;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import static com.celsius.customstocks.utils.ReciverServiceConsts.QUOTE_DATA;

public class QuoteFragment extends BaseFragment {

    public final static String TAG = "QuoteFragment";
    private View view;
    private FragmentQuoteBinding binding;
    private Quote quote;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_quote, container, false);
        view = binding.getRoot();


        quote = (Quote) getArguments().getSerializable(QUOTE_DATA);
        binding.setQuote(quote);

        return view;
    }


}
