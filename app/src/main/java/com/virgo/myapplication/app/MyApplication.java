package com.virgo.myapplication.app;

import android.app.Application;

/**
 * Created by Administrator on 2017/2/24.
 */
public class MyApplication extends Application{
    private static MyApplication mAppCtx;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppCtx = this;
    }

    // 单例模式中获取唯一的MyApplication实例
    public static MyApplication getContext() {
        if (null == mAppCtx) {
            mAppCtx = new MyApplication();
        }
        return mAppCtx;
    }

}
