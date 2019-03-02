package com.mahadum360.mahadum.bookstore.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class BookStoreViewPagerAdapter(fm: FragmentManager): FragmentPagerAdapter(fm) {

    private var fragments: ArrayList<Fragment> = ArrayList()

    private var fragmentTitles: ArrayList<String> = ArrayList()


    fun addFragment(fr: Fragment, title: String) {
        fragments.add(fr)
        fragmentTitles.add(title)
    }

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return fragmentTitles[position]
    }

}