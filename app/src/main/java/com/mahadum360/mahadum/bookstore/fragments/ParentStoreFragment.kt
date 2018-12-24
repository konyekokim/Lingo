package com.mahadum360.mahadum.bookstore.fragments

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v4.content.res.ResourcesCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mahadum360.mahadum.R
import kotlinx.android.synthetic.main.fragment_parent_store.*

class ParentStoreFragment : Fragment() {
    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_parent_store, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindListeners()
    }

    private fun bindListeners() {
        recommended.setOnClickListener {
            recommended.typeface = ResourcesCompat.getFont(context!!, R.font.montserrat_semi_bold)
            recommended.setTextColor(ContextCompat.getColor(context!!, R.color.colorPrimary))
            bestSellers.typeface = ResourcesCompat.getFont(context!!, R.font.montserrat_regular)
            bestSellers.setTextColor(ContextCompat.getColor(context!!, R.color.text_color))
            mostRecent.typeface = ResourcesCompat.getFont(context!!, R.font.montserrat_regular)
            mostRecent.setTextColor(ContextCompat.getColor(context!!, R.color.text_color))
        }

        bestSellers.setOnClickListener {
            recommended.typeface = ResourcesCompat.getFont(context!!, R.font.montserrat_regular)
            recommended.setTextColor(ContextCompat.getColor(context!!, R.color.text_color))
            bestSellers.typeface = ResourcesCompat.getFont(context!!, R.font.montserrat_semi_bold)
            bestSellers.setTextColor(ContextCompat.getColor(context!!, R.color.colorPrimary))
            mostRecent.typeface = ResourcesCompat.getFont(context!!, R.font.montserrat_regular)
            mostRecent.setTextColor(ContextCompat.getColor(context!!, R.color.text_color))
        }

        mostRecent.setOnClickListener {
            recommended.typeface = ResourcesCompat.getFont(context!!, R.font.montserrat_regular)
            recommended.setTextColor(ContextCompat.getColor(context!!, R.color.text_color))
            bestSellers.typeface = ResourcesCompat.getFont(context!!, R.font.montserrat_regular)
            bestSellers.setTextColor(ContextCompat.getColor(context!!, R.color.text_color))
            mostRecent.typeface = ResourcesCompat.getFont(context!!, R.font.montserrat_semi_bold)
            mostRecent.setTextColor(ContextCompat.getColor(context!!, R.color.colorPrimary))
        }
    }

    private fun setViews() {
        progressBar.visibility = View.VISIBLE

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }


    interface OnFragmentInteractionListener {

        fun getRecommended()

        fun getMostRecent()

        fun getBestSellers()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment ParentStoreFragment.
         */

        @JvmStatic
        fun newInstance() =
                ParentStoreFragment().apply {
                    arguments = Bundle().apply {

                    }
                }
    }
}
