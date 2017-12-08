package com.example.konye.lingo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by KONYE on 5/18/2017.
 */

public class VideosAdapter extends ArrayAdapter<VideosClass> {
    ArrayList<VideosClass> videosClasses;
    public VideosAdapter(Context context, int resources, ArrayList<VideosClass> videosClasses){
        super(context, resources, videosClasses);
        this.videosClasses = videosClasses;
    }

    public View getView(int position, View convertView, ViewGroup container){
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.videos_view_row,null);
        }
        VideosClass videosClass = getItem(position);
        TextView videoTitle = (TextView) convertView.findViewById(R.id.video_row_text_title);
        TextView videoSubtitle = (TextView) convertView.findViewById(R.id.video_row_text_subtitle);
        ImageView videoImageview = (ImageView) convertView.findViewById(R.id.video_row_image_view);
        TextView listQuizView = (TextView) convertView.findViewById(R.id.list_quiz_view);
        TextView openArrow = (TextView) convertView.findViewById(R.id.open_arrow);
        videoTitle.setText(videosClass.getVideosTitle());
        videoSubtitle.setText(videosClass.getVideosSubtitle());
        videoImageview.setImageResource(videosClass.getImgThumbnail());

        if(position == videosClasses.size()-1){
            videoTitle.setVisibility(View.GONE);
            videoSubtitle.setVisibility(View.GONE);
            videoImageview.setVisibility(View.GONE);
            openArrow.setVisibility(View.GONE);
            listQuizView.setVisibility(View.VISIBLE);
        }else{
            videoTitle.setVisibility(View.VISIBLE);
            videoSubtitle.setVisibility(View.VISIBLE);
            videoImageview.setVisibility(View.VISIBLE);
            openArrow.setVisibility(View.VISIBLE);
            listQuizView.setVisibility(View.GONE);
        }

        return convertView;
    }
}
