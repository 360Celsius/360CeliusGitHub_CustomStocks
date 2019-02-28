package com.celsius.customstocks;


import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.celsius.customstocks.custombehaviour.BottomNavigationViewBehavior;
import com.celsius.customstocks.fragments.EarningCalendarFragment;
import com.celsius.customstocks.fragments.MarketsFragment;
import com.celsius.customstocks.fragments.MoreFragment;
import com.celsius.customstocks.fragments.NewsFragment;
import com.celsius.customstocks.fragments.SearchFragment;
import com.celsius.customstocks.fragments.StocksFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;


public class MainActivity extends BaseActivity {

    private BottomNavigationView bottomNavigationView;
    private FrameLayout fragmentViewPlaceholder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);

        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) bottomNavigationView.getLayoutParams();
        layoutParams.setBehavior(new BottomNavigationViewBehavior());


        fragmentViewPlaceholder = (FrameLayout) findViewById(R.id.fragment_view_placeholder);

        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        switch (item.getItemId()) {
                            case R.id.action_item1:
                                transaction.replace(R.id.fragment_view_placeholder, new StocksFragment(), StocksFragment.TAG);
                                transaction.addToBackStack(null);
                                break;
                            case R.id.action_item2:
                                transaction.replace(R.id.fragment_view_placeholder, new NewsFragment(),NewsFragment.TAG);
                                transaction.addToBackStack(null);
                                break;
                            case R.id.action_item3:
                                transaction.replace(R.id.fragment_view_placeholder, new SearchFragment(),SearchFragment.TAG);
                                transaction.addToBackStack(null);
                                break;
                            case R.id.action_item4:
                                transaction.replace(R.id.fragment_view_placeholder, new MarketsFragment(),MarketsFragment.TAG);
                                transaction.addToBackStack(null);
                                break;
                            case R.id.action_item5:
                                transaction.replace(R.id.fragment_view_placeholder, new EarningCalendarFragment(),EarningCalendarFragment.TAG);
                                transaction.addToBackStack(null);
                                break;
                        }
                        transaction.commit();
                        return true;
                    }
                });


    }

    @Override
    protected void onResume() {
        super.onResume();
        bottomNavigationView.setSelectedItemId(R.id.action_item3);
    }

}
