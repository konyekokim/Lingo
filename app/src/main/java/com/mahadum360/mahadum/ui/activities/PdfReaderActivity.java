package com.mahadum360.mahadum.ui.activities;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.github.barteksc.pdfviewer.PDFView;
import com.mahadum360.mahadum.R;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class PdfReaderActivity extends AppCompatActivity {
    PDFView pdfView;
    String pdf_url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_reader);
        //changeWidgetsFont();
        pdfView = findViewById(R.id.pdfView);
        //this is for populating the viewer from assets
        //pdfView.fromAsset("result.PDF").load();

        //this reads pdf from URL
        //new RetrievePDFStream().execute(pdf_url);
    }

    class RetrievePDFStream extends AsyncTask<String,Void,InputStream> {

        @Override
        protected InputStream doInBackground(String... strings) {
            InputStream inputStream = null;
            try {
                URL url = new URL(strings[0]);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                if(httpURLConnection.getResponseCode() == 200){
                    inputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return inputStream;
        }

        @Override
        protected void onPostExecute(InputStream inputStream) {
            pdfView.fromStream(inputStream).load();
        }
    }
}
