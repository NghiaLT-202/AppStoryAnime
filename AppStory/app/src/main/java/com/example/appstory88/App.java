package com.example.appstory88;


import android.app.Application;


import com.example.appstory88.utils.MyDebugTree;

import timber.log.Timber;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initLog();
    }

    private void initLog() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new MyDebugTree());
        }
    }


}
