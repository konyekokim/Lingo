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
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by KONYE on 5/21/2017.
 */

public class SlidesViewPagerAdapter extends PagerAdapter {

    Context context;
    ArrayList<SlidesClass> slidesClasses;
    LayoutInflater layoutInflater;
    View slidesItemView;

    public SlidesViewPagerAdapter(Context context, ArrayList<SlidesClass> slidesClasses){
        this.context = context;
        this.slidesClasses = slidesClasses;
    }

    @Override
    public int getCount() {
        return slidesClasses.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        //declare Variables
        TextView titleView,contentView;
        ImageView imageView;

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        slidesItemView = layoutInflater.inflate(R.layout.slides_view_item,container,false);
        titleView = (TextView) slidesItemView.findViewById(R.id.slides_view_title);
        contentView = (TextView) slidesItemView.findViewById(R.id.slides_view_content);
        imageView = (ImageView) slidesItemView.findViewById(R.id.slides_view_image);

        titleView.setText(slidesClasses.get(position).getSlidesTitle());
        contentView.setText(slidesClasses.get(position).getSlidesSubtitle());
        imageView.setImageResource(slidesClasses.get(position).getImgThumbnail());

        titleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(slidesItemView.getContext(), LoginActivity.class);
                slidesItemView.getContext().startActivity(intent);
            }
        });
        ((ViewPager) container).addView(slidesItemView);

        return slidesItemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((LinearLayout)object);
    }

    private ArrayList<SlidesClass> addSlidesListData(){
         slidesClasses = new ArrayList<>();
        slidesClasses.add(new SlidesClass("Part 1","Introduction",R.drawable.afghanistan));
        slidesClasses.add(new SlidesClass("Part 2","after Introduction",R.drawable.japan));
        slidesClasses.add(new SlidesClass("Part 3","2nd Stage",R.drawable.madagascar));
        return slidesClasses;
    }
}
