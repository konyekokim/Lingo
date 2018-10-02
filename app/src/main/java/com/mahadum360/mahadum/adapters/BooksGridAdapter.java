package com.mahadum360.mahadum.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mahadum360.mahadum.R;
import com.mahadum360.mahadum.ui.fragments.BooksFragment.OnFragmentInteractionListener;


/**
 * Created by Abdul on 23/09/2018.
 */

public class BooksGridAdapter extends RecyclerView.Adapter<BooksGridAdapter.ViewHolder>{
    private int imageRes[];
    private String names[];
    private OnFragmentInteractionListener listener;
    public BooksGridAdapter(OnFragmentInteractionListener listener, int imageRes[], String names[]){
        this.listener = listener;
        this.imageRes = imageRes;
        this.names = names;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.grid_book_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int pos) {
        holder.bookImage.setImageResource(imageRes[pos]);
        holder.bookText.setText(names[pos]);

        holder.v.setOnClickListener(t -> {
            if (listener != null)
                listener.onBookClicked();
        });
    }

    @Override
    public int getItemCount() {
        return imageRes.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView bookImage;
        TextView bookText;
        View v;
        ViewHolder(View v) {
            super(v);
            bookImage = v.findViewById(R.id.books_imgView);
            bookText = v.findViewById(R.id.books_textView);
            this.v = v;
        }
    }
}
