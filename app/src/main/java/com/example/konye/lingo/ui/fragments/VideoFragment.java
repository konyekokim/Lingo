package com.example.konye.lingo.ui.fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.konye.lingo.R;
import com.example.konye.lingo.utils.VideosClass;
import com.example.konye.lingo.adapters.VideosAdapter;
import com.example.konye.lingo.ui.activities.LanguageActivity;
import com.example.konye.lingo.ui.activities.VideoViewActivity;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class VideoFragment extends Fragment {

    ArrayList<VideosClass> videosClasses;
    private OnFragmentInteractionListener listener;
    public static final String LANGUAGE_SELECTED = "com.example.konye.lingo videoLangSelected";
    Intent intent;
    public VideoFragment() {
        // Required empty public constructor
    }

    public static VideoFragment newInstance() {
        return new VideoFragment();
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View videoView = inflater.inflate(R.layout.videos_view, container, false);
        RecyclerView videoListView = videoView.findViewById(R.id.videos_list_view);
        ImageView continueButton = videoView.findViewById(R.id.continue_btn);
        continueButton.setOnClickListener(v -> {
            intent = new Intent(getContext(),VideoViewActivity.class);
            intent.putExtra(LanguageActivity.LANGUAGE_VIDEO_INDEX, 3);
            startActivity(intent);
        });
        addVideosListData();
        VideosAdapter videosAdapter = new VideosAdapter(listener, videosClasses);
        videoListView.setLayoutManager(new LinearLayoutManager(getContext()));
        videoListView.setHasFixedSize(true);
        videoListView.setAdapter(videosAdapter);
        return videoView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener)
            listener = (OnFragmentInteractionListener) context;
        else
            throw new RuntimeException(context.getClass().getSimpleName() + " must implement " +
                    "OnFragmentInteractionListener");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    private void addVideosListData(){
        videosClasses = new ArrayList<>();
        videosClasses.add(new VideosClass("Part 1","Introduction",
                R.drawable.vid_2));
        videosClasses.add(new VideosClass("Part 2","Chapter 1",
                R.drawable.vid_1));
        videosClasses.add(new VideosClass("Part 3","Chapter 2",
                R.drawable.vid_3));
        videosClasses.add(new VideosClass("Part 4","Chapter 3",
                R.drawable.vid_2));
        videosClasses.add(new VideosClass("Part 5","Chapter 4",
                R.drawable.vid_1));
        videosClasses.add(new VideosClass("Part 6","Chapter 5",
                R.drawable.vid_2));
        videosClasses.add(new VideosClass("Part 7","Chapter 6",
                R.drawable.vid_3));
        videosClasses.add(new VideosClass("Part 8","Chapter 7",
                R.drawable.vid_1));
        videosClasses.add(new VideosClass("Part 9","Chapter 8",
                R.drawable.vid_3));
        videosClasses.add(new VideosClass("Part 10","Chapter 9",
                R.drawable.vid_2));
        videosClasses.add(new VideosClass("Part 11","Chapter 10",
                R.drawable.vid_1));
        videosClasses.add(new VideosClass("Part 12","Chapter 11",
                R.drawable.vid_2));
        videosClasses.add(new VideosClass("Part 13","Chapter 12",
                R.drawable.vid_1));
        videosClasses.add(new VideosClass("Part 14","Chapter 13",
                R.drawable.vid_3));
        videosClasses.add(new VideosClass("Part 15","Chapter 14",
                R.drawable.vid_3));
        videosClasses.add(new VideosClass("Part 16","Chapter 15",
                R.drawable.vid_2));
        videosClasses.add(new VideosClass("Part 17","Chapter 16",
                R.drawable.vid_1));
        videosClasses.add(new VideosClass("Part 2","Quiz",
                R.drawable.vid_3));
    }


    public interface OnFragmentInteractionListener {
        void onVideoSelected(int pos, ArrayList<VideosClass> videos);
    }

}
