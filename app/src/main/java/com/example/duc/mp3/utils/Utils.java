package com.example.duc.mp3.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

/**
 * Created by DUC on 30/11/2016.
 */

public class Utils {
    public static int GetIdByName(String name, Context context){
        Resources res = context.getResources();
        return res.getIdentifier(name,"drawable",context.getPackageName());
    }
}

