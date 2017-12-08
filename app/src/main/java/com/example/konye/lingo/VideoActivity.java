package com.example.konye.lingo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

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
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        changeWidgetsFont();

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.lang_action_bar_layout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TextView actionBarTextView = (TextView) findViewById(R.id.my_text);
        actionBarTextView.setText("Video");

        ImageView bookImgView = (ImageView) findViewById(R.id.book_img_view);
        TextView nameOfBook = (TextView) findViewById(R.id.name_of_book);
        TextView nameOfAuthor = (TextView) findViewById(R.id.name_of_author);
        TextView priceTextView = (TextView) findViewById(R.id.price_textView);
        Button previewButton = (Button) findViewById(R.id.preview_button);
        Button purchaseButton = (Button) findViewById(R.id.purchase_button);
        TextView detailsTextView = (TextView) findViewById(R.id.details_textView);
        GridView gridView = (GridView) findViewById(R.id.gridView);
        VideosGridAdapter gridAdapter = new VideosGridAdapter(this, imageRes,names);
        gridView.setAdapter(gridAdapter);
        bookImgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PdfReaderActivity.class);
                startActivity(intent);
            }
        });
        previewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),PdfReaderActivity.class);
                startActivity(intent);
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
