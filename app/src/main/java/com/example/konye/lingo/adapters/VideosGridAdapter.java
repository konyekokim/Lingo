package com.example.konye.lingo.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.konye.lingo.R;
import com.example.konye.lingo.ui.fragments.VideosFragment.OnFragmentInteractionListener;


/**
 * Created by Abdul on 23/09/2018.
 */

public class VideosGridAdapter extends RecyclerView.Adapter<VideosGridAdapter.ViewHolder>{
    private int imageRes[];
    private String names[];
    private InteractionListener listener;
    public VideosGridAdapter(InteractionListener listener, int imageRes[], String names[]){
        this.listener = listener;
        this.imageRes = imageRes;
        this.names = names;
    }

    public interface InteractionListener {
        void onVideoClicked();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.grid_video_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int pos) {
        holder.videoImage.setImageResource(imageRes[pos]);
        holder.videoText.setText(names[pos]);

        holder.v.setOnClickListener(t -> {
            if (listener != null)
                listener.onVideoClicked();
        });
    }

    @Override
    public int getItemCount() {
        return names.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView videoImage, playBtn;
        TextView videoText;
        View v;
        ViewHolder(View v) {
            super(v);
            videoImage = v.findViewById(R.id.videos_imgView);
            playBtn = v.findViewById(R.id.play_btn);
            videoText = v.findViewById(R.id.videos_textView);
            this.v = v;
        }
    }
}
