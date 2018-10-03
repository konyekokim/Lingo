package com.mahadum360.mahadum.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mahadum360.mahadum.R;
import com.mahadum360.mahadum.auth.LoginFragment;
import com.mahadum360.mahadum.utils.SlidesClass;

import java.util.ArrayList;

/**
 * Created by KONYE on 5/21/2017.
 */

public class SlidesViewPagerAdapter extends PagerAdapter {

    private Context context;
    private ArrayList<SlidesClass> slidesClasses;
    private LayoutInflater layoutInflater;
    private View slidesItemView;

    public SlidesViewPagerAdapter(Context context, ArrayList<SlidesClass> slidesClasses){
        this.context = context;
        this.slidesClasses = slidesClasses;
    }

    @Override
    public int getCount() {
        return slidesClasses.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        //declare Variables
        TextView titleView,contentView;
        ImageView imageView;

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        slidesItemView = layoutInflater.inflate(R.layout.slides_view_item,container,false);
        titleView = slidesItemView.findViewById(R.id.slides_view_title);
        contentView = slidesItemView.findViewById(R.id.slides_view_content);
        imageView = slidesItemView.findViewById(R.id.slides_view_image);

        titleView.setText(slidesClasses.get(position).getSlidesTitle());
        contentView.setText(slidesClasses.get(position).getSlidesSubtitle());
        imageView.setImageResource(slidesClasses.get(position).getImgThumbnail());

        titleView.setOnClickListener(v -> {
            Intent intent = new Intent(slidesItemView.getContext(), LoginFragment.class);
            slidesItemView.getContext().startActivity(intent);
        });
        container.addView(slidesItemView);

        return slidesItemView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }

    private ArrayList<SlidesClass> addSlidesListData(){
         slidesClasses = new ArrayList<>();
        slidesClasses.add(new SlidesClass("Part 1","Introduction",R.drawable.afghanistan));
        slidesClasses.add(new SlidesClass("Part 2","after Introduction",R.drawable.japan));
        slidesClasses.add(new SlidesClass("Part 3","2nd Stage",R.drawable.madagascar));
        return slidesClasses;
    }
}
