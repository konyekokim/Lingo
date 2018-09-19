package com.example.konye.lingo.ui.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
    int imageRes[] = {R.drawable.book2,R.drawable.book1,R.drawable.book3,R.drawable.book1,R.drawable.book1,
            R.drawable.book1,R.drawable.book1,R.drawable.book3,R.drawable.book2,R.drawable.book3};
    String names[] = {"Name of books in here", "Name of books in here","Name of books in here","Name of books in here",
            "Name of books in here","Name of books in here","Name of books in here","Name of books in here","Name of books in here",
            "Name of books in here"};
    public BooksFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        booksView = inflater.inflate(R.layout.mahadum_books_view,container, false);
        GridView gridView = booksView.findViewById(R.id.gridView);
        BooksGridAdapter gridAdapter = new BooksGridAdapter(getContext(),imageRes,names);
        gridView.setAdapter(gridAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getContext(), BookActivity.class);
                startActivity(intent);
            }
        });
        return booksView;
    }
}
