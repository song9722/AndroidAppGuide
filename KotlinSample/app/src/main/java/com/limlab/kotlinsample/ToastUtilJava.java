package com.limlab.kotlinsample;

import android.widget.Toast;

import static com.limlab.kotlinsample.MainApplication.getAppContext;

public class ToastUtilJava {
    public static void toastShort(String message) {
        Toast.makeText(getAppContext(), message, Toast.LENGTH_SHORT).show();
    }

    public static void toastLong(String message) {
        Toast.makeText(getAppContext(), message, Toast.LENGTH_LONG).show();
    }

    // 파라미터에 따라 긴 토스트메시지, 또는 짧은 토스트메시지를 보여준다.
    public static void toast(String message, int length) {
        Toast.makeText(getAppContext(), message, length).show();
    }

    public static void toast(String message) {
        toast(message, Toast.LENGTH_SHORT);
    }
}
