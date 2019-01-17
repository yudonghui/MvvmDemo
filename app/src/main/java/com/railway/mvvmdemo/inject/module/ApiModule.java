package com.railway.mvvmdemo.inject.module;

import android.content.Context;

import com.railway.mvvmdemo.inject.service.ApiService;

import dagger.Module;
import dagger.Provides;

@Module
public class ApiModule extends BaseModule {
    public ApiModule(Context application) {
        super(application);
    }

    @Provides
    public ApiService provideApiService() {
        return mRetrofit.create(ApiService.class);
    }
}
