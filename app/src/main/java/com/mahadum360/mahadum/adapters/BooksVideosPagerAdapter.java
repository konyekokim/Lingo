package com.mahadum360.mahadum.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.mahadum360.mahadum.ui.fragments.BooksFragment;
import com.mahadum360.mahadum.ui.fragments.VideosFragment;


/**
 * Created by KONYE on 5/18/2017.
 */

public class BooksVideosPagerAdapter extends FragmentPagerAdapter{
    int numberOfTabs;
    public BooksVideosPagerAdapter(FragmentManager fragmentManager, int numberOfTabs){
        super(fragmentManager);
        this.numberOfTabs = numberOfTabs;
    }
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new BooksFragment();
            case 1:
                return new VideosFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }


}
