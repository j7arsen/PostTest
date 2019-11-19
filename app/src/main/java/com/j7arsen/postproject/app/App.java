package com.j7arsen.postproject.app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.j7arsen.postproject.di.ComponentManager;

public class App extends Application {

    public static App mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        Fresco.initialize(this);
        ComponentManager.getInstance().initAppComponent();
    }
}
