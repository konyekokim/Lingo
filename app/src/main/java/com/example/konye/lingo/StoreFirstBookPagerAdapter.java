package com.example.konye.lingo;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * Created by KONYE on 7/12/2017.
 */

public class StoreFirstBookPagerAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;
    View storeFirstBookView;
    ArrayList<StoreFirstBookClass> storeFirstBookClasses;

    public StoreFirstBookPagerAdapter(Context context, ArrayList<StoreFirstBookClass> storeFirstBookClasses){
        this.context = context;
        this.storeFirstBookClasses = storeFirstBookClasses;
    }


    @Override
    public int getCount() {
        return storeFirstBookClasses.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        storeFirstBookView = layoutInflater.inflate(R.layout.store_first_book_item,container,false);
        ImageView browseCategoryImageView = (ImageView) storeFirstBookView.findViewById(R.id.book_first_img_view);
        browseCategoryImageView.setImageResource(storeFirstBookClasses.get(position).getFirstBookImageResource());

        ((ViewPager) container).addView(storeFirstBookView);
        return storeFirstBookView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((LinearLayout)object);
    }
}
