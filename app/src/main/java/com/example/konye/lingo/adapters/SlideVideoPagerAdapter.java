package com.example.konye.lingo.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.konye.lingo.ui.fragments.SlideFragment;
import com.example.konye.lingo.ui.fragments.VideoFragment;

/**
 * Created by KONYE on 5/18/2017.
 */

public class SlideVideoPagerAdapter extends FragmentPagerAdapter{
    private int numberOfTabs;
    public SlideVideoPagerAdapter(FragmentManager fragmentManager, int numberOfTabs){
        super(fragmentManager);
        this.numberOfTabs = numberOfTabs;
    }
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new SlideFragment();
            case 1:
                return new VideoFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }


}
