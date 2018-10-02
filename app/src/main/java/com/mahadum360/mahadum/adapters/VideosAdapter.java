package com.mahadum360.mahadum.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mahadum360.mahadum.R;
import com.mahadum360.mahadum.ui.fragments.VideoFragment.OnFragmentInteractionListener;
import com.mahadum360.mahadum.utils.VideosClass;

import java.util.ArrayList;

/**
 * Created by KONYE on 5/18/2017.
 */

public class VideosAdapter extends RecyclerView.Adapter<VideosAdapter.ViewHolder> {
    private ArrayList<VideosClass> videosClasses;
    private OnFragmentInteractionListener listener;

    public VideosAdapter(OnFragmentInteractionListener listener,
                         ArrayList<VideosClass> videos) {
        this.videosClasses = videos;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.videos_view_row, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        VideosClass videosClass = videosClasses.get(position);

        holder.videoText.setText(videosClass.getVideosTitle());
        holder.videoSubText.setText(videosClass.getVideosSubtitle());
        holder.videoImage.setImageResource(videosClass.getImgThumbnail());

        if(position == videosClasses.size()-1){
            holder.videoText.setVisibility(View.GONE);
            holder.videoSubText.setVisibility(View.GONE);
            holder.videoImage.setVisibility(View.GONE);
            holder.openArrow.setVisibility(View.GONE);
            holder.listQuizView.setVisibility(View.VISIBLE);
        }else{
            holder.videoText.setVisibility(View.VISIBLE);
            holder.videoSubText.setVisibility(View.VISIBLE);
            holder.videoImage.setVisibility(View.VISIBLE);
            holder.openArrow.setVisibility(View.VISIBLE);
            holder.listQuizView.setVisibility(View.GONE);
        }

        holder.v.setOnClickListener(t -> {
            if (listener != null)
                listener.onVideoSelected(position, videosClasses);
        });
    }

    @Override
    public int getItemCount() {
        return videosClasses.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView videoText, videoSubText, listQuizView, openArrow;
        ImageView videoImage;
        View v;
        ViewHolder(View v) {
            super(v);
            videoText = v.findViewById(R.id.video_row_text_title);
            videoSubText = v.findViewById(R.id.video_row_text_subtitle);
            videoImage = v.findViewById(R.id.video_row_image_view);
            listQuizView = v.findViewById(R.id.list_quiz_view);
            openArrow = v.findViewById(R.id.open_arrow);
            this.v = v;
        }
    }
}
