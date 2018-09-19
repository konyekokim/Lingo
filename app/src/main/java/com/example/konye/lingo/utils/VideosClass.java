package com.example.konye.lingo.utils;

/**
 * Created by KONYE on 5/18/2017.
 */

public class VideosClass {

    private String videosTitle, videosSubtitle;
    private int imgThumbnail;
    public VideosClass(String videosTitle, String videosSubtitle, int imgThumbnail){
        this.videosTitle = videosTitle;
        this.videosSubtitle = videosSubtitle;
        this.imgThumbnail = imgThumbnail;
    }
    public String getVideosTitle(){
        return videosTitle;
    }
    public String getVideosSubtitle(){
        return videosSubtitle;
    }
    public int getImgThumbnail(){
        return imgThumbnail;
    }
}
