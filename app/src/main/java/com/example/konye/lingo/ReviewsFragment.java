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
public class ReviewsFragment extends Fragment {


    public ReviewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View reviewsView = inflater.inflate(R.layout.reviews_layout,container, false);
        TextView reviewerName = (TextView) reviewsView.findViewById(R.id.reviewer_name);
        ImageView reviewRatingCircle = (ImageView) reviewsView.findViewById(R.id.review_ratings_circles);
        TextView reviewTextView = (TextView) reviewsView.findViewById(R.id.review_textView);

        return reviewsView;
    }

}
