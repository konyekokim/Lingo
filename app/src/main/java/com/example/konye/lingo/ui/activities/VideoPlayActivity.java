package com.example.konye.lingo.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.konye.lingo.R;
import com.example.konye.lingo.utils.YoutubeVideoIDs;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer.ErrorReason;
import com.google.android.youtube.player.YouTubePlayer.PlaybackEventListener;
import com.google.android.youtube.player.YouTubePlayer.PlayerStateChangeListener;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView;


public class VideoPlayActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    public static final String API_KEY = "AIzaSyCMsPj30QmhI_rHijTrCaHBi9tAVswgABU";
    String VIDEO_ID;
    YoutubeVideoIDs youtubeVideoIDs;
    String nameOfLanguage;
    String english = "English";
    String french = "French";
    String hausa =  "Hausa";
    String igbo = "Igbo";
    String yoruba = "Yoruba";
    int videoIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_play);
        youtubeVideoIDs = new YoutubeVideoIDs();
        Intent intent = getIntent();
        //mahadumLanguageSelected = (LanguageListActivity.MahadumLanguageSelected)
         //       intent.getSerializableExtra(VideoViewActivity.LANGUAGE_SELECTED);
        videoIndex = intent.getIntExtra(VideoViewActivity.VIDEO_INDEX,0);

        //Initialize youtubePlayer view
        YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view);
        youTubePlayerView.initialize(API_KEY,this);
    }

    @Override
    public void onInitializationFailure(Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast showFailure = Toast.makeText(this, "Failed to initialize",Toast.LENGTH_LONG);
        showFailure.show();
    }

    @Override
    public void onInitializationSuccess(Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        youTubePlayer.setPlayerStateChangeListener(playerStateChangeListener);
        youTubePlayer.setPlaybackEventListener(playbackEventListener);

        //start buffering
        if(!b){
            youTubePlayer.cueVideo(youtubeVideoIDs.English(videoIndex));
        }
    }

    private PlaybackEventListener playbackEventListener = new PlaybackEventListener() {
        @Override
        public void onPlaying() {

        }

        @Override
        public void onPaused() {

        }

        @Override
        public void onStopped() {

        }

        @Override
        public void onBuffering(boolean b) {

        }

        @Override
        public void onSeekTo(int i) {

        }
    };

    private PlayerStateChangeListener playerStateChangeListener = new PlayerStateChangeListener() {
        @Override
        public void onLoading() {

        }

        @Override
        public void onLoaded(String s) {

        }

        @Override
        public void onAdStarted() {

        }

        @Override
        public void onVideoStarted() {

        }

        @Override
        public void onVideoEnded() {

        }

        @Override
        public void onError(ErrorReason errorReason) {

        }
    };

    private void playMatchedLangToVideoIndex(){
        if(nameOfLanguage.equals(english)){
            VIDEO_ID = youtubeVideoIDs.English(videoIndex);
        }
        if(nameOfLanguage.equals(french)){
            VIDEO_ID = youtubeVideoIDs.French(videoIndex);
        }
        if(nameOfLanguage.equals(hausa)){
            VIDEO_ID = youtubeVideoIDs.Hausa(videoIndex);
        }
        if(nameOfLanguage.equals(igbo)){
            VIDEO_ID = youtubeVideoIDs.Igbo(videoIndex);
        }
        if(nameOfLanguage.equals(yoruba)){
            VIDEO_ID = youtubeVideoIDs.Yoruba(videoIndex);
        }
    }

}
