package com.example.konye.lingo;

import android.content.Context;
import android.content.Intent;
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

public class BrowseCategoryPagerAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;
    View browseCategoryView;
    ArrayList<BrowseCategoriesClass> browseCategoriesClasses;

    public BrowseCategoryPagerAdapter(Context context, ArrayList<BrowseCategoriesClass> browseCategoriesClasses){
        this.context = context;
        this.browseCategoriesClasses = browseCategoriesClasses;
    }


    @Override
    public int getCount() {
        return browseCategoriesClasses.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        browseCategoryView = layoutInflater.inflate(R.layout.browse_categories_item,container,false);
        ImageView browseCategoryImageView = (ImageView) browseCategoryView.findViewById(R.id.browse_category_image_view);
        browseCategoryImageView.setImageResource(browseCategoriesClasses.get(position).getCategoryImageResource());
        browseCategoryImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(browseCategoryView.getContext(), BookActivity.class);
                browseCategoryView.getContext().startActivity(intent);
            }
        });
        ((ViewPager) container).addView(browseCategoryView);
        return browseCategoryView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((LinearLayout)object);
    }
}
