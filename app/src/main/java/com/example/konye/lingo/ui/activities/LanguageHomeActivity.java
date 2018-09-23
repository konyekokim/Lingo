package com.example.konye.lingo.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.konye.lingo.adapters.DrawerAdapter;
import com.example.konye.lingo.utils.DrawerClass;
import com.example.konye.lingo.R;

import java.util.ArrayList;

import io.netopen.hotbitmapgg.library.view.RingProgressBar;

public class LanguageHomeActivity extends AppCompatActivity {

    private ActionBarDrawerToggle actionBarDrawerToggle;
    RingProgressBar languageProgressBar, stageOneProgCircle, stageTwoProgCircle, stageThreeProgCircle;
    TextView progressTv, stageOneTv, stageTwoTv, stageThreeTv;
    private ListView drawerListView;
    int progressInLanguage = 70;
    String progressInLanguageString;

    ImageView nameOfLanguage;
    boolean progressShowing;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_home);
        //changeWidgetsFont();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.lang_action_bar_layout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TextView actionBarTextView = findViewById(R.id.my_text);
        actionBarTextView.setText(String.valueOf("TimeLine"));


        final DrawerLayout drawerLayout = findViewById(R.id.timeline_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        progressInLanguageString = Integer.toString(progressInLanguage);
        nameOfLanguage = findViewById(R.id.name_of_language);
        progressTv = findViewById(R.id.progress_textView);
        stageOneTv = findViewById(R.id.stage_1_textView);
        stageTwoTv = findViewById(R.id.stage_2_textView);
        stageThreeTv = findViewById(R.id.stage_3_textView);
        languageProgressBar = findViewById(R.id.language_progress_circle);
        stageOneProgCircle = findViewById(R.id.stage_1_progress_circle);
        stageTwoProgCircle = findViewById(R.id.stage_2_progress_circle);
        stageThreeProgCircle = findViewById(R.id.stage_3_progress_circle);
        languageProgressBar.setProgress(progressInLanguage);
        stageOneProgCircle.setProgress(80);
        stageTwoProgCircle.setProgress(70);
        stageThreeProgCircle.setProgress(80);
        nameOfLanguage.setImageResource(R.drawable.english_learn);
        // get ListView defined in activity_main.xml
        drawerListView = findViewById(R.id.left_drawer);
        // Set the adapter for the list view
        DrawerAdapter drawerAdapter = new DrawerAdapter(getApplicationContext(),R.layout.drawer_listview_item,
                drawerClasses());
        drawerListView.setAdapter(drawerAdapter);
        drawerListView.setOnItemClickListener((parent, view, position, id) -> {
            switch(position){
                case 0:
                    drawerLayout.closeDrawer(drawerListView);
                    //collect english data from API and show on widgets
                    break;
                case 1:
                    drawerLayout.closeDrawer(drawerListView);
                    //collect french data from API and show on widgets
                    break;
                case 2:
                    drawerLayout.closeDrawer(drawerListView);
                    //collect yoruba data from API and show on widgets
                    break;
                case 3:
                    drawerLayout.closeDrawer(drawerListView);
                    //collect igbo data from API and show on widgets
                    break;
                case 4:
                    drawerLayout.closeDrawer(drawerListView);
                    //collect hausa data from API and show on widgets
                    break;
                case 5:
                    drawerLayout.closeDrawer(drawerListView);
                    //collect efik data from API and show on widgets
                    break;
            }
        });
        progressTv.setOnClickListener(v -> {
            progressShowing = !progressShowing;
            progressTv.setText(progressShowing? progressInLanguageString + "%": "Tap to see your progress");
        });
        stageOneTv.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),LanguageActivity.class);
            startActivity(intent);
            finish();
        });
        stageTwoTv.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),LanguageActivity.class);
            startActivity(intent);
            finish();
        });
        stageThreeTv.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),LanguageActivity.class);
            startActivity(intent);
            finish();
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private ArrayList<DrawerClass> drawerClasses(){
        ArrayList<DrawerClass> drawerClassArrayList = new ArrayList<>();
        drawerClassArrayList.add(new DrawerClass("English",45));
        drawerClassArrayList.add(new DrawerClass("French",50));
        drawerClassArrayList.add(new DrawerClass("Yoruba",35));
        drawerClassArrayList.add(new DrawerClass("Igbo",50));
        drawerClassArrayList.add(new DrawerClass("Hausa",45));
        drawerClassArrayList.add(new DrawerClass("Efik",63));
        return drawerClassArrayList;
    }
}
