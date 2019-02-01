package com.celsius.customstocks;

import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import com.celsius.customstocks.application.CustomStockApplication;
import com.celsius.customstocks.dbhelper.DBHelper;
import com.celsius.customstocks.iterfaces.DbHelperInterface;
import com.celsius.customstocks.iterfaces.UtilsInterface;
import com.celsius.customstocks.recivers.ServiceBroadCastReciver;
import com.celsius.customstocks.utils.ReciverServiceConsts;
import com.celsius.customstocks.utils.Utils;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class BaseActivity extends AppCompatActivity implements DbHelperInterface, UtilsInterface {

    @Inject
    DBHelper helper;

    public static Utils utils = null;
    private ServiceBroadCastReciver receiver = null;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Window window = getWindow();

        // clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        // finally change the color
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.splash_activity_bg));
        }


        CustomStockApplication.getMyComponent().inject(this);
        utils = Utils.getInstance();
    }

    @Override
    protected void onResume() {
        super.onResume();

        IntentFilter filter = new IntentFilter(ReciverServiceConsts.GET_QOUTES_DATA);
        receiver =  ServiceBroadCastReciver.getInstance();
        registerReceiver(receiver, filter);
    }

    @Override
    protected void onStop() {
        unregisterReceiver(receiver);
        super.onStop();
    }

    @Override
    public DBHelper getDataBasehelper() {
        return helper;
    }

    @Override
    public Utils getUtils() {
        return utils;
    }

}
