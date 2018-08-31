package com.example.brand.carpool.utils;

import android.util.Log;

/*
 @ project: CarPool
 @ package: com.example.brand.carpool.utils
 @ file: L
 @ author : Jingliang Zhang (Brand)
 @ create time: 2018/8/29 1:06
 @ description: TODO
 */
public class L {
    // troggle
    public static final  boolean DEBUG = true;
    //TAG
    public static final String TAG = "Carpool";

    // five level  DIWE
    public static void d(String text){
        if(DEBUG){
            Log.d(TAG,text);
        }
    }

    public static void i(String text){
        if(DEBUG){
            Log.i(TAG,text);
        }
    }

    public static void w(String text){
        if(DEBUG){
            Log.w(TAG,text);
        }
    }

    public static void e(String text){
        if(DEBUG){
            Log.e(TAG,text);
        }
    }
}

