package com.railway.mvvmdemo.ui.viewmodel;

import android.util.Log;
import android.widget.Toast;

import com.railway.mvvmdemo.MainActivity;
import com.railway.mvvmdemo.base.BaseViewModel;
import com.railway.mvvmdemo.common.CommonSubscriber;
import com.railway.mvvmdemo.databinding.ActivityMainBinding;
import com.railway.mvvmdemo.ui.bean.VersionInfo;
import com.railway.mvvmdemo.ui.model.MainModel;
import com.railway.mvvmdemo.utils.ApiException;

import java.util.HashMap;

import javax.inject.Inject;

public class MainViewModel extends BaseViewModel<MainActivity, MainModel> {
    @Inject
    public MainViewModel() {
        Log.e("创建了: ", "MainPresenter");
    }
    public void mvvm(HashMap<String, String> params, final ActivityMainBinding mBinding) {

        mView.showLoadingDialog();
        mModel.mvvm(params, new CommonSubscriber<VersionInfo>() {
            @Override
            public void getData(VersionInfo versionInfo) {
                mView.cancelLoadingDialog();
                mBinding.setVersionInfo(versionInfo);
            }

            @Override
            public void error(ApiException e) {
                Toast.makeText(mView, e.getMsg(), Toast.LENGTH_SHORT).show();
                mView.cancelLoadingDialog();
            }
        });
    }

}
