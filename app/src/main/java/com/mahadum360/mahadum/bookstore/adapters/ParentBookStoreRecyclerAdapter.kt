package com.mahadum360.mahadum.bookstore.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mahadum360.mahadum.R
import com.mahadum360.mahadum.bookstore.fragments.ParentStoreFragment.OnFragmentInteractionListener
import com.mahadum360.mahadum.models.Book
import kotlinx.android.extensions.LayoutContainer

class ParentBookStoreRecyclerAdapter(private val books: List<Book>, private val listener: OnFragmentInteractionListener):
        RecyclerView.Adapter<ParentBookStoreRecyclerAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
                LayoutInflater.from(parent.context)
                        .inflate(R.layout.book_grid_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(books[position])
    }

    override fun getItemCount(): Int = books.size

    inner class ViewHolder(override val containerView: View): RecyclerView.ViewHolder(containerView),
            LayoutContainer {
        fun bind(book: Book) {
            containerView.setOnClickListener {
                listener.onBookClicked(book)
            }
        }
    }
}