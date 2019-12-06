package com.example.edz.mvp.utils.util;

import android.util.Log;

/**
 *
 */

public class MyLog {
    public static void i(String tag, String message){
        if(MyDevice.isApkDebugable()){
            Log.i("MyAndroid", tag + ": \n   " + message);
            Log.i(tag, message + "");
        }
    }
    public static void d(String tag, String message){
        if(MyDevice.isApkDebugable()){
            Log.d("MyAndroid", tag + ": \n   " + message);
            Log.i(tag, message + "");
        }
    }
    public static void e(String tag, String message){
        if(MyDevice.isApkDebugable()){
            Log.e("MyAndroid", tag + ": \n   " + message);
            Log.e(tag, message + "");
        }
    }
}
