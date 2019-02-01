package com.celsius.customstocks.modules;

import com.celsius.customstocks.dbhelper.DBHelper;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DatabaseModule {
    private DBHelper dbImpl;

    @Inject
    public DatabaseModule(DBHelper myDB) {
        this.dbImpl = myDB;
    }

    @Provides
    @Singleton
    public DBHelper getDatabase() {
        return dbImpl;
    }
}
