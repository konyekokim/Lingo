package com.example.konye.lingo.ui.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.konye.lingo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RelatedFragment extends Fragment {


    public RelatedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View relatedView = inflater.inflate(R.layout.related_layout,container, false);
        ImageView firstView = relatedView.findViewById(R.id.related_first_img);
        ImageView secondView = relatedView.findViewById(R.id.related_second_img);
        ImageView thirdView = relatedView.findViewById(R.id.related_third_img);
        ImageView fourthView = relatedView.findViewById(R.id.related_fourth_img);
        ImageView fifthView = relatedView.findViewById(R.id.related_fifth_img);
        ImageView sixthView = relatedView.findViewById(R.id.related_sixth_img);
        ImageView barOne = relatedView.findViewById(R.id.bar_1);
        ImageView barTwo = relatedView.findViewById(R.id.bar_2);

        return relatedView;
    }

}
