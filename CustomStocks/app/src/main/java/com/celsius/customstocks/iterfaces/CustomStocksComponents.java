package com.celsius.customstocks.iterfaces;

import com.celsius.customstocks.BaseActivity;
import com.celsius.customstocks.dbhelper.Provider;
import com.celsius.customstocks.modules.ContextModule;
import com.celsius.customstocks.modules.DatabaseModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules={ContextModule.class})
public interface CustomStocksComponents {
    void inject(BaseActivity presenter);

}
