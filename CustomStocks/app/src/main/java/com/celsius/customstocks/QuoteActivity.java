package com.celsius.customstocks;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.celsius.customstocks.databinding.ActivityFromSideMenuBinding;
import com.celsius.customstocks.databinding.ActivityQuoteBinding;
import com.celsius.customstocks.datamodels.FragmentNameOnActionBar;
import com.celsius.customstocks.fragments.InfoFragment;
import com.celsius.customstocks.fragments.MarketsFragment;
import com.celsius.customstocks.fragments.QuoteFragment;
import com.celsius.customstocks.fragments.SettingsFragment;
import com.celsius.customstocks.fragments.StocksFragment;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentTransaction;

import static com.celsius.customstocks.utils.ReciverServiceConsts.DATA_TYPE_KEY;
import static com.celsius.customstocks.utils.ReciverServiceConsts.FRAGMENT_NAME;
import static com.celsius.customstocks.utils.ReciverServiceConsts.OPEN_SIDE_MENU_ACTIVITY_WITH_INFO;
import static com.celsius.customstocks.utils.ReciverServiceConsts.OPEN_SIDE_MENU_ACTIVITY_WITH_MARKETS;
import static com.celsius.customstocks.utils.ReciverServiceConsts.OPEN_SIDE_MENU_ACTIVITY_WITH_SETTINGS;

public class QuoteActivity extends BaseActivity implements View.OnClickListener{

    private ActivityQuoteBinding activityFromSideMenuBinding;
    private Intent intent;
    private FragmentNameOnActionBar fragmentNameOnActionBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityFromSideMenuBinding = DataBindingUtil.setContentView(this, R.layout.activity_quote);
        activityFromSideMenuBinding.setListener(this);

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
