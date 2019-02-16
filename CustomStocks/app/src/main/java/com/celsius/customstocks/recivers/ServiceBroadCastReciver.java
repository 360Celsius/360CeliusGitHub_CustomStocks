package com.celsius.customstocks.recivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.celsius.customstocks.MainActivity;
import com.celsius.customstocks.fragments.MarketsFragment;
import com.celsius.customstocks.fragments.NewsFragment;
import com.celsius.customstocks.fragments.SearchFragment;
import com.celsius.customstocks.fragments.StocksFragment;
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


        }else if( intent.getStringExtra(ReciverServiceConsts.DATA_TYPE_KEY).equalsIgnoreCase(ReciverServiceConsts.UPDATE_BULDING_DATA_ROW_ON_SEARCH_FRAGMENT) ){
            if( ((AppCompatActivity) context).getSupportFragmentManager().findFragmentByTag(SearchFragment.TAG) !=null )
                ((SearchFragment) ((AppCompatActivity) context).getSupportFragmentManager().findFragmentByTag(SearchFragment.TAG)).updateUpdateProsessLine(true);

        }else if( intent.getStringExtra(ReciverServiceConsts.DATA_TYPE_KEY).equalsIgnoreCase(ReciverServiceConsts.RELOAD_MARKETS_FRAGMNET) ){
            if( ((AppCompatActivity) context).getSupportFragmentManager().findFragmentByTag(MarketsFragment.TAG) !=null )
                ((MarketsFragment) ((AppCompatActivity) context).getSupportFragmentManager().findFragmentByTag(MarketsFragment.TAG)).updateMarketsFragmetRecyclerView();

        }else if( intent.getStringExtra(ReciverServiceConsts.DATA_TYPE_KEY).equalsIgnoreCase(ReciverServiceConsts.RELOAD_QUOTES_FRAGMNET) ){
            if( ((AppCompatActivity) context).getSupportFragmentManager().findFragmentByTag(StocksFragment.TAG) !=null )
                ((StocksFragment) ((AppCompatActivity) context).getSupportFragmentManager().findFragmentByTag(StocksFragment.TAG)).updateStocksFragmetRecyclerView();

        }else if( intent.getStringExtra(ReciverServiceConsts.DATA_TYPE_KEY).equalsIgnoreCase(ReciverServiceConsts.RELOAD_NEWS_FRAGMNET) ){
            if( ((AppCompatActivity) context).getSupportFragmentManager().findFragmentByTag(NewsFragment.TAG) !=null )
                ((NewsFragment) ((AppCompatActivity) context).getSupportFragmentManager().findFragmentByTag(NewsFragment.TAG)).updateNewsFragmetRecyclerView();
        }
    }
}
