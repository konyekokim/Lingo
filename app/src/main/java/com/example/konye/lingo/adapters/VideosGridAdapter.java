package com.example.konye.lingo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.konye.lingo.R;

import java.util.ArrayList;

/**
 * Created by ALPHA AND JAM on 12/7/2017.
 */

public class VideosGridAdapter extends BaseAdapter{
    private int imageRes[];
    private String names[];
    private Context context;
    private LayoutInflater layoutInflater;
    public VideosGridAdapter(Context context, int imageRes[], String names[]){
        this.context = context;
        this.imageRes = imageRes;
        this.names = names;
    }
    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int i) {
        return names[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View gridView = view;
        if(view == null){
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            gridView = layoutInflater.inflate(R.layout.grid_video_item,null);
        }
        ImageView videoImage = gridView.findViewById(R.id.videos_imgView);
        TextView nameTextView = gridView.findViewById(R.id.videos_textView);
        videoImage.setImageResource(imageRes[i]);
        nameTextView.setText(names[i]);
        return gridView;
    }

    /*ArrayList<GridClass> gridClasses;
    public VideosGridAdapter(Context context, int resources, ArrayList<GridClass> gridClasses){
        super(context,resources,gridClasses);
        this.gridClasses = gridClasses;
    }

    public View getView(int position, View convertView, ViewGroup container){
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.grid_video_item,null);
        }
        GridClass gridClass = getItem(position);
        ImageView videoImage = (ImageView) convertView.findViewById(R.id.videos_imgView);
        TextView nameTextView = (TextView) convertView.findViewById(R.id.videos_textView);
        videoImage.setImageURI(gridClass.getPicUri());
        nameTextView.setText(gridClass.getName());
        return convertView;
    }*/
}
