package com.mahadum360.mahadum.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.mahadum360.mahadum.R;


public class BookActivity extends AppCompatActivity {
    int bookImgViewResource;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //changeWidgetsFont();

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.lang_action_bar_layout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TextView actionBarTextView = findViewById(R.id.my_text);
        actionBarTextView.setText(String.valueOf("Book"));

        Intent intent = getIntent();
        bookImgViewResource = intent.getIntExtra(StoreActivity.BOOK_FIRST_IMG_VIEW,R.drawable.book1);
        ImageView bookImgView = findViewById(R.id.book_img_view);
        TextView nameOfBook = findViewById(R.id.name_of_book);
        TextView nameOfAuthor = findViewById(R.id.name_of_author);
        TextView priceTextView = findViewById(R.id.price_textView);
        Button previewButton = findViewById(R.id.preview_button);
        Button purchaseButton = findViewById(R.id.purchase_button);
        TextView aboutTextView = findViewById(R.id.about_textView);
        bookImgView.setOnClickListener(view -> {
            Intent intent1 = new Intent(getApplicationContext(), PdfReaderActivity.class);
            startActivity(intent1);
        });
        previewButton.setOnClickListener(view -> {
            Intent intent12 = new Intent(getApplicationContext(),PdfReaderActivity.class);
            startActivity(intent12);
        });

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
       if(keyCode == KeyEvent.KEYCODE_BACK){
           finish();
       }
       return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
