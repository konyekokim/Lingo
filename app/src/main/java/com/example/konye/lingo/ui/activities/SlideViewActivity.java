package com.example.konye.lingo.ui.activities;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.konye.lingo.R;
import com.example.konye.lingo.utils.SlidesClass;
import com.example.konye.lingo.adapters.SlidesViewPagerAdapter;

import java.util.ArrayList;

public class SlideViewActivity extends AppCompatActivity {

    private ViewPager viewPager;
    TextView  numPageButton;
    ImageView prevButton, nextButton;
    int totalNumOfPages,currentPage;
    String slideText;
    String currentPageAsString, totalNumOfPagesAsString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide_view);
        //changeWidgetsFont();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.lang_action_bar_layout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TextView actionBarTextView = findViewById(R.id.my_text);
        actionBarTextView.setText(String.valueOf("Slides"));

        addSlidesListData();
        //currentPage = getItem(0);
        totalNumOfPages = addSlidesListData().size();
        currentPageAsString = Integer.toString(currentPage + 1);
        totalNumOfPagesAsString = Integer.toString(totalNumOfPages);


        prevButton = findViewById(R.id.slides_view_prev_butn);
        numPageButton = findViewById(R.id.slides_view_num_page);
        nextButton = findViewById(R.id.slides_view_next_butn);
        numPageButton.setText(String.valueOf(currentPageAsString+"/"+totalNumOfPagesAsString));
        prevButton.setVisibility(View.GONE);

        viewPager = findViewById(R.id.slides_view_pager);
        PagerAdapter slidesViewPagerAdapter = new SlidesViewPagerAdapter(this,addSlidesListData());
        viewPager.setAdapter(slidesViewPagerAdapter);
        viewPager.addOnPageChangeListener(viewPageChangeListener);
        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(getPrevItem());
            }
        });
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nextPageNumber = getItem(+1);
                if(nextPageNumber < totalNumOfPages){
                    viewPager.setCurrentItem(nextPageNumber);
                }
            }
        });
    }

    private ArrayList<SlidesClass> addSlidesListData(){
        ArrayList<SlidesClass>  slidesClasses = new ArrayList<>();
        slideText = "good luck learnign this language ... it has a lot of perks dkgs';g dskgdg"
        +"aldkgnlLKSG  DKPADFADMj DJGKSFGnd dfhdgsblfjga jbfgjosf g jbgmsjfglasfg  ddjbgskbfg  sjbd sd fosbd fksjsb s"
        +"sghslfm slsm gllsg  sm gsgbsbojbg;jdfg., dfdnklsngljsjf gmlbsljfagjkbf;glb fjshfuoruop  jdflsfgskjfgf";
        slidesClasses.add(new SlidesClass("Part 1",slideText,R.drawable.slide_img));
        slidesClasses.add(new SlidesClass("Part 2",slideText,R.drawable.red_p));
        slidesClasses.add(new SlidesClass("Part 3",slideText,R.drawable.slide_img));
        return slidesClasses;
    }

    private int getItem(int i){
        return viewPager.getCurrentItem()+1;
    }

    private int getPrevItem(){
        return viewPager.getCurrentItem()-1;
    }

    ViewPager.OnPageChangeListener viewPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            currentPage = position+1;
            currentPageAsString = Integer.toString(currentPage);
            totalNumOfPagesAsString = Integer.toString(totalNumOfPages);
            numPageButton.setText(String.valueOf(currentPageAsString+"/"+totalNumOfPagesAsString));

            if(position == 0){
                prevButton.setVisibility(View.GONE);
            }else{
                prevButton.setVisibility(View.VISIBLE);
            }

            if(position == totalNumOfPages-1){
                nextButton.setVisibility(View.GONE);
            }else{
                nextButton.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    /*private void changeWidgetsFont(){
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Montserrat-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }*/

}
