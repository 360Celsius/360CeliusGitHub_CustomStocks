package com.celsius.customstocks;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.celsius.customstocks.databinding.ActivityQuoteBinding;
import com.celsius.customstocks.datamodels.Quote;
import com.celsius.customstocks.datamodels.QuoteNameOnActionBar;
import com.celsius.customstocks.fragments.QuoteFragment;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentTransaction;

import static com.celsius.customstocks.utils.ReciverServiceConsts.DATA_TYPE_KEY;
import static com.celsius.customstocks.utils.ReciverServiceConsts.OPEN_SIDE_MENU_ACTIVITY_WITH_MARKETS;
import static com.celsius.customstocks.utils.ReciverServiceConsts.OPEN_SIDE_QUOTE_ACTIVITY;
import static com.celsius.customstocks.utils.ReciverServiceConsts.QUOTE_DATA;

public class QuoteActivity extends BaseActivity implements View.OnClickListener{

    private ActivityQuoteBinding activityQuoteBinding;
    private Intent intent;
    private QuoteNameOnActionBar quoteNameOnActionBar;
    private Quote quote;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityQuoteBinding = DataBindingUtil.setContentView(this, R.layout.activity_quote);
        activityQuoteBinding.setListener(this);

        quoteNameOnActionBar = new QuoteNameOnActionBar();
        activityQuoteBinding.setQuoteNameOnActionBar(quoteNameOnActionBar);

        intent = getIntent();
        if(intent.getStringExtra(DATA_TYPE_KEY).equals(OPEN_SIDE_QUOTE_ACTIVITY)) {
            quote = (Quote) intent.getExtras().getSerializable(QUOTE_DATA);
            quoteNameOnActionBar.setQuoteName(quote.getCompanyName());
        }

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_quote_view_placeholder, new QuoteFragment(), QuoteFragment.TAG);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back_button:
                finish();
                break;
        }
    }


}
