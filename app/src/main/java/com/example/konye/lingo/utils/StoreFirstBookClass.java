package com.example.konye.lingo.utils;

/**
 * Created by KONYE on 7/25/2017.
 */

public class StoreFirstBookClass {
    private int firstBookImageResource;

    public StoreFirstBookClass(int categoryImageResource){
        this.firstBookImageResource = categoryImageResource;
    }

    public int getFirstBookImageResource(){
        return firstBookImageResource;
    }
}
