package com.example.konye.lingo.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by KONYE on 5/11/2017.
 */
//to check if the app has been opened before so it wont show the slide show again.
public class SlideManager {
    private static final String CHECK_FIRST ="com.example.konye.lingo.check_first";
    private Context context;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    public SlideManager(Context context){
        this.context = context;
        preferences = context.getSharedPreferences("first",0);
        editor = preferences.edit();
    }

    public void setFirst(Boolean isFirst){
        editor.putBoolean(CHECK_FIRST,isFirst);
        editor.commit();
    }

    public boolean check(){
        return preferences.getBoolean(CHECK_FIRST,true);
    }

}
