package com.celsius.customstocks.iterfaces;

import com.celsius.customstocks.BaseActivity;
import com.celsius.customstocks.datamodels.Earning;
import com.celsius.customstocks.datamodels.Market;
import com.celsius.customstocks.datamodels.News;
import com.celsius.customstocks.datamodels.Quote;
import com.celsius.customstocks.datamodels.Symbol;
import com.celsius.customstocks.dbhelper.Provider;
import com.celsius.customstocks.fragments.BaseFragment;
import com.celsius.customstocks.fragments.SearchFragment;
import com.celsius.customstocks.modules.ContextModule;
import com.celsius.customstocks.modules.DBContentObserverModule;
import com.celsius.customstocks.modules.DatabaseModule;
import com.celsius.customstocks.network.NetworkHTTPRequests;
import com.celsius.customstocks.services.PullEarningsDataFromIEXService;
import com.celsius.customstocks.services.PullMarketsDataFromIEXService;
import com.celsius.customstocks.services.PullNewsDataFromIEXService;
import com.celsius.customstocks.services.PullStocksDataFromIEXService;
import com.celsius.customstocks.services.PullSymbolsDataFromIEXService;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules={ContextModule.class,DatabaseModule.class, DBContentObserverModule.class})
public interface CustomStocksComponents {
    void inject(BaseActivity presenter);
    void inject(Provider presenter);
    void inject(PullSymbolsDataFromIEXService presenter);
    void inject(PullMarketsDataFromIEXService presenter);
    void inject(PullStocksDataFromIEXService presenter);
    void inject(PullNewsDataFromIEXService presenter);
    void inject(PullEarningsDataFromIEXService presenter);
    void inject(BaseFragment presenter);
    void inject(Symbol presenter);
    void inject(Market presenter);
    void inject(Quote presenter);
    void inject(News presenter);
    void inject(Earning presenter);
    void inject(NetworkHTTPRequests presenter);
    void inject(SearchFragment presenter);

}
