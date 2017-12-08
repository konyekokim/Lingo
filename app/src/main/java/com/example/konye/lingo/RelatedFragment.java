package com.example.konye.lingo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class RelatedFragment extends Fragment {


    public RelatedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View relatedView = inflater.inflate(R.layout.related_layout,container, false);
        ImageView firstView = (ImageView) relatedView.findViewById(R.id.related_first_img);
        ImageView secondView = (ImageView) relatedView.findViewById(R.id.related_second_img);
        ImageView thirdView = (ImageView) relatedView.findViewById(R.id.related_third_img);
        ImageView fourthView = (ImageView) relatedView.findViewById(R.id.related_fourth_img);
        ImageView fifthView = (ImageView) relatedView.findViewById(R.id.related_fifth_img);
        ImageView sixthView = (ImageView) relatedView.findViewById(R.id.related_sixth_img);
        ImageView barOne = (ImageView) relatedView.findViewById(R.id.bar_1);
        ImageView barTwo = (ImageView) relatedView.findViewById(R.id.bar_2);

        return relatedView;
    }

}
