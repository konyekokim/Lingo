package com.example.konye.lingo;

/**
 * Created by KONYE on 5/15/2017.
 */

public class LanguageClass {

    private String languageName;
    public enum Languages{ENGLAND, FRANCE, NIGERIA}

    Languages languages;

    public LanguageClass(String languageName, Languages languages){
        this.languageName = languageName;
        this.languages = languages;
    }

    public void setLanguageName(String languageName){
        this.languageName = languageName;
    }
    public void setLanguages(Languages languages){
        this.languages = languages;
    }
    public String getLanguageName(){
        return languageName;
    }
    public Languages getLanguages(){
        return languages;
    }
    public int getRelatedDrawable(){
        switch(getLanguages()){
            case ENGLAND:
                return R.drawable.canada;
            case FRANCE:
                return R.drawable.france;
            case NIGERIA:
                return R.drawable.nigeria;
            default:
                return R.drawable.nigeria;
        }
    }
}
