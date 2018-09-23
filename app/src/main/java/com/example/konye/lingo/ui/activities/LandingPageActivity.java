package com.example.konye.lingo.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.example.konye.lingo.R;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class LandingPageActivity extends AppCompatActivity {
    Button bookStoreButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setFullScreen();
        setContentView(R.layout.activity_landing_page);

        //changeWidgetsFont();
        bookStoreButton = findViewById(R.id.book_store_button);
        bookStoreButton.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), StoreActivity.class);
            startActivity(intent);
        });
    }

    private void setFullScreen(){
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}
