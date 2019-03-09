package com.celsius.customstocks.recyclerviewadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.celsius.customstocks.BR;
import com.celsius.customstocks.R;
import com.celsius.customstocks.datamodels.VolumeByVenue;
import com.celsius.customstocks.utils.Utils;
import com.celsius.customstocks.viewholders.VolumeByVenueViewHolder;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public class VolumeByVenueRecyclerViewAdapter extends RecyclerView.Adapter<VolumeByVenueViewHolder> {

    private ArrayList<VolumeByVenue> volumeByVenueList = new ArrayList<>();
    private Context context;
    private Utils utils;


    public VolumeByVenueRecyclerViewAdapter(ArrayList<VolumeByVenue> volumeByVenueList, Utils utils, Context context) {
        this.volumeByVenueList = volumeByVenueList;
        this.context = context;
        this.utils = utils;
        setHasStableIds(true);
    }
    @NonNull
    @Override
    public VolumeByVenueViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.row_item_volume_by_venue, viewGroup, false);
        return new VolumeByVenueViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull VolumeByVenueViewHolder marketsViewHolder, int position) {
        ViewDataBinding viewDataBinding = marketsViewHolder.getViewDataBinding();
        viewDataBinding.setVariable(BR.volumeByVenue, volumeByVenueList.get(position));
    }


    @Override
    public int getItemCount() {
        return volumeByVenueList.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public long getItemId(int position) {
        try {
            return Long.valueOf(volumeByVenueList.get(position).getId());
        }catch (Exception e){
            return position;
        }
    }
}
