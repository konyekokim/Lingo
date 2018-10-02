package com.mahadum360.mahadum.ui.activities;

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

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;
import com.mahadum360.mahadum.R;
import com.mahadum360.mahadum.utils.YoutubeVideoIDs;

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

        youTubeThumbnailView.setOnClickListener(v -> {
            Intent intent1 = new Intent(getApplicationContext(),VideoPlayActivity.class);
            intent1.putExtra(VIDEO_INDEX,languageVideoIndex);
            startActivity(intent1);
            finish();
        });
        descTextView.setOnClickListener(v -> {
            //expand and make the video description show...
            descIsExpanded = !descIsExpanded;
            vidsDescTextView.setVisibility(descIsExpanded? View.VISIBLE: View.GONE);
            vidsDescImg1.setImageResource(descIsExpanded?
                    R.mipmap.ic_keyboard_arrow_up_black_24dp: R.mipmap.ic_keyboard_arrow_down_black_24dp);
        });
        morevidsTextView.setOnClickListener(v -> {
            //expand and make the option for more videos show...
            moreVidsExpanded = !moreVidsExpanded;
            moreVidsLayout.setVisibility(moreVidsExpanded? View.VISIBLE: View.GONE);
            vidsDescImg2.setImageResource(descIsExpanded?
                    R.mipmap.ic_keyboard_arrow_up_black_24dp: R.mipmap.ic_keyboard_arrow_down_black_24dp);
        });

        vidsDescImg1.setOnClickListener(v -> {
            descIsExpanded = !descIsExpanded;
            vidsDescTextView.setVisibility(descIsExpanded? View.VISIBLE: View.GONE);
            vidsDescImg1.setImageResource(descIsExpanded?
                    R.mipmap.ic_keyboard_arrow_up_black_24dp: R.mipmap.ic_keyboard_arrow_down_black_24dp);
        });
        vidsDescImg2.setOnClickListener(v -> {
            moreVidsExpanded = !moreVidsExpanded;
            moreVidsLayout.setVisibility(moreVidsExpanded? View.VISIBLE: View.GONE);
            vidsDescImg2.setImageResource(moreVidsExpanded?
                    R.mipmap.ic_keyboard_arrow_up_black_24dp: R.mipmap.ic_keyboard_arrow_down_black_24dp);
        });
        moreVidsthumb1.setOnClickListener(v -> {
            Intent intent12 = new Intent(getApplicationContext(), VideoPlayActivity.class);
            intent12.putExtra(VIDEO_INDEX,languageVideoIndex);
            startActivity(intent12);
        });
        moreVidsthumb2.setOnClickListener(v -> {
            Intent intent13 = new Intent(getApplicationContext(), VideoPlayActivity.class);
            intent13.putExtra(VIDEO_INDEX,languageVideoIndex);
            startActivity(intent13);
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
        }

        @Override
        public void onThumbnailError(YouTubeThumbnailView thumbnail,
                                     YouTubeThumbnailLoader.ErrorReason reason) {
        }
    }

}
