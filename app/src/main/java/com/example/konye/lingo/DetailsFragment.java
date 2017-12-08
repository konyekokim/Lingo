package com.example.konye.lingo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends Fragment {


    public DetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View detailsView = inflater.inflate(R.layout.details_layout,container,false);
        TextView aboutTheBook = (TextView) detailsView.findViewById(R.id.about_the_book);
        TextView aboutTheBookContent = (TextView) detailsView.findViewById(R.id.about_the_book_content);
        return detailsView;
    }

}
