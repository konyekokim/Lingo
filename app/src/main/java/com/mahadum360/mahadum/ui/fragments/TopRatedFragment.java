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
public class TopRatedFragment extends Fragment {
    int firstImage, secondImage, thirdImage;
    public TopRatedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View topRatedView = inflater.inflate(R.layout.top_rated_layout, container, false);
        ImageView firstImgView = topRatedView.findViewById(R.id.top_rated_first_img);
        ImageView secondImgView = topRatedView.findViewById(R.id.top_rated_second_img);
        ImageView thirdImgView = topRatedView.findViewById(R.id.top_rated_third_img);
        firstImage = R.drawable.book2;
        secondImage = R.drawable.book3;
        thirdImage = R.drawable.book1;
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

        return topRatedView;
    }
}
