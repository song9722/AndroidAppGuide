package com.limlab.kotlinsample;

import android.app.Application;
import android.content.Context;

public class MainApplication extends Application {
    private static Context applicationContext;

    public static Context getAppContext() {
        return applicationContext;
    }

    // 앱이 최초실행될때 호출된다.
    public void onCreate() {
        super.onCreate();

        applicationContext = getApplicationContext();
    }
}
