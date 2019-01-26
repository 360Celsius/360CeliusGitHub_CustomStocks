package com.celsius.customstocks.contentobservers;

import android.app.Activity;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;

import com.celsius.customstocks.databinding.FragmentSearchBinding;
import com.celsius.customstocks.datamodels.SymbolName;
import com.celsius.customstocks.dbhelper.DBContract;
import com.celsius.customstocks.fragments.SearchFragment;

import androidx.appcompat.app.AppCompatActivity;

public class DataBaseContentObserver extends ContentObserver {

    private Activity activity;

    /**
     * Creates a content observer.
     *
     * @param handler The handler to run {@link #onChange} on, or null if none.
     * @param binding
     */
    public DataBaseContentObserver(Handler handler, Activity activity) {
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
            ((SearchFragment) ((AppCompatActivity) activity).getSupportFragmentManager().findFragmentByTag(SearchFragment.TAG)).updateUpdateProsessLine();
        }

    }
}
