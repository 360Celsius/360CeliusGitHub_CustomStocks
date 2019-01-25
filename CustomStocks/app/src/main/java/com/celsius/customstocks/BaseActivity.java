package com.celsius.customstocks;

import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import com.celsius.customstocks.dbhelper.DBHelper;
import com.celsius.customstocks.iterfaces.DbHelperInterface;
import com.celsius.customstocks.iterfaces.UtilsInterface;
import com.celsius.customstocks.utils.Utils;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class BaseActivity extends AppCompatActivity implements DbHelperInterface, UtilsInterface {

    public static DBHelper helper = null;
    public static Utils utils = null;


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


        // In any activity just pass the context and use the singleton method
        helper = DBHelper.getInstance(getApplicationContext());
        utils = Utils.getInstance();
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
