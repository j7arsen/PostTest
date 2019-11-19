package com.j7arsen.postproject.di.app.module;

import android.content.Context;

import com.j7arsen.postproject.di.app.AppScope;
import com.j7arsen.postproject.di.app.ApplicationContext;
import com.j7arsen.postproject.utils.AppUtils;
import com.j7arsen.postproject.utils.ResUtils;

import dagger.Module;
import dagger.Provides;

@Module
public class UtilsModule {

    @AppScope
    @Provides
    public ResUtils provideResUtils(@ApplicationContext Context context) {
        return new ResUtils(context);
    }

    @AppScope
    @Provides
    public AppUtils provideUtils() {
        return new AppUtils();
    }

}
