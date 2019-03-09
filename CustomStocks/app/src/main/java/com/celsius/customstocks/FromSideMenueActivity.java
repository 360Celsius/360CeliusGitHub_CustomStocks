package com.celsius.customstocks;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.celsius.customstocks.databinding.ActivityFromSideMenuBinding;
import com.celsius.customstocks.databinding.ActivityMainBinding;
import com.celsius.customstocks.fragments.EarningCalendarFragment;
import com.celsius.customstocks.fragments.StocksFragment;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentTransaction;

import static com.celsius.customstocks.utils.ReciverServiceConsts.DATA_TYPE_KEY;
import static com.celsius.customstocks.utils.ReciverServiceConsts.OPEN_SIDE_MENU_ACTIVITY_WITH_MARKETS;

public class FromSideMenueActivity extends BaseActivity implements View.OnClickListener{

    private ActivityFromSideMenuBinding activityFromSideMenuBinding;
    private Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityFromSideMenuBinding = DataBindingUtil.setContentView(this, R.layout.activity_from_side_menu);
        activityFromSideMenuBinding.setListener(this);

        intent = getIntent();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if(intent.getStringExtra(DATA_TYPE_KEY).equals(OPEN_SIDE_MENU_ACTIVITY_WITH_MARKETS)) {
            transaction.replace(R.id.fragment_view_placeholder, new EarningCalendarFragment(), EarningCalendarFragment.TAG);
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
