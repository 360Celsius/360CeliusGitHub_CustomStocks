package com.celsius.customstocks;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.celsius.customstocks.services.PullSymbolsDataFromIEXService;
import com.celsius.customstocks.utils.ReciverServiceConsts;

import androidx.annotation.Nullable;


public class SplashActivity extends BaseActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if(helper.getAllSymbolsTableRowCount()<8000) {
            Intent intent = new Intent(this, PullSymbolsDataFromIEXService.class);
            intent.putExtra(ReciverServiceConsts.DATA_TYPE_KEY, ReciverServiceConsts.GET_ALL_SYMBOLS);
            this.startService(intent);
        }else{

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    //Do something after 100ms
                    Intent intentone = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intentone);
                }
            }, 2000);
        }

    }

}
