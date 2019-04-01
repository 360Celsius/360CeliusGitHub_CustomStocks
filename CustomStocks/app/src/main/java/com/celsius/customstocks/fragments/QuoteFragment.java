package com.celsius.customstocks.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.celsius.customstocks.R;
import com.celsius.customstocks.databinding.FragmentQuoteBinding;
import com.celsius.customstocks.databinding.FragmentSettingsBinding;
import com.celsius.customstocks.datamodels.Quote;
import com.celsius.customstocks.services.PullChartDataFromIEXService;
import com.celsius.customstocks.services.PullMarketsDataFromIEXService;
import com.celsius.customstocks.utils.ReciverServiceConsts;

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


        Intent intent = new Intent(getActivity(), PullChartDataFromIEXService.class);
        intent.putExtra(ReciverServiceConsts.DATA_TYPE_KEY, ReciverServiceConsts.GET_CHART_DATA);
        intent.putExtra(ReciverServiceConsts.QUOTE_DATA, quote);
        getActivity().startService(intent);

        return view;
    }


}
