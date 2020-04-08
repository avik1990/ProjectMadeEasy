package com.projectmadeeasy.app.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class Session {

    public static String get_userName(Context mContext) {
        SharedPreferences loginPreferences = mContext.getSharedPreferences("projectmadeeasy", 0); // 0 - for private mode
        String a_key = loginPreferences.getString("userName", "0");
        return a_key;
    }

    public static void set_userName(Context mContext, String value) {
        SharedPreferences preferences = mContext.getSharedPreferences("projectmadeeasy", 0); // 0 - for private mode
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("userName", value);
        editor.commit();
    }


    public static boolean getisLogged(Context mContext) {
        SharedPreferences loginPreferences = mContext.getSharedPreferences("projectmadeeasy", 0); // 0 - for private mode
        boolean a_key = loginPreferences.getBoolean("isLogged", false);
        return a_key;
    }

    public static void setisLogged(Context mContext, boolean avalue) {
        SharedPreferences preferences = mContext.getSharedPreferences("projectmadeeasy", 0); // 0 - for private mode
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("isLogged", avalue);
        editor.commit();
    }


    public static boolean getisProfile(Context mContext) {
        SharedPreferences loginPreferences = mContext.getSharedPreferences("projectmadeeasy", 0); // 0 - for private mode
        boolean a_key = loginPreferences.getBoolean("isProfile", false);
        return a_key;
    }

    public static void setisProfile(Context mContext, boolean avalue) {
        SharedPreferences preferences = mContext.getSharedPreferences("projectmadeeasy", 0); // 0 - for private mode
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("isProfile", avalue);
        editor.commit();
    }
}
