package com.example.konye.lingo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by KONYE on 7/12/2017.
 */

public class StoreBooksSpecialAdapter extends FragmentPagerAdapter {

    int numberOfTabs;
    public StoreBooksSpecialAdapter(FragmentManager fragmentManager, int numberOfTabs){
        super(fragmentManager);
        this.numberOfTabs = numberOfTabs;
    }
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new WeekBestFragment();
            case 1:
                return new MostRecentFragment();
            case 2:
                return new TopRatedFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }

}
