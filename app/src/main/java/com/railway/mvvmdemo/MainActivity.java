package com.railway.mvvmdemo;

import android.databinding.DataBindingUtil;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.railway.mvvmdemo.base.BaseActivity;
import com.railway.mvvmdemo.component.ActivityAppComponent;
import com.railway.mvvmdemo.databinding.ActivityMainBinding;
import com.railway.mvvmdemo.ui.viewmodel.MainViewModel;

import java.util.HashMap;

public class MainActivity extends BaseActivity<MainViewModel> {


    private ActivityMainBinding mBinding;

    @Override
    protected void initDataBinding() {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }

    @Override
    public void inject(ActivityAppComponent activityComponent) {
        activityComponent.inject(this);
    }


    public void mvvm(View view) {
        HashMap<String, String> params = new HashMap<>();
        params.put("type", "android");
        mViewModel.mvvm(params, mBinding);
    }

    private long firstTime;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            long secondTime = System.currentTimeMillis();
            if (secondTime - firstTime > 1500) {// 如果两次按键时间间隔大于800毫秒，则不退出
                Toast.makeText(getApplicationContext(), "再按一次退出程序",
                        Toast.LENGTH_SHORT).show();
                firstTime = secondTime;// 更新firstTime
                return true;
            } else {
                AppManager.getAppManager().AppExit(this, false);
            }
        }
        return super.onKeyDown(keyCode, event);
    }

}
