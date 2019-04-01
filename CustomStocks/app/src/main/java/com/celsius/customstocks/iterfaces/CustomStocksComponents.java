package com.celsius.customstocks.iterfaces;

import com.celsius.customstocks.BaseActivity;
import com.celsius.customstocks.datamodels.Earning;
import com.celsius.customstocks.datamodels.Financial;
import com.celsius.customstocks.datamodels.Market;
import com.celsius.customstocks.datamodels.VolumeByVenue;
import com.celsius.customstocks.datamodels.Quote;
import com.celsius.customstocks.datamodels.Symbol;
import com.celsius.customstocks.dbhelper.Provider;
import com.celsius.customstocks.fragments.BaseFragment;
import com.celsius.customstocks.fragments.SearchFragment;
import com.celsius.customstocks.modules.ContextModule;
import com.celsius.customstocks.modules.DBContentObserverModule;
import com.celsius.customstocks.modules.DatabaseModule;
import com.celsius.customstocks.network.NetworkHTTPRequests;
import com.celsius.customstocks.services.PullChartDataFromIEXService;
import com.celsius.customstocks.services.PullEarningsDataFromIEXService;
import com.celsius.customstocks.services.PullFinancialsDataFromIEXService;
import com.celsius.customstocks.services.PullMarketsDataFromIEXService;
import com.celsius.customstocks.services.PullVoleumeByVenueDataFromIEXService;
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
    void inject(PullVoleumeByVenueDataFromIEXService presenter);
    void inject(PullEarningsDataFromIEXService presenter);
    void inject(PullFinancialsDataFromIEXService presenter);
    void inject(PullChartDataFromIEXService presenter);
    void inject(BaseFragment presenter);
    void inject(Symbol presenter);
    void inject(Market presenter);
    void inject(Quote presenter);
    void inject(VolumeByVenue presenter);
    void inject(Earning presenter);
    void inject(Financial presenter);
    void inject(NetworkHTTPRequests presenter);
    void inject(SearchFragment presenter);

}
