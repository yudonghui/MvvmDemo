package com.railway.mvvmdemo.callback;


import okhttp3.ResponseBody;

public interface ResponseCallBack {
    void callBack(ResponseBody body);
    void complete();
}
