package com.example.konye.lingo;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class MostRecentFragment extends Fragment {
    int firstImage, secondImage, thirdImage;
    public MostRecentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mostRecentView = inflater.inflate(R.layout.most_recent_layout, container, false);
        ImageView firstImgView = (ImageView) mostRecentView.findViewById(R.id.most_recent_first_img);
        ImageView secondImgView = (ImageView) mostRecentView.findViewById(R.id.most_recent_second_img);
        ImageView thirdImgView = (ImageView) mostRecentView.findViewById(R.id.most_recent_third_img);
        firstImage = R.drawable.book3;
        secondImage = R.drawable.book1;
        thirdImage = R.drawable.book2;
        firstImgView.setImageResource(firstImage);
        secondImgView.setImageResource(secondImage);
        thirdImgView.setImageResource(thirdImage);

        firstImgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), BookActivity.class);
                intent.putExtra(StoreActivity.BOOK_FIRST_IMG_VIEW,firstImage);
                startActivity(intent);
            }
        });
        secondImgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), BookActivity.class);
                intent.putExtra(StoreActivity.BOOK_FIRST_IMG_VIEW,secondImage);
                startActivity(intent);
            }
        });
        thirdImgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), BookActivity.class);
                intent.putExtra(StoreActivity.BOOK_FIRST_IMG_VIEW,thirdImage);
                startActivity(intent);
            }
        });
        
        return mostRecentView;
    }
}
