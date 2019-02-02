package com.celsius.customstocks.recivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.celsius.customstocks.MainActivity;
import com.celsius.customstocks.fragments.SearchFragment;
import com.celsius.customstocks.utils.ReciverServiceConsts;

import javax.inject.Inject;
import javax.inject.Singleton;

import androidx.appcompat.app.AppCompatActivity;

@Singleton
public class ServiceBroadCastReciver extends BroadcastReceiver {


    @Inject
    public ServiceBroadCastReciver() {}


    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getStringExtra(ReciverServiceConsts.DATA_TYPE_KEY).equalsIgnoreCase(ReciverServiceConsts.LOAD_MAIN_ACTIVITY)) {
            Intent intentone = new Intent(context.getApplicationContext(), MainActivity.class);
            context.startActivity(intentone);
        }else if(intent.getStringExtra(ReciverServiceConsts.DATA_TYPE_KEY).equalsIgnoreCase(ReciverServiceConsts.RELOAD_SEARCH_FRAGMNET_ALL_SYMBOLS_ADDED)){
            if( ((AppCompatActivity) context).getSupportFragmentManager().findFragmentByTag(SearchFragment.TAG) !=null )
                ((SearchFragment) ((AppCompatActivity) context).getSupportFragmentManager().findFragmentByTag(SearchFragment.TAG)).updateSearchFragmetRecyclerView(false);


        }
    }
}
