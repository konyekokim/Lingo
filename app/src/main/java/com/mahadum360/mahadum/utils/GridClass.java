package com.mahadum360.mahadum.utils;


/**
 * Created by ALPHA AND JAM on 12/7/2017.
 */

public class GridClass {
    private int PicInt;
    private String name;
    public GridClass(int PicInt, String name){
        this.PicInt = PicInt;
        this.name = name;
    }
    public void setPicInt(int PicInt){
        this.PicInt = PicInt;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getPicInt(){
        return PicInt;
    }
    public String getName(){
        return name;
    }
}
