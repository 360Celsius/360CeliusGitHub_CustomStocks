package com.celsius.customstocks.contentobservers;

import android.app.Activity;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;

import com.celsius.customstocks.dbhelper.DBContract;
import com.celsius.customstocks.fragments.SearchFragment;
import com.celsius.customstocks.network.NetworkHTTPConnection;

import androidx.appcompat.app.AppCompatActivity;

public class DataBaseContentObserver extends ContentObserver {

    private Activity activity;
    private static DataBaseContentObserver _instance;


    public static DataBaseContentObserver getInstance(Handler handler, Activity activity)
    {
        if (_instance == null)
        {
            _instance = new DataBaseContentObserver(handler, activity);
        }
        return _instance;
    }

    private DataBaseContentObserver(Handler handler, Activity activity) {
        super(handler);
        this.activity = activity;
    }


    @Override
    public void onChange(boolean selfChange) {
        this.onChange(selfChange, null);
    }

    @Override
    public void onChange(boolean selfChange, Uri uri) {
        // do s.th.
        // depending on the handler you might be on the UI
        // thread, so be cautious!updateRecyclerView

        if(uri.toString().contains(String.valueOf(DBContract.AllSymbols.CONTENT_URI))){
            ((SearchFragment) ((AppCompatActivity) activity).getSupportFragmentManager().findFragmentByTag(SearchFragment.TAG)).updateUpdateProsessLine(true);
        }

    }
}
