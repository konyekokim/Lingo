package com.mahadum360.mahadum.ui.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.mahadum360.mahadum.R;
import com.mahadum360.mahadum.ui.activities.BookActivity;
import com.mahadum360.mahadum.ui.activities.StoreActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class WeekBestFragment extends Fragment {

    int firstImage, secondImage, thirdImage;
    public WeekBestFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View weekBestView = inflater.inflate(R.layout.weeks_best_layout, container, false);
        final ImageView firstImgView = weekBestView.findViewById(R.id.best_week_first_img);
        final ImageView secondImgView = weekBestView.findViewById(R.id.best_week_second_img);
        ImageView thirdImgView = weekBestView.findViewById(R.id.best_week_third_img);
        firstImage = R.drawable.book1;
        secondImage = R.drawable.book2;
        thirdImage = R.drawable.book3;
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

        return weekBestView;
    }
}
