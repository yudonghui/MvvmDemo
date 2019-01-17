package com.railway.mvvmdemo.ui.model;

import android.util.Log;

import com.railway.mvvmdemo.base.BaseModel;
import com.railway.mvvmdemo.common.CommonSubscriber;
import com.railway.mvvmdemo.common.HttpRxObservable;
import com.railway.mvvmdemo.inject.service.ApiService;
import com.railway.mvvmdemo.ui.bean.VersionInfo;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import java.util.HashMap;

import javax.inject.Inject;

import io.reactivex.Flowable;

public class MainModel extends BaseModel {
    private final RxAppCompatActivity mActivity;
    @Inject
    ApiService mApiService;

    @Inject
    public MainModel(RxAppCompatActivity activity) {
        mActivity = activity;
        Log.e("创建了: ", "MainModel");
    }

    public void mvvm(HashMap<String, String> params, CommonSubscriber<VersionInfo> subscriber) {
        Flowable<VersionInfo> userFlowable = mApiService.getVersionInfo(params);
        //被观察者
        Flowable observable = HttpRxObservable.getObservable(userFlowable, mActivity);
        observable.subscribe(subscriber);
    }
}
