package com.celsius.customstocks.contentobservers;

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

//    private static DataBaseContentObserver _instance;
    private Context ctx;
    FragmentSearchBinding binding;

//    public static DataBaseContentObserver getInstance(Handler handler, Context ctx, FragmentSearchBinding binding)
//    {
//        if (_instance == null)
//        {
//            _instance = new DataBaseContentObserver(handler,ctx, binding);
//        }
//        return _instance;
//    }


    /**
     * Creates a content observer.
     *
     * @param handler The handler to run {@link #onChange} on, or null if none.
     * @param binding
     */
    public DataBaseContentObserver(Handler handler, Context cyx, FragmentSearchBinding binding) {
        super(handler);
        this.ctx = ctx;
        this.binding = binding;
    }


    @Override
    public void onChange(boolean selfChange) {
        this.onChange(selfChange, null);
    }

    @Override
    public void onChange(boolean selfChange, Uri uri) {
        // do s.th.
        // depending on the handler you might be on the UI
        // thread, so be cautious!

        if(uri.toString().contains(String.valueOf(DBContract.AllSymbols.CONTENT_URI))){
            SymbolName data = new SymbolName();
            data.setSymbolName(String.valueOf(uri));
            //here data must be an instance of the class MarsDataProvider
            binding.setSymbolPresenter(data);
        }

    }
}
