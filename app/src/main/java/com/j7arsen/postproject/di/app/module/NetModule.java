package com.j7arsen.postproject.di.app.module;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.j7arsen.data.api.Environment;
import com.j7arsen.data.api.ITestApi;
import com.j7arsen.postproject.di.app.AppScope;
import com.j7arsen.postproject.di.app.ApplicationContext;
import com.j7arsen.postproject.utils.AppUtils;
import com.j7arsen.postproject.utils.ResUtils;
import com.j7arsen.postproject.utils.error.ErrorHandler;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = {TestOkHttpClientModule.class, TestOkHttpClientModule.class})
public class NetModule {

    @AppScope
    @Provides
    public ITestApi provideITestApiService(Retrofit retrofit) {
        return retrofit.create(ITestApi.class);
    }

    @AppScope
    @Provides
    public ErrorHandler provideErrorHandler(@ApplicationContext Context context, ResUtils utils, AppUtils appUtils) {
        return new ErrorHandler(context, utils, appUtils);
    }

    @AppScope
    @Provides
    public Retrofit provideRetrofit(OkHttpClient okHttpClient, GsonConverterFactory gsonConverterFactory) {
        return new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(Environment.BASE_URL)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(initCallAdapterFactory())
                .build();
    }

    @AppScope
    @Provides
    public Gson gson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setLenient();
        gsonBuilder.enableComplexMapKeySerialization();
        gsonBuilder.serializeNulls();
        gsonBuilder.setPrettyPrinting();
        gsonBuilder.setVersion(1.0);
        return gsonBuilder.create();
    }

    @AppScope
    @Provides
    public GsonConverterFactory gsonConverterFactory(Gson gson) {
        return GsonConverterFactory.create(gson);
    }

    @AppScope
    @Provides
    public CallAdapter.Factory initCallAdapterFactory() {
        return RxJava2CallAdapterFactory.create();
    }

}
