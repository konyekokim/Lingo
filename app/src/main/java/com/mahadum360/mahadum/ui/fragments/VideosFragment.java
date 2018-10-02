package com.mahadum360.mahadum.ui.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mahadum360.mahadum.R;
import com.mahadum360.mahadum.adapters.VideosGridAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class VideosFragment extends Fragment implements VideosGridAdapter.InteractionListener{

    View videosView;
    private OnFragmentInteractionListener listener;
    int imageRes[] = {R.drawable.book2,R.drawable.book1,R.drawable.book3,R.drawable.book1,R.drawable.book1,
            R.drawable.book1,R.drawable.book1,R.drawable.book3,R.drawable.book2,R.drawable.book2};
    String names[] = {"Name of books in here", "Name of books in here","Name of books in here","Name of books in here",
            "Name of books in here","Name of books in here","Name of books in here","Name of books in here","Name of books in here",
            "Name of books in here"};
    public VideosFragment() {
        // Required empty public constructor
    }

    public static VideosFragment newInstance() {
        return new VideosFragment();
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        videosView = inflater.inflate(R.layout.mahadum_books_view,container, false);
        /*GridView gridView = videosView.findViewById(R.id.gridView);
        VideosGridAdapter gridAdapter = new VideosGridAdapter(listener,imageRes,names);
        gridView.setAdapter(gridAdapter);
        gridView.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent intent = new Intent(getContext(), VideoActivity.class);
            startActivity(intent);
        });*/
        RecyclerView grid = videosView.findViewById(R.id.list);
        setRecycler(grid);
        return videosView;
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

    private void setRecycler(RecyclerView view) {
        view.setLayoutManager(new GridLayoutManager(getContext(), 3,
                LinearLayoutManager.VERTICAL, false));
        view.setHasFixedSize(true);
        VideosGridAdapter adapter = new VideosGridAdapter(this, imageRes, names);
        view.setAdapter(adapter);
    }

    @Override
    public void onVideoClicked() {
        listener.onVideoClicked();
    }


    public interface OnFragmentInteractionListener {
        void onVideoClicked();
    }
}
