package com.example.konye.lingo.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.*;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar;
import com.example.konye.lingo.R;
import com.example.konye.lingo.adapters.SlideVideoPagerAdapter;
import com.example.konye.lingo.ui.fragments.SlideFragment;
import com.example.konye.lingo.ui.fragments.VideoFragment;
import com.example.konye.lingo.ui.fragments.VideosFragment;
import com.example.konye.lingo.utils.SlidesClass;
import com.example.konye.lingo.utils.VideosClass;

import java.util.ArrayList;


public class LanguageActivity extends AppCompatActivity implements
        SlideFragment.OnFragmentInteractionListener, VideoFragment.OnFragmentInteractionListener{

    String nameOfLanguage;
    public static final String LANGUAGES_SELECTED = "com.example.konye.lingo language_selected";
    public static final String LANGUAGE_VIDEO_INDEX = "com.example.konye.lingo languagevideo_index";
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);
        //changeWidgetsFont();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.lang_action_bar_layout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TextView actionBarTextView = findViewById(R.id.my_text);
        actionBarTextView.setText(String.valueOf("Stage 1"));
        TextView progressTextView = findViewById(R.id.app_text_view);
        progressTextView.setText(String.valueOf("Your English Progress"));
        RoundCornerProgressBar langProgressBar = findViewById(R.id.lang_progress_bar);
        langProgressBar.setMax(100);
        langProgressBar.setProgress(50);
        langProgressBar.setScaleY(0.8f);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Slides"));
        tabLayout.addTab(tabLayout.newTab().setText("Videos"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = findViewById(R.id.slide_video_pager);
        final PagerAdapter pagerAdapter = new SlideVideoPagerAdapter(getSupportFragmentManager(),
                tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void onSlideClicked(int pos, ArrayList<SlidesClass> slides) {
        if(pos == slides.size()-1){
            Intent intent = new Intent(this,QuizViewActivity.class);
            startActivity(intent);
        }else {
            Intent intent = new Intent(this, SlideViewActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onVideoSelected(int pos, ArrayList<VideosClass> videos) {
        //this is just a test intent, put another intent when you are ready
        if(pos == videos.size()-1){
            Intent intent = new Intent(this,QuizViewActivity.class);
            startActivity(intent);
        }else{
            intent = new Intent(this,VideoViewActivity.class);
            intent.putExtra(LanguageActivity.LANGUAGE_VIDEO_INDEX, pos);
            startActivity(intent);
        }
    }
}
