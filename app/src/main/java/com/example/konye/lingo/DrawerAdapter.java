package com.example.konye.lingo;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar;

import java.util.ArrayList;

/**
 * Created by KONYE on 7/6/2017.
 */

public class DrawerAdapter extends ArrayAdapter<DrawerClass>{
    ArrayList<DrawerClass> drawerClasses;

    public DrawerAdapter(Context context, int resources, ArrayList<DrawerClass> drawerClasses){
        super(context, resources, drawerClasses);
        this.drawerClasses = drawerClasses;
    }
    public View getView(int position, View convertView, ViewGroup container){
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.drawer_listview_item,null);
        }
        DrawerClass drawerClass = getItem(position);
        TextView drawerTextView = (TextView) convertView.findViewById(R.id.text1);
        TextView drawerProgressView = (TextView) convertView.findViewById(R.id.drawer_progress_textView);
        RoundCornerProgressBar drawerProgressBar = (RoundCornerProgressBar) convertView.findViewById(R.id.home_drawer_progress_bar); 
        drawerTextView.setText(drawerClass.getlanguageTitle());
        int progress = drawerClass.getProgress();
        String progressString;
        progressString = Integer.toString(progress);
        drawerProgressView.setText(progressString+"%");
        drawerProgressBar.setMax(100);
        drawerProgressBar.setProgress(drawerClass.getProgress());
        drawerProgressBar.setScaleY(0.8f);

        switch(position){
            case 0:
                drawerProgressView.setTextColor(Color.parseColor("#FC7900"));
                drawerProgressBar.setProgressColor(Color.parseColor("#FC7900"));
                drawerProgressBar.setSecondaryProgressColor(Color.parseColor("#FC7900"));
                break;
            case 1:
                drawerProgressView.setTextColor(Color.parseColor("#64DD17"));
                drawerProgressBar.setProgressColor(Color.parseColor("#64DD17"));
                drawerProgressBar.setSecondaryProgressColor(Color.parseColor("#64DD17"));
                break;
            case 2:
                drawerProgressView.setTextColor(Color.parseColor("#DD2C00"));
                drawerProgressBar.setProgressColor(Color.parseColor("#DD2C00"));
                drawerProgressBar.setSecondaryProgressColor(Color.parseColor("#DD2C00"));
                break;
            case 3:
                drawerProgressView.setTextColor(Color.parseColor("#fc7900"));
                drawerProgressBar.setProgressColor(Color.parseColor("#fc7900"));
                drawerProgressBar.setSecondaryProgressColor(Color.parseColor("#fc7900"));
                break;
            case 4:
                drawerProgressView.setTextColor(Color.parseColor("#64DD17"));
                drawerProgressBar.setProgressColor(Color.parseColor("#64DD17"));
                drawerProgressBar.setSecondaryProgressColor(Color.parseColor("#64DD17"));
                break;
            case 5:
                drawerProgressView.setTextColor(Color.parseColor("#DD2C00"));
                drawerProgressBar.setProgressColor(Color.parseColor("#DD2C00"));
                drawerProgressBar.setSecondaryProgressColor(Color.parseColor("#DD2C00"));
                break;
        }
        return convertView;
    }
}
