package com.mahadum360.mahadum.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.mahadum360.mahadum.ui.fragments.DetailsFragment;
import com.mahadum360.mahadum.ui.fragments.RelatedFragment;
import com.mahadum360.mahadum.ui.fragments.ReviewsFragment;


/**
 * Created by KONYE on 7/14/2017.
 */

public class BookActivitySpecialAdapter extends FragmentPagerAdapter {

    int numberOfTabs;
    public BookActivitySpecialAdapter(FragmentManager fragmentManager, int numberOfTabs){
        super(fragmentManager);
        this.numberOfTabs = numberOfTabs;
    }
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new DetailsFragment();
            case 1:
                return new ReviewsFragment();
            case 2:
                return new RelatedFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }

}
