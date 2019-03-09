package com.celsius.customstocks;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.celsius.customstocks.databinding.ActivityFromSideMenuBinding;
import com.celsius.customstocks.databinding.ActivityMainBinding;
import com.celsius.customstocks.datamodels.FragmentNameOnActionBar;
import com.celsius.customstocks.fragments.EarningCalendarFragment;
import com.celsius.customstocks.fragments.InfoFragment;
import com.celsius.customstocks.fragments.MarketsFragment;
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

public class FromSideMenueActivity extends BaseActivity implements View.OnClickListener{

    private ActivityFromSideMenuBinding activityFromSideMenuBinding;
    private Intent intent;
    private FragmentNameOnActionBar fragmentNameOnActionBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityFromSideMenuBinding = DataBindingUtil.setContentView(this, R.layout.activity_from_side_menu);
        activityFromSideMenuBinding.setListener(this);

        fragmentNameOnActionBar = new FragmentNameOnActionBar();

        activityFromSideMenuBinding.setFragmentNameOnActionBar(fragmentNameOnActionBar);

        intent = getIntent();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if(intent.getStringExtra(DATA_TYPE_KEY).equals(OPEN_SIDE_MENU_ACTIVITY_WITH_MARKETS)) {

            fragmentNameOnActionBar.setFragmentName(intent.getStringExtra(FRAGMENT_NAME));

            transaction.replace(R.id.fragment_view_placeholder, new MarketsFragment(), MarketsFragment.TAG);
            transaction.addToBackStack(null);

        }else if(intent.getStringExtra(DATA_TYPE_KEY).equals(OPEN_SIDE_MENU_ACTIVITY_WITH_INFO)) {

            fragmentNameOnActionBar.setFragmentName(intent.getStringExtra(FRAGMENT_NAME));

            transaction.replace(R.id.fragment_view_placeholder, new InfoFragment(), InfoFragment.TAG);
            transaction.addToBackStack(null);

        }else if(intent.getStringExtra(DATA_TYPE_KEY).equals(OPEN_SIDE_MENU_ACTIVITY_WITH_SETTINGS)) {

            fragmentNameOnActionBar.setFragmentName(intent.getStringExtra(FRAGMENT_NAME));

            transaction.replace(R.id.fragment_view_placeholder, new SettingsFragment(), SettingsFragment.TAG);
            transaction.addToBackStack(null);
        }
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
