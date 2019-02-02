package com.celsius.customstocks.iterfaces;

import com.celsius.customstocks.BaseActivity;
import com.celsius.customstocks.datamodels.Symbol;
import com.celsius.customstocks.dbhelper.Provider;
import com.celsius.customstocks.fragments.BaseFragment;
import com.celsius.customstocks.fragments.SearchFragment;
import com.celsius.customstocks.modules.ContextModule;
import com.celsius.customstocks.modules.DBContentObserverModule;
import com.celsius.customstocks.modules.DatabaseModule;
import com.celsius.customstocks.network.NetworkHTTPRequests;
import com.celsius.customstocks.services.PullDataFromIEXService;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules={ContextModule.class,DatabaseModule.class, DBContentObserverModule.class})
public interface CustomStocksComponents {
    void inject(BaseActivity presenter);
    void inject(Provider presenter);
    void inject(PullDataFromIEXService presenter);
    void inject(BaseFragment presenter);
    void inject(Symbol presenter);
    void inject(NetworkHTTPRequests presenter);
    void inject(SearchFragment presenter);

}
