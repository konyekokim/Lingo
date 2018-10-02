package com.mahadum360.mahadum.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.mahadum360.mahadum.R;


public class ChooseLanguageActivity extends AppCompatActivity {

    RelativeLayout frenchLayout, englishLayout, nigerianLayout, yorubaLayout, igboLayout, hausaLayout, efikLayout;
    public static final String NAME_OF_SELECTED_LANG= "com.example.konye.lingo name_of_selected_lang";
    ImageView storeButton;
    boolean layoutIsExpanded;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_language);
        //changeWidgetsFont();
        englishLayout = findViewById(R.id.english_layout);
        frenchLayout = findViewById(R.id.french_layout);
        nigerianLayout = findViewById(R.id.nigerian_layout);
        yorubaLayout = findViewById(R.id.yoruba_layout);
        igboLayout = findViewById(R.id.igbo_layout);
        hausaLayout = findViewById(R.id.hausa_layout);
        efikLayout = findViewById(R.id.efik_layout);
        storeButton = findViewById(R.id.store_button);

        englishLayout.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),LanguageHomeActivity.class);
            startActivity(intent);
            finish();
        });
        frenchLayout.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),LanguageHomeActivity.class);
            startActivity(intent);
            finish();
        });
        nigerianLayout.setOnClickListener(v -> {
            layoutIsExpanded = !layoutIsExpanded;
            yorubaLayout.setVisibility(layoutIsExpanded? View.VISIBLE : View.GONE);
            igboLayout.setVisibility(layoutIsExpanded? View.VISIBLE : View.GONE);
            hausaLayout.setVisibility(layoutIsExpanded? View.VISIBLE : View.GONE);
            efikLayout.setVisibility(layoutIsExpanded? View.VISIBLE: View.GONE);
        });
        yorubaLayout.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),LanguageHomeActivity.class);
            startActivity(intent);
            finish();
        });
        igboLayout.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),LanguageHomeActivity.class);
            startActivity(intent);
            finish();
        });
        hausaLayout.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),LanguageHomeActivity.class);
            startActivity(intent);
            finish();
        });
        efikLayout.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),LanguageActivity.class);
            startActivity(intent);
            finish();
        });
        storeButton.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),StoreActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
