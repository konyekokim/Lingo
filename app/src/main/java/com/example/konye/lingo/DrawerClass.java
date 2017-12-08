package com.example.konye.lingo;

import android.graphics.Color;

/**
 * Created by KONYE on 7/6/2017.
 */

public class DrawerClass {

    private String languageTitle;
    private int progress;
    public DrawerClass(String languageTitle, int progress){
        this.languageTitle = languageTitle;
        this.progress = progress;
    }
    public String getlanguageTitle(){
        return languageTitle;
    }
    public int getProgress(){
        return progress;
    }
}
