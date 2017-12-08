package com.example.konye.lingo;

/**
 * Created by KONYE on 5/18/2017.
 */

public class SlidesClass{

    private String slidesTitle, slidesSubtitle;
    private int imgThumbnail;
    public SlidesClass(String slidesTitle, String slidesSubtitle, int imgThumbnail){
        this.slidesTitle = slidesTitle;
        this.slidesSubtitle = slidesSubtitle;
        this.imgThumbnail = imgThumbnail;
    }
    public String getSlidesTitle(){
        return slidesTitle;
    }
    public String getSlidesSubtitle(){
        return slidesSubtitle;
    }
    public int getImgThumbnail(){
        return imgThumbnail;
    }
}
