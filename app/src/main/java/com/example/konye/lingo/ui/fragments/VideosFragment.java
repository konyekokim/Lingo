package com.example.konye.lingo.ui.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.konye.lingo.R;
import com.example.konye.lingo.adapters.VideosGridAdapter;
import com.example.konye.lingo.ui.activities.VideoActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class VideosFragment extends Fragment {

    View videosView;
    int imageRes[] = {R.drawable.book2,R.drawable.book1,R.drawable.book3,R.drawable.book1,R.drawable.book1,
            R.drawable.book1,R.drawable.book1,R.drawable.book3,R.drawable.book2,R.drawable.book2};
    String names[] = {"Name of books in here", "Name of books in here","Name of books in here","Name of books in here",
            "Name of books in here","Name of books in here","Name of books in here","Name of books in here","Name of books in here",
            "Name of books in here"};
    public VideosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        videosView = inflater.inflate(R.layout.mahadum_books_view,container, false);
        GridView gridView = videosView.findViewById(R.id.gridView);
        VideosGridAdapter gridAdapter = new VideosGridAdapter(getContext(),imageRes,names);
        gridView.setAdapter(gridAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getContext(), VideoActivity.class);
                startActivity(intent);
            }
        });
        return videosView;
    }

}
