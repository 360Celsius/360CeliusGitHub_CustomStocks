package com.celsius.customstocks.recivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.celsius.customstocks.MainActivity;
import com.celsius.customstocks.fragments.SearchFragment;
import com.celsius.customstocks.utils.ReciverServiceConsts;

import androidx.appcompat.app.AppCompatActivity;

public class ServiceBroadCastReciver extends BroadcastReceiver {


    private static ServiceBroadCastReciver _instance;


    private ServiceBroadCastReciver() {

    }

    public static ServiceBroadCastReciver getInstance()
    {
        if (_instance == null)
        {
            _instance = new ServiceBroadCastReciver();
        }
        return _instance;
    }

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
