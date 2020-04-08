package com.projectmadeeasy.app.utils;

import android.content.Context;
import android.widget.Toast;

public class Utility {

    public static void showToast(Context ctx, String msg) {
        Toast.makeText(ctx, msg, Toast.LENGTH_SHORT).show();
    }

}
