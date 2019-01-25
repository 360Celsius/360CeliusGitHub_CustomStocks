package com.celsius.customstocks.recivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.celsius.customstocks.MainActivity;
import com.celsius.customstocks.utils.ReciverServiceConsts;

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
        }
    }
}
