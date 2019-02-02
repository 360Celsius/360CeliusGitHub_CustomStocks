package com.celsius.customstocks.contentobservers;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;

import com.celsius.customstocks.dbhelper.DBContract;
import com.celsius.customstocks.fragments.SearchFragment;
import com.celsius.customstocks.network.NetworkHTTPConnection;
import com.celsius.customstocks.utils.ReciverServiceConsts;

import javax.inject.Inject;
import javax.inject.Singleton;

import androidx.appcompat.app.AppCompatActivity;

import static com.celsius.customstocks.utils.ReciverServiceConsts.GET_QOUTES_DATA;

@Singleton
public class DataBaseContentObserver extends ContentObserver {

    Intent broadcastIntent = new Intent();
    Context ctx;

    @Inject
    public DataBaseContentObserver(Handler handler,Context ctx) {
        super(handler);
        this.ctx = ctx;
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

        if (uri.toString().contains(String.valueOf(DBContract.AllSymbols.CONTENT_URI))) {

            broadcastIntent.setAction(GET_QOUTES_DATA);
            broadcastIntent.putExtra(ReciverServiceConsts.DATA_TYPE_KEY, ReciverServiceConsts.UPDATE_BULDING_DATA_ROW_ON_SEARCH_FRAGMENT);
            ctx.sendBroadcast(broadcastIntent);
        }

    }


}
