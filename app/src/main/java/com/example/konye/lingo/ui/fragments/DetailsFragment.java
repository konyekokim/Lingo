package com.example.konye.lingo.ui.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.konye.lingo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends Fragment {


    public DetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View detailsView = inflater.inflate(R.layout.details_layout,container,false);
        TextView aboutTheBook = detailsView.findViewById(R.id.about_the_book);
        TextView aboutTheBookContent = detailsView.findViewById(R.id.about_the_book_content);
        return detailsView;
    }

}
