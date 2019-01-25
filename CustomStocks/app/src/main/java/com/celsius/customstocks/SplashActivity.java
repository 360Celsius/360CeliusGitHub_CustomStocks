package com.celsius.customstocks;

import android.content.Intent;
import android.os.Bundle;
import com.celsius.customstocks.services.PullDataFromIEXService;
import com.celsius.customstocks.utils.ReciverServiceConsts;

import androidx.annotation.Nullable;


public class SplashActivity extends BaseActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Intent intent = new Intent(this, PullDataFromIEXService.class);
        intent.putExtra(ReciverServiceConsts.DATA_TYPE_KEY, ReciverServiceConsts.GET_ALL_SYMBOLS);
        this.startService(intent);

    }

}
