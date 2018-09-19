package com.example.konye.lingo.ui.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.konye.lingo.R;
import com.example.konye.lingo.SlidesClass;
import com.example.konye.lingo.adapters.SlidesAdapter;
import com.example.konye.lingo.ui.activities.QuizViewActivity;
import com.example.konye.lingo.ui.activities.SlideViewActivity;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SlideFragment extends Fragment {

    int pos = 2;
    View slideView;
    ArrayList<SlidesClass>  slidesClasses;
    public SlideFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        slideView =  inflater.inflate(R.layout.slides_view,container,false);
        ListView slideListView = slideView.findViewById(R.id.slides_list_view);
        ImageView continueButton = slideView.findViewById(R.id.continue_btn);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SlideViewActivity.class);
                startActivity(intent);
            }
        });
        addSlidesListData();
        SlidesAdapter slidesAdapter = new SlidesAdapter(getContext(),R.layout.slides_view_row,addSlidesListData());
        slideListView.setAdapter(slidesAdapter);
        slideListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == slidesClasses.size()-1){
                    Intent intent = new Intent(getContext(),QuizViewActivity.class);
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(getContext(), SlideViewActivity.class);
                    startActivity(intent);
                }
            }
        });
        return slideView;
    }

    private ArrayList<SlidesClass> addSlidesListData(){
        slidesClasses = new ArrayList<>();
        slidesClasses.add(new SlidesClass("Part 1","Introduction",R.drawable.orange_p));
        slidesClasses.add(new SlidesClass("Part 2","after Introduction",R.drawable.red_p));
        slidesClasses.add(new SlidesClass("Part 3","2nd Stage",R.drawable.green_p));
        slidesClasses.add(new SlidesClass("Part 3","3rd Stage",R.drawable.red_p));
        slidesClasses.add(new SlidesClass("Part 3","4th Stage",R.drawable.orange_p));
        slidesClasses.add(new SlidesClass("Part 3","5th Stage",R.drawable.green_p));
        slidesClasses.add(new SlidesClass("Part 3","6th Stage",R.drawable.red_p));
        slidesClasses.add(new SlidesClass("Part 3","7th Stage",R.drawable.orange_p));
        slidesClasses.add(new SlidesClass("Part 3","8th Stage",R.drawable.green_p));
        slidesClasses.add(new SlidesClass("Part 3","9th Stage",R.drawable.red_p));
        slidesClasses.add(new SlidesClass("Part 5","Quiz",R.drawable.green_p));

        return slidesClasses;
    }
}
