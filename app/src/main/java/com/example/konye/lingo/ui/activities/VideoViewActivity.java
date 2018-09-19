package com.example.konye.lingo.ui.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.konye.lingo.R;
import com.example.konye.lingo.utils.YoutubeVideoIDs;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;

public class VideoViewActivity extends AppCompatActivity implements YouTubeThumbnailView.OnInitializedListener {

    public static final String API_KEY = "AIzaSyCMsPj30QmhI_rHijTrCaHBi9tAVswgABU";
    TextView titleTextView, descTextView, morevidsTextView, vidsDescTextView;
    ImageView moreVidsthumb1, moreVidsthumb2, youtubePlayBtn;
    ImageButton vidsDescImg1, vidsDescImg2;
    LinearLayout moreVidsLayout;
    String nameOfLanguage;
    String VIDEO_ID;
    int languageVideoIndex;
    boolean descIsExpanded, moreVidsExpanded;
    public static final String VIDEO_INDEX = "com.example.konye.lingo video_index";
    YoutubeVideoIDs youtubeVideoIDs;
    private ProgressDialog progressDialog;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //changeWidgetsFont();
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.lang_action_bar_layout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TextView actionBarTextView = findViewById(R.id.my_text);
        actionBarTextView.setText(String.valueOf("Video"));
        Intent intent = getIntent();
        languageVideoIndex = intent.getIntExtra(LanguageActivity.LANGUAGE_VIDEO_INDEX, 0);
        youtubeVideoIDs = new YoutubeVideoIDs();
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        titleTextView = findViewById(R.id.video_view_title);
        descTextView = findViewById(R.id.video_desc_text);
        morevidsTextView = findViewById(R.id.more_videos_text_view);
        vidsDescTextView = findViewById(R.id.vids_desc_text_view);
        moreVidsthumb1 = findViewById(R.id.more_video_1);
        moreVidsthumb2 = findViewById(R.id.more_video_2);
        vidsDescImg1 = findViewById(R.id.expand_button);
        vidsDescImg2 = findViewById(R.id.expand_buttn_more_videos);
        moreVidsLayout = findViewById(R.id.more_vids_layout);
        youtubePlayBtn = findViewById(R.id.youtube_play_btn);
        youtubePlayBtn.setVisibility(View.GONE);
        YouTubeThumbnailView youTubeThumbnailView = findViewById(R.id.youtube_thumbnail_view);
        youTubeThumbnailView.initialize(API_KEY,this);

        youTubeThumbnailView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),VideoPlayActivity.class);
                intent.putExtra(VIDEO_INDEX,languageVideoIndex);
                startActivity(intent);
                finish();
            }
        });
        descTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //expand and make the video description show...
                descIsExpanded = !descIsExpanded;
                vidsDescTextView.setVisibility(descIsExpanded? View.VISIBLE: View.GONE);
                vidsDescImg1.setImageResource(descIsExpanded?
                        R.mipmap.ic_keyboard_arrow_up_black_24dp: R.mipmap.ic_keyboard_arrow_down_black_24dp);
            }
        });
        morevidsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //expand and make the option for more videos show...
                moreVidsExpanded = !moreVidsExpanded;
                moreVidsLayout.setVisibility(moreVidsExpanded? View.VISIBLE: View.GONE);
                vidsDescImg2.setImageResource(descIsExpanded?
                        R.mipmap.ic_keyboard_arrow_up_black_24dp: R.mipmap.ic_keyboard_arrow_down_black_24dp);
            }
        });

        vidsDescImg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                descIsExpanded = !descIsExpanded;
                vidsDescTextView.setVisibility(descIsExpanded? View.VISIBLE: View.GONE);
                vidsDescImg1.setImageResource(descIsExpanded?
                        R.mipmap.ic_keyboard_arrow_up_black_24dp: R.mipmap.ic_keyboard_arrow_down_black_24dp);
            }
        });
        vidsDescImg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moreVidsExpanded = !moreVidsExpanded;
                moreVidsLayout.setVisibility(moreVidsExpanded? View.VISIBLE: View.GONE);
                vidsDescImg2.setImageResource(moreVidsExpanded?
                        R.mipmap.ic_keyboard_arrow_up_black_24dp: R.mipmap.ic_keyboard_arrow_down_black_24dp);
            }
        });
        moreVidsthumb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), VideoPlayActivity.class);
                intent.putExtra(VIDEO_INDEX,languageVideoIndex);
                startActivity(intent);
            }
        });
        moreVidsthumb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), VideoPlayActivity.class);
                intent.putExtra(VIDEO_INDEX,languageVideoIndex);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onInitializationFailure(YouTubeThumbnailView thumbnailView,
                                        YouTubeInitializationResult errorReason) {

        String errorMessage =
                String.format("onInitializationFailure (%1$s)",
                        errorReason.toString());
        Toast.makeText(this, "connection error...", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onInitializationSuccess(YouTubeThumbnailView thumbnailView,
                                        YouTubeThumbnailLoader thumbnailLoader) {

       // Toast.makeText(getApplicationContext(),
         //       "onInitializationSuccess", Toast.LENGTH_SHORT).show();
        YouTubeThumbnailLoader youTubeThumbnailLoader = thumbnailLoader;
        thumbnailLoader.setOnThumbnailLoadedListener(new ThumbnailListener());

        youTubeThumbnailLoader.setVideo(youtubeVideoIDs.English(languageVideoIndex));
        youtubePlayBtn.setVisibility(View.VISIBLE);
    }

    private final class ThumbnailListener implements
            YouTubeThumbnailLoader.OnThumbnailLoadedListener {

        @Override
        public void onThumbnailLoaded(YouTubeThumbnailView thumbnail, String videoId) {
            progressDialog.dismiss();
            //Toast.makeText(getApplicationContext(),
             //       "onThumbnailLoaded", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onThumbnailError(YouTubeThumbnailView thumbnail,
                                     YouTubeThumbnailLoader.ErrorReason reason) {
            //Toast.makeText(getApplicationContext(),
                  //  "onThumbnailError", Toast.LENGTH_SHORT).show();
        }
    }

    /*private void changeWidgetsFont(){
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Montserrat-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }*/

}
