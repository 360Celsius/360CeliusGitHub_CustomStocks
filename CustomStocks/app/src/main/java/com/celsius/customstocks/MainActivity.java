package com.celsius.customstocks;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.celsius.customstocks.custombehaviour.BottomNavigationViewBehavior;
import com.celsius.customstocks.databinding.ActivityMainBinding;
import com.celsius.customstocks.datamodels.DrawerState;
import com.celsius.customstocks.fragments.EarningCalendarFragment;
import com.celsius.customstocks.fragments.FinancialsFragment;
import com.celsius.customstocks.fragments.MarketsFragment;
import com.celsius.customstocks.fragments.VolumeByVenueFragment;
import com.celsius.customstocks.fragments.SearchFragment;
import com.celsius.customstocks.fragments.StocksFragment;
import com.celsius.customstocks.services.PullSymbolsDataFromIEXService;
import com.celsius.customstocks.utils.ReciverServiceConsts;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import static com.celsius.customstocks.utils.ReciverServiceConsts.DATA_TYPE_KEY;
import static com.celsius.customstocks.utils.ReciverServiceConsts.OPEN_SIDE_MENU_ACTIVITY_WITH_MARKETS;


public class MainActivity extends BaseActivity implements View.OnClickListener {

    private BottomNavigationView bottomNavigationView;
    private FrameLayout fragmentViewPlaceholder;

    private DrawerLayout drawerLayout;
    private LinearLayout content;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    private ActivityMainBinding activityMainBinding;

    private DrawerState drawerState;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setListener(this);

        drawerState = new DrawerState();
        activityMainBinding.setDrawerState(drawerState);

        ///////////   Sliding menu configuration ////////////
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        content = (LinearLayout) findViewById(R.id.content);

        drawerLayout.setScrimColor(Color.TRANSPARENT);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close) {
            private float scaleFactor = 6f;

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                float slideX = drawerView.getWidth() * slideOffset;
                content.setTranslationX(slideX);
                content.setScaleX(1 - (slideOffset / scaleFactor));
                content.setScaleY(1 - (slideOffset / scaleFactor));

                if(slideOffset == 0) {
                    drawerState.setIsDrawerOpen(false);
                }else {
                    drawerState.setIsDrawerOpen(true);
                }
            }

        };

        drawerLayout.setScrimColor(Color.TRANSPARENT);
        drawerLayout.setDrawerElevation(0f);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);

        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) bottomNavigationView.getLayoutParams();
        layoutParams.setBehavior(new BottomNavigationViewBehavior());
        ///////////////////////////////////////////////////////////


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
                                transaction.replace(R.id.fragment_view_placeholder, new VolumeByVenueFragment(), VolumeByVenueFragment.TAG);
                                transaction.addToBackStack(null);
                                break;
                            case R.id.action_item3:
                                transaction.replace(R.id.fragment_view_placeholder, new SearchFragment(),SearchFragment.TAG);
                                transaction.addToBackStack(null);
                                break;
                            case R.id.action_item4:
                                transaction.replace(R.id.fragment_view_placeholder, new FinancialsFragment(),FinancialsFragment.TAG);
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

    @Override
    public void onClick(View v) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (v.getId()){
            case R.id.menu_button:
                drawerLayout.openDrawer(GravityCompat.START);
            break;

            case R.id.stocks:
                drawerLayout.closeDrawer(GravityCompat.START);
                bottomNavigationView.setSelectedItemId(R.id.action_item1);
                transaction.replace(R.id.fragment_view_placeholder, new StocksFragment(), StocksFragment.TAG);
                transaction.addToBackStack(null);
                transaction.commit();
                break;

            case R.id.volumeByVenue:
                drawerLayout.closeDrawer(GravityCompat.START);
                bottomNavigationView.setSelectedItemId(R.id.action_item2);
                transaction.replace(R.id.fragment_view_placeholder, new VolumeByVenueFragment(), VolumeByVenueFragment.TAG);
                transaction.addToBackStack(null);
                transaction.commit();
                break;

            case R.id.search:
                drawerLayout.closeDrawer(GravityCompat.START);
                bottomNavigationView.setSelectedItemId(R.id.action_item3);
                transaction.replace(R.id.fragment_view_placeholder, new SearchFragment(),SearchFragment.TAG);
                transaction.addToBackStack(null);
                transaction.commit();
                break;

            case R.id.markets:
                drawerLayout.closeDrawer(GravityCompat.START);
                Intent intent = new Intent(getApplicationContext(), FromSideMenueActivity.class);
                intent.putExtra(DATA_TYPE_KEY,OPEN_SIDE_MENU_ACTIVITY_WITH_MARKETS);
                startActivity(intent);
                break;

            case R.id.calendar:
                drawerLayout.closeDrawer(GravityCompat.START);
                bottomNavigationView.setSelectedItemId(R.id.action_item5);
                transaction.replace(R.id.fragment_view_placeholder, new EarningCalendarFragment(),EarningCalendarFragment.TAG);
                transaction.addToBackStack(null);
                transaction.commit();
                break;

            case R.id.financials:
                drawerLayout.closeDrawer(GravityCompat.START);
                bottomNavigationView.setSelectedItemId(R.id.action_item4);
                transaction.replace(R.id.fragment_view_placeholder, new FinancialsFragment(),FinancialsFragment.TAG);
                transaction.addToBackStack(null);
                transaction.commit();
                break;

            case R.id.settings:
                drawerLayout.closeDrawer(GravityCompat.START);
                break;

            case R.id.info:
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
        }
    }
}
