package com.j7arsen.postproject.di.app;


import com.j7arsen.postproject.di.app.main.MainComponent;
import com.j7arsen.postproject.di.app.module.ContextModule;
import com.j7arsen.postproject.di.app.module.NetModule;
import com.j7arsen.postproject.di.app.module.ThreadingModule;
import com.j7arsen.postproject.di.app.module.UtilsModule;

import dagger.Component;

@AppScope
@Component(modules = {ContextModule.class, NetModule.class, ThreadingModule.class, UtilsModule.class})
public interface AppComponent {

    MainComponent.Builder mainComponentBuilder();

}