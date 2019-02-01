package com.celsius.customstocks.modules;

import android.content.Context;
import javax.inject.Named;
import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {
    private Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Provides
    @Named("ApplicationContext")
    public Context getContext() {
        return context;
    }
}
