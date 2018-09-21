package com.example.konye.lingo.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.konye.lingo.R;
import com.example.konye.lingo.adapters.VideosGridAdapter;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class VideoActivity extends AppCompatActivity {
    int imageRes[] = {R.drawable.book2,R.drawable.book1,R.drawable.book3,R.drawable.book1,R.drawable.book1,
            R.drawable.book1,R.drawable.book1,R.drawable.book3,R.drawable.book2,R.drawable.book2};
    String names[] = {"Name of books in here", "Name of books in here","Name of books in here","Name of books in here",
            "Name of books in here","Name of books in here","Name of books in here","Name of books in here","Name of books in here",
            "Name of books in here"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //hangeWidgetsFont();

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.lang_action_bar_layout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TextView actionBarTextView = findViewById(R.id.my_text);
        actionBarTextView.setText(String.valueOf("Video"));

        ImageView bookImgView = findViewById(R.id.book_img_view);
        TextView nameOfBook = findViewById(R.id.name_of_book);
        TextView nameOfAuthor = findViewById(R.id.name_of_author);
        TextView priceTextView = findViewById(R.id.price_textView);
        Button previewButton = findViewById(R.id.preview_button);
        Button purchaseButton = findViewById(R.id.purchase_button);
        TextView detailsTextView = findViewById(R.id.details_textView);
        GridView gridView = findViewById(R.id.gridView);
        VideosGridAdapter gridAdapter = new VideosGridAdapter(this, imageRes,names);
        gridView.setAdapter(gridAdapter);
        bookImgView.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), PdfReaderActivity.class);
            startActivity(intent);
        });
        previewButton.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(),PdfReaderActivity.class);
            startActivity(intent);
        });
    }

    /*private void changeWidgetsFont(){
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("helvetica_font_normal.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }*/

}
