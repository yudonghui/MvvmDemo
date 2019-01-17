package com.railway.mvvmdemo.base;

import javax.inject.Inject;

public class BaseViewModel<T extends BaseView, V extends BaseModel> {
    @Inject
    protected V mModel;

    protected T mView;

    public BaseViewModel() {
    }

    public void attachView(T view) {
        this.mView = view;
    }

    public void detachView() {

    }
}
