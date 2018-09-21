package com.example.konye.lingo.ui.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.konye.lingo.R;
import com.example.konye.lingo.ui.activities.BookActivity;
import com.example.konye.lingo.ui.activities.StoreActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class MostRecentFragment extends Fragment {
    int firstImage, secondImage, thirdImage;
    public MostRecentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mostRecentView = inflater.inflate(R.layout.most_recent_layout, container, false);
        ImageView firstImgView = mostRecentView.findViewById(R.id.most_recent_first_img);
        ImageView secondImgView = mostRecentView.findViewById(R.id.most_recent_second_img);
        ImageView thirdImgView = mostRecentView.findViewById(R.id.most_recent_third_img);
        firstImage = R.drawable.book3;
        secondImage = R.drawable.book1;
        thirdImage = R.drawable.book2;
        firstImgView.setImageResource(firstImage);
        secondImgView.setImageResource(secondImage);
        thirdImgView.setImageResource(thirdImage);

        firstImgView.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), BookActivity.class);
            intent.putExtra(StoreActivity.BOOK_FIRST_IMG_VIEW,firstImage);
            startActivity(intent);
        });
        secondImgView.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), BookActivity.class);
            intent.putExtra(StoreActivity.BOOK_FIRST_IMG_VIEW,secondImage);
            startActivity(intent);
        });
        thirdImgView.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), BookActivity.class);
            intent.putExtra(StoreActivity.BOOK_FIRST_IMG_VIEW,thirdImage);
            startActivity(intent);
        });
        
        return mostRecentView;
    }
}
