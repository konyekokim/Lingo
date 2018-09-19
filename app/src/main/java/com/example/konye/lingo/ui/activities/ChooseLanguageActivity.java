package com.example.konye.lingo.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.konye.lingo.R;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class ChooseLanguageActivity extends AppCompatActivity {

    RelativeLayout frenchLayout, englishLayout, nigerianLayout, yorubaLayout, igboLayout, hausaLayout, efikLayout;
    public static final String NAME_OF_SELECTED_LANG= "com.example.konye.lingo name_of_selected_lang";
    ImageView storeButton;
    boolean layoutIsExpanded;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_language);
        changeWidgetsFont();
        englishLayout = findViewById(R.id.english_layout);
        frenchLayout = findViewById(R.id.french_layout);
        nigerianLayout = findViewById(R.id.nigerian_layout);
        yorubaLayout = findViewById(R.id.yoruba_layout);
        igboLayout = findViewById(R.id.igbo_layout);
        hausaLayout = findViewById(R.id.hausa_layout);
        efikLayout = findViewById(R.id.efik_layout);
        storeButton = findViewById(R.id.store_button);

        englishLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LanguageHomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
        frenchLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LanguageHomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
        nigerianLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutIsExpanded = !layoutIsExpanded;
                yorubaLayout.setVisibility(layoutIsExpanded? View.VISIBLE : View.GONE);
                igboLayout.setVisibility(layoutIsExpanded? View.VISIBLE : View.GONE);
                hausaLayout.setVisibility(layoutIsExpanded? View.VISIBLE : View.GONE);
                efikLayout.setVisibility(layoutIsExpanded? View.VISIBLE: View.GONE);
            }
        });
        yorubaLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LanguageHomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
        igboLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LanguageHomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
        hausaLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LanguageHomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
        efikLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LanguageActivity.class);
                startActivity(intent);
                finish();
            }
        });
        storeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),StoreActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void changeWidgetsFont(){
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("helvetica_font_normal.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

}
