package com.celsius.customstocks.fragments;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.celsius.customstocks.R;
import com.celsius.customstocks.databinding.FragmentVolumeByVenueBinding;
import com.celsius.customstocks.databinding.FragmentVolumeByVenuePagedBinding;
import com.celsius.customstocks.fragments.adapters.VenueByVolumeViewPagerFragmentAdapter;
import com.celsius.customstocks.services.PullVoleumeByVenueDataFromIEXService;
import com.celsius.customstocks.utils.ReciverServiceConsts;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.ViewPager;

public class VolumeByVenuePagedFragment extends BaseFragment implements ViewPager.OnPageChangeListener{


    public final static String TAG = "VolumeByVenuePagedFragment";

    private TabLayout tabLayout;
    private ViewPager viewPager;

    private List<String> pagerFragments = new ArrayList<>();
    private VenueByVolumeViewPagerFragmentAdapter fragmentAdapter;
    private Context context;
    private FragmentVolumeByVenuePagedBinding binding;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_volume_by_venue_paged, container, false);
        view = binding.getRoot();

        tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        viewPager = (ViewPager) view.findViewById(R.id.viewPager_itemList);

        Intent intent = new Intent(getActivity(), PullVoleumeByVenueDataFromIEXService.class);
        intent.putExtra(ReciverServiceConsts.DATA_TYPE_KEY, ReciverServiceConsts.GET_VOLUME_BE_VENUE_DATA);
        getActivity().startService(intent);

        setData();

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public void setData(){

        pagerFragments = helper.getCategoriesValueByVenue();

        fragmentAdapter = new VenueByVolumeViewPagerFragmentAdapter(getActivity(), getFragmentManager(), pagerFragments);
        viewPager.setAdapter(fragmentAdapter);
        viewPager.setCurrentItem(0);
        viewPager.setOnPageChangeListener(this);

        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.splash_activity_bg));
        tabLayout.setHorizontalFadingEdgeEnabled(true);
        tabLayout.setFadingEdgeLength(150);

        setViewPagerNavigator();

    }

    private void setViewPagerNavigator(){

        String[] str = new String[pagerFragments.size()];
        for(int i=0 ; i<pagerFragments.size(); i++ ){
            str[i] = pagerFragments.get(i);
        }
    }
}
