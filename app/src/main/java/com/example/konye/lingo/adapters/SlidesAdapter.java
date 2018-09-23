package com.example.konye.lingo.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.konye.lingo.R;
import com.example.konye.lingo.ui.fragments.SlideFragment.OnFragmentInteractionListener;
import com.example.konye.lingo.utils.SlidesClass;

import java.util.ArrayList;

/**
 * Created by KONYE on 5/18/2017.
 */

public class SlidesAdapter extends RecyclerView.Adapter<SlidesAdapter.ViewHolder>{
    private ArrayList<SlidesClass> slidesClasses;
    private OnFragmentInteractionListener listener;

    public SlidesAdapter(OnFragmentInteractionListener listener, ArrayList<SlidesClass> slides) {
        this.listener = listener;
        this.slidesClasses = slides;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.slides_view_row, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SlidesClass slidesClass = slidesClasses.get(position);
        holder.slideTitle.setText(slidesClass.getSlidesTitle());
        holder.slideSubTitle.setText(slidesClass.getSlidesSubtitle());
        holder.slideImage.setImageResource(slidesClass.getImgThumbnail());

        if(position == slidesClasses.size()-1){
            holder.slideTitle.setVisibility(View.GONE);
            holder.slideSubTitle.setVisibility(View.GONE);
            holder.slideImage.setVisibility(View.GONE);
            holder.openSlideArrow.setVisibility(View.GONE);
            holder.listQuizView.setVisibility(View.VISIBLE);
            //slidesRowLayout.setBackgroundColor(Color.parseColor("#E0E0E0"));
        }else{
            holder.slideTitle.setVisibility(View.VISIBLE);
            holder.slideSubTitle.setVisibility(View.VISIBLE);
            holder.slideImage.setVisibility(View.VISIBLE);
            holder.openSlideArrow.setVisibility(View.VISIBLE);
            holder.listQuizView.setVisibility(View.GONE);
        }

        holder.v.setOnClickListener(t -> {
            if (listener != null)
                listener.onSlideClicked(position, slidesClasses);
        });
    }

    @Override
    public int getItemCount() {
        return slidesClasses.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout slidesView;
        TextView slideTitle, slideSubTitle, openSlideArrow, listQuizView;
        ImageView slideImage;
        View v;
        ViewHolder(View v) {
            super(v);
            this.v = v;
            slidesView = v.findViewById(R.id.slides_row_layout);
            slideTitle = v.findViewById(R.id.slide_row_text_title);
            slideSubTitle = v.findViewById(R.id.slide_row_text_subtitle);
            slideImage = v.findViewById(R.id.slide_row_image_view);
            openSlideArrow = v.findViewById(R.id.open_slide_arrow);
            listQuizView = v.findViewById(R.id.list_quiz_view);
        }
    }
}
    