package com.mahadum360.mahadum.ui.fragments;


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

import com.mahadum360.mahadum.R;
import com.mahadum360.mahadum.adapters.SlidesAdapter;
import com.mahadum360.mahadum.ui.activities.SlideViewActivity;
import com.mahadum360.mahadum.utils.SlidesClass;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SlideFragment extends Fragment {

    View slideView;
    private OnFragmentInteractionListener listener;
    ArrayList<SlidesClass>  slidesClasses;
    public SlideFragment() {
        // Required empty public constructor
    }

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        slideView =  inflater.inflate(R.layout.slides_view,container,false);
        RecyclerView slideListView = slideView.findViewById(R.id.slides_list_view);
        ImageView continueButton = slideView.findViewById(R.id.continue_btn);
        continueButton.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), SlideViewActivity.class);
            startActivity(intent);
        });
        addSlidesListData();
        SlidesAdapter slidesAdapter = new SlidesAdapter(listener, addSlidesListData());
        slideListView.setLayoutManager(new LinearLayoutManager(getContext()));
        slideListView.setHasFixedSize(true);
        slideListView.setAdapter(slidesAdapter);
        return slideView;
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

    public interface OnFragmentInteractionListener {
        void onSlideClicked(int pos, ArrayList<SlidesClass> slides);
    }
}
