package com.example.duc.mp3.managers;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by DUC on 30/11/2016.
 */

public class Preferences {
    private static final String KEY = "mp3";
    private static final String INDEX_TOUCH_KEY = "Index";
    private static final String ID_TOUCH_KEY = "Id";
    private SharedPreferences sharedPreferences;

    public Preferences(Context context) {
        sharedPreferences = context.getSharedPreferences(KEY, Context.MODE_PRIVATE);
    }


    public int getIndexTouch() {
        return sharedPreferences.getInt(INDEX_TOUCH_KEY, 0);
    }

    public void putIndexTouch(int index) {
        sharedPreferences.edit().putInt(INDEX_TOUCH_KEY, index).commit();
    }

    public String getIDTouch() {
        return sharedPreferences.getString(ID_TOUCH_KEY, null);
    }

    public void putIDTouch(String id) {
        sharedPreferences.edit().putString(ID_TOUCH_KEY, id).commit();
    }


    private static Preferences instance;
    public static Preferences getInstance(){
        return instance;
    }

    public static void init(Context context){
        instance = new Preferences(context);
    }
}
