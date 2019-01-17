package com.railway.mvvmdemo.base;

import android.widget.Toast;

import com.railway.mvvmdemo.App;
import com.railway.mvvmdemo.component.ActivityAppComponent;
import com.railway.mvvmdemo.component.DaggerActivityAppComponent;
import com.railway.mvvmdemo.inject.module.ActivityModule;
import com.railway.mvvmdemo.inject.module.ApiModule;

import javax.inject.Inject;


public abstract class BaseActivity<T extends BaseViewModel> extends SimpleActivity implements BaseView {
    @Inject
    protected T mViewModel;

    @Override
    protected void init() {
        super.init();
        ActivityAppComponent activityAppComponent = DaggerActivityAppComponent
                .builder()
                .activityModule(new ActivityModule(this))
                .apiModule(new ApiModule(App.getContext()))
                .build();
        inject(activityAppComponent);
        if (mViewModel != null)
            mViewModel.attachView(this);

    }


    /**
     * 注入
     */
    public abstract void inject(ActivityAppComponent activityComponent);

    @Override
    protected void onDestroy() {
        if (mViewModel != null)
            mViewModel.detachView();
        super.onDestroy();
    }


    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

}
