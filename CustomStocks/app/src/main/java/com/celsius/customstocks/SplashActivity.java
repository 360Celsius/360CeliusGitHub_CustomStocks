package com.celsius.customstocks;

import android.content.Intent;
import android.os.Bundle;
import com.celsius.customstocks.services.PullDataFromIEXService;
import com.celsius.customstocks.services.PullDataFromIEXServiceConsts;

import androidx.annotation.Nullable;


public class SplashActivity extends BaseActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Intent intent = new Intent(this, PullDataFromIEXService.class);
        intent.putExtra(PullDataFromIEXServiceConsts.DATA_TYPE_KEY,PullDataFromIEXServiceConsts.GET_ALL_SYMBOLS);
        this.startService(intent);

        Intent myIntent = new Intent(this, MainActivity.class);
        this.startActivity(myIntent);
    }

}
