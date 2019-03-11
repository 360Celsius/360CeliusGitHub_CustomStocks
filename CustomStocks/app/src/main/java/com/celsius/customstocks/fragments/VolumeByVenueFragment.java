package com.celsius.customstocks.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.celsius.customstocks.R;
import com.celsius.customstocks.databinding.FragmentVolumeByVenueBinding;
import com.celsius.customstocks.recyclerviewadapter.VolumeByVenueRecyclerViewAdapter;
import com.celsius.customstocks.services.PullVoleumeByVenueDataFromIEXService;
import com.celsius.customstocks.utils.ReciverServiceConsts;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;


public class VolumeByVenueFragment extends BaseFragment {


    public final static String TAG = "VolumeByVenueFragment";
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    private FragmentVolumeByVenueBinding binding;
    private View view;
    private VolumeByVenueRecyclerViewAdapter recyclerViewAdapter;

    private String venue;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_volume_by_venue, container, false);
        view = binding.getRoot();

        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setRefreshing(false);
        swipeRefreshLayout.setEnabled(false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

// Not in use because I am using in in the VolumeByVenueFragmentPaged fragment
//        Intent intent = new Intent(getActivity(), PullVoleumeByVenueDataFromIEXService.class);
//        intent.putExtra(ReciverServiceConsts.DATA_TYPE_KEY, ReciverServiceConsts.GET_VOLUME_BE_VENUE_DATA);
//        getActivity().startService(intent);


        recyclerViewAdapter = new VolumeByVenueRecyclerViewAdapter(helper.getValueByVenue(venue),utils,getContext());
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }

// Not in use because I am using setData() from VolumeByVenueFragmentPaged fragment
//    public void updateVolumeByVenueFragmetRecyclerView(){
//        recyclerViewAdapter = new VolumeByVenueRecyclerViewAdapter(helper.getValueByVenue(venue),utils,getContext());
//        recyclerView.swapAdapter(recyclerViewAdapter,false);
//    }

    public void setVenue(String venue) {
        this.venue = venue;
    }
}
