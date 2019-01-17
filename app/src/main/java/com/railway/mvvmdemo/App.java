package com.railway.mvvmdemo;

import android.app.Application;
import android.content.Context;

public class App extends Application {
    private static Context mContext;
    public static boolean ISLOG = true;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    public static Context getContext() {
        return mContext;
    }
}
