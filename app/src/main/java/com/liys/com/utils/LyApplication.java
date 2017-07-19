package com.liys.com.utils;

import android.app.Application;

/**
 * Created by liys
 * @time 2017-07-19.
 */

public class LyApplication extends Application {
    private static LyApplication lyApplication;
    @Override
    public void onCreate() {
        super.onCreate();
        lyApplication = this;
        DaoManager.getInstance();
    }
    public static LyApplication getLyApplication(){
        return lyApplication;
    }
}
