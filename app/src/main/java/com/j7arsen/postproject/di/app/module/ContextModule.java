package com.j7arsen.postproject.di.app.module;

import android.content.Context;

import com.j7arsen.postproject.app.App;
import com.j7arsen.postproject.di.app.AppScope;
import com.j7arsen.postproject.di.app.ApplicationContext;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {

    private Context context;

    public ContextModule(){
        this.context = App.mInstance;
    }

    @AppScope
    @Provides
    @ApplicationContext
    public Context context(){ return context.getApplicationContext(); }

}
