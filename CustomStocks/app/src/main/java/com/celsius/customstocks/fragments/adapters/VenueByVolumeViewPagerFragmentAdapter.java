package com.celsius.customstocks.fragments.adapters;

import android.content.Context;

import com.celsius.customstocks.fragments.VolumeByVenueFragment;
import java.util.List;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class VenueByVolumeViewPagerFragmentAdapter extends FragmentStatePagerAdapter {

    private Context ctx;
    private List<String> data;
    private Fragment[] fragments;

    public VenueByVolumeViewPagerFragmentAdapter(Context ctx, FragmentManager fm, List<String> data) {
        super(fm);
        this.ctx = ctx;
        this.data = data;
        fragments = new Fragment[data.size()];
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        String items = data.get(position);


        VolumeByVenueFragment dinamisFragment = new VolumeByVenueFragment();
        dinamisFragment.setVenue(items);
        fragment = dinamisFragment;

        if (fragments[position] == null) {
            fragments[position] = fragment;
        }
        return fragments[position];
    }

    @Override
    public int getCount() {
        if (data != null) {
            return data.size();
        } else {
            return 0;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return data.get(position);
    }
}
