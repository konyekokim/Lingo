package com.example.konye.lingo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class SlideActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TextView welcomeSlideTextView, mahadumNamePart, mahadum360part;
    private LinearLayout dotsLayout, mahadumTextLayout;
    private ImageView welcomeMahadumView;
    private Button skipButton, nextButton,signInbutton, signUpbutton;
    private int[] layouts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide);
        setFullScreen();
        //making all the fonts montserrat.
        changeWidgetsFont();
        SlideManager slideManager = new SlideManager(this);
        if(!slideManager.check()){
            slideManager.setFirst(false);
            Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
            startActivity(intent);
        }
        if(Build.VERSION.SDK_INT>=21){
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE|View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        dotsLayout = (LinearLayout) findViewById(R.id.layoutDots);
        skipButton = (Button) findViewById(R.id.slide_skip);
        nextButton = (Button) findViewById(R.id.slide_next);
        signInbutton = (Button) findViewById(R.id.slide_welcome_signIn_button);
        signUpbutton = (Button) findViewById(R.id.slide_welcome_signUp_button);
        welcomeMahadumView = (ImageView) findViewById(R.id.welcome_mahadum_imgview);
        signInbutton.setVisibility(View.GONE);
        signUpbutton.setVisibility(View.GONE);
        welcomeMahadumView.setVisibility(View.GONE);
        layouts = new int[]{R.layout.slide_screen1,R.layout.slide_screen2,R.layout.slide_screen3,
                            R.layout.slide_screen4,R.layout.slide_screen5,R.layout.slide_welcome};
        addBottomDots(0);
        changeStatusBarColor();
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter();
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setOnPageChangeListener(viewPageChangeListener);
        skipButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
             viewPager.setCurrentItem(layouts.length);
            }
        });
        nextButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int currentItemNo = getItem(+1);
                if(currentItemNo < layouts.length){
                    viewPager.setCurrentItem(currentItemNo);
                }else{
                    //here currentItemNo == layouts.length hence final page
                }
            }
        });
        signInbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new  Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
        signUpbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new  Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void addBottomDots(int position){
        TextView[] dots = new TextView[layouts.length];
        int[] colorActive = getResources().getIntArray(R.array.dot_active);
        int[] colorInActive = getResources().getIntArray(R.array.dot_inactive);
        dotsLayout.removeAllViews();
        for(int i = 0; i < dots.length; i++){
            dots[i] = new TextView(this);
            dots[i].setText(".");
            dots[i].setTextSize(35);
            dots[i].setTextColor(colorInActive[position]);
            dotsLayout.addView(dots[i]);
        }
        if(dots.length>0){
            dots[position].setTextColor(colorActive[position]);
        }
    }

    private int getItem(int i){
        return viewPager.getCurrentItem()+1;
    }

    ViewPager.OnPageChangeListener viewPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addBottomDots(position);
            if(position==layouts.length-1){
                nextButton.setText("");
                skipButton.setVisibility(View.GONE);
                dotsLayout.removeAllViews();
                signInbutton.setVisibility(View.VISIBLE);
                signUpbutton.setVisibility(View.VISIBLE);
                welcomeMahadumView.setVisibility(View.VISIBLE);
            }else{
                nextButton.setText(">");
                skipButton.setVisibility(View.VISIBLE);
                signInbutton.setVisibility(View.GONE);
                signUpbutton.setVisibility(View.GONE);
                welcomeMahadumView.setVisibility(View.GONE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    public void changeStatusBarColor(){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }

    public class ViewPagerAdapter extends PagerAdapter{
        private LayoutInflater layoutInflater;
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View v = layoutInflater.inflate(layouts[position], container, false);
            container.addView(v);
            return v;
        }

        @Override
        public int getCount() {
            return layouts.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View v = (View)object;
            container.removeView(v);
        }
    }

    private void changeWidgetsFont(){
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("Montserrat-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    private void setFullScreen(){
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}
