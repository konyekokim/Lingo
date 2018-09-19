package com.example.konye.lingo.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.konye.lingo.R;
import com.example.konye.lingo.utils.SlidesClass;

import java.util.ArrayList;

/**
 * Created by KONYE on 5/18/2017.
 */

public class SlidesAdapter extends ArrayAdapter<SlidesClass>{
    private ArrayList<SlidesClass> slidesClasses;
    int pos = 2;
    public SlidesAdapter(Context context, int resources, ArrayList<SlidesClass> slidesClasses){
        super(context, resources, slidesClasses);
        this.slidesClasses = slidesClasses;
    }

    @NonNull
    public View getView(int position, View convertView, @NonNull ViewGroup container){
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.slides_view_row,null);
        }
        SlidesClass slidesClass = getItem(position);
        RelativeLayout slidesRowLayout = convertView.findViewById(R.id.slides_row_layout);
        TextView slideTitle = convertView.findViewById(R.id.slide_row_text_title);
        TextView slideSubtitle = convertView.findViewById(R.id.slide_row_text_subtitle);
        ImageView slideImageView = convertView.findViewById(R.id.slide_row_image_view);
        TextView openSlideArrow = convertView.findViewById(R.id.open_slide_arrow);
        TextView listQuizView = convertView.findViewById(R.id.list_quiz_view);
        slideTitle.setText(slidesClass.getSlidesTitle());
        slideSubtitle.setText(slidesClass.getSlidesSubtitle());
        slideImageView.setImageResource(slidesClass.getImgThumbnail());

        if(position == slidesClasses.size()-1){
            slideTitle.setVisibility(View.GONE);
            slideSubtitle.setVisibility(View.GONE);
            slideImageView.setVisibility(View.GONE);
            openSlideArrow.setVisibility(View.GONE);
            listQuizView.setVisibility(View.VISIBLE);
            //slidesRowLayout.setBackgroundColor(Color.parseColor("#E0E0E0"));
        }else{
            slideTitle.setVisibility(View.VISIBLE);
            slideSubtitle.setVisibility(View.VISIBLE);
            slideImageView.setVisibility(View.VISIBLE);
            openSlideArrow.setVisibility(View.VISIBLE);
            listQuizView.setVisibility(View.GONE);
        }

        return convertView;
    }
}
    