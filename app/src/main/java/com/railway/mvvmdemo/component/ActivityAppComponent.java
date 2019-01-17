package com.railway.mvvmdemo.component;


import com.railway.mvvmdemo.MainActivity;
import com.railway.mvvmdemo.inject.module.ActivityModule;
import com.railway.mvvmdemo.inject.module.ApiModule;

import dagger.Component;

@Component(modules = {ActivityModule.class, ApiModule.class})
public interface ActivityAppComponent {
    void inject(MainActivity mainActivity);
}
