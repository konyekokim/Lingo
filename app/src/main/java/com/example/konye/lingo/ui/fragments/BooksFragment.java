package com.example.konye.lingo.ui.fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.konye.lingo.R;
import com.example.konye.lingo.adapters.BooksGridAdapter;
import com.example.konye.lingo.ui.activities.BookActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class BooksFragment extends Fragment {

    View booksView;
    private OnFragmentInteractionListener listener;
    int imageRes[] = {R.drawable.book2, R.drawable.book1, R.drawable.book3, R.drawable.book1, R.drawable.book1,
            R.drawable.book1, R.drawable.book1, R.drawable.book3, R.drawable.book2, R.drawable.book3};
    String names[] = {"Name of books in here", "Name of books in here", "Name of books in here",
            "Name of books in here",
            "Name of books in here", "Name of books in here", "Name of books in here",
            "Name of books in here", "Name of books in here",
            "Name of books in here"};

    public BooksFragment() {
        // Required empty public constructor
    }

    public static BooksFragment newInstance() {
        return new BooksFragment();
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        booksView = inflater.inflate(R.layout.mahadum_books_view, container, false);
        RecyclerView list = booksView.findViewById(R.id.list);
        setRecycler(list);
        return booksView;
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
        BooksGridAdapter adapter = new BooksGridAdapter(listener, imageRes, names);
        view.setAdapter(adapter);
    }

    public interface OnFragmentInteractionListener {
        void onBookClicked();
    }
}
