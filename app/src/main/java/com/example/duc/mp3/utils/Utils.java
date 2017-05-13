package com.example.duc.mp3.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DUC on 30/11/2016.
 */

public class Utils {
    public static int GetIdByName(String name, Context context){
        Resources res = context.getResources();
        return res.getIdentifier(name,"drawable",context.getPackageName());
    }

    public static int findIndexMax(ArrayList<Integer> arr){
        int max = 0;
        for(int i  = 0; i < arr.size(); i ++){
            if(arr.get(i) > max){
                 max = arr.get(i);
            }
        }
        for(int i = 0; i < arr.size(); i ++){
            if(arr.get(i) == max)   return i;
        }
        return 0;

    }
}

