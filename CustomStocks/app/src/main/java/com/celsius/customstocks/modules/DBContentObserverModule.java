package com.celsius.customstocks.modules;

import com.celsius.customstocks.contentobservers.DataBaseContentObserver;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DBContentObserverModule {

    private DataBaseContentObserver dataBaseContentObserver;

    @Inject
    public DBContentObserverModule(DataBaseContentObserver dataBaseContentObserver) {
        this.dataBaseContentObserver = dataBaseContentObserver;
    }

    @Provides
    @Singleton
    public DataBaseContentObserver getDataBaseContentObserver() {
        return dataBaseContentObserver;
    }
}
