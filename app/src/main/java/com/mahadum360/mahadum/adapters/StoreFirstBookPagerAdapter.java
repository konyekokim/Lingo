package com.mahadum360.mahadum.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.mahadum360.mahadum.R;
import com.mahadum360.mahadum.utils.StoreFirstBookClass;

import java.util.ArrayList;

/**
 * Created by KONYE on 7/12/2017.
 */

public class StoreFirstBookPagerAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private View storeFirstBookView;
    private ArrayList<StoreFirstBookClass> storeFirstBookClasses;

    public StoreFirstBookPagerAdapter(Context context, ArrayList<StoreFirstBookClass> storeFirstBookClasses){
        this.context = context;
        this.storeFirstBookClasses = storeFirstBookClasses;
    }


    @Override
    public int getCount() {
        return storeFirstBookClasses.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        storeFirstBookView = layoutInflater.inflate(R.layout.store_first_book_item,container,false);
        ImageView browseCategoryImageView = storeFirstBookView.findViewById(R.id.book_first_img_view);
        browseCategoryImageView.setImageResource(storeFirstBookClasses.get(position).getFirstBookImageResource());

        container.addView(storeFirstBookView);
        return storeFirstBookView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}
