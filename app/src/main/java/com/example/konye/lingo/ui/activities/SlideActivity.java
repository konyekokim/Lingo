package com.example.konye.lingo.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
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

import com.example.konye.lingo.R;
import com.example.konye.lingo.ui.activities.auth.AuthActivity;
import com.example.konye.lingo.utils.SlideManager;

public class SlideActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TextView welcomeSlideTextView, mahadumNamePart, mahadum360part;
    private LinearLayout dotsLayout, mahadumTextLayout;
    private ImageView welcomeMahadumView;
    private Button skipButton, nextButton,signInbutton, signUpbutton;
    private int[] images, backgrounds;
    private String[] languages;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setFullScreen();
        setContentView(R.layout.activity_slide);

        //making all the fonts montserrat.
        //changeWidgetsFont();
        final SlideManager slideManager = new SlideManager(this);
        if(!slideManager.check()){
            Intent intent = new Intent(getApplicationContext(),AuthActivity.class);
            intent.putExtra("where", "login");
            startActivity(intent);
        }
        if(Build.VERSION.SDK_INT>=21){
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE|View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        viewPager = findViewById(R.id.view_pager);
        dotsLayout = findViewById(R.id.layoutDots);
        skipButton = findViewById(R.id.slide_skip);
        nextButton = findViewById(R.id.slide_next);
        signInbutton = findViewById(R.id.slide_welcome_signIn_button);
        signUpbutton = findViewById(R.id.slide_welcome_signUp_button);
        welcomeMahadumView = findViewById(R.id.welcome_mahadum_imgview);
        signInbutton.setVisibility(View.GONE);
        signUpbutton.setVisibility(View.GONE);
        welcomeMahadumView.setVisibility(View.GONE);
        images = new int[]{R.drawable.yoruba,R.drawable.igbo,R.drawable.hausa,
                            R.drawable.french,R.drawable.english};
        backgrounds = new int[]{R.drawable.bg_gradient1, R.drawable.bg_gradient2,
                R.drawable.bg_gradient3, R.drawable.bg_gradient4, R.drawable.bg_gradient5};
        languages = new String[]{"Yoruba", "Igbo", "Hausa", "French", "English"};
        addBottomDots(0);
        changeStatusBarColor();
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(languages, images, backgrounds);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setOnPageChangeListener(viewPageChangeListener);
        skipButton.setOnClickListener(v -> {
         /*viewPager.setCurrentItem(images.length);*/
            skipButton.setVisibility(View.GONE);
            dotsLayout.removeAllViews();
            viewPager.setVisibility(View.GONE);
            signInbutton.setVisibility(View.VISIBLE);
            signUpbutton.setVisibility(View.VISIBLE);
            welcomeMahadumView.setVisibility(View.VISIBLE);
            slideManager.setFirst(false);
        });
        nextButton.setOnClickListener(v -> {
            int currentItemNo = getItem(+1);
            if(currentItemNo < images.length){
                viewPager.setCurrentItem(currentItemNo);
            }else{
                //here currentItemNo == layouts.length hence final page
            }
        });
        signInbutton.setOnClickListener(v -> {
            Intent intent = new  Intent(getApplicationContext(),AuthActivity.class);
            intent.putExtra("where", "login");
            startActivity(intent);
            finish();
        });
        signUpbutton.setOnClickListener(v -> {
            Intent intent = new  Intent(getApplicationContext(),AuthActivity.class);
            intent.putExtra("where", "register");
            startActivity(intent);
            finish();
        });
    }

    private void addBottomDots(int position){
        TextView[] dots = new TextView[images.length];
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
            if(position == images.length-1){
                nextButton.setText("");
                nextButton.setVisibility(View.GONE);
                skipButton.setText(String.valueOf("Finish"));
            } else {
                nextButton.setText(">");
                skipButton.setText(String.valueOf("Skip"));
                nextButton.setVisibility(View.VISIBLE);
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
        private String[] langauges;
        private int[] images, backgrounds;
        public ViewPagerAdapter(String[] languages, int[] images, int[] backgrounds) {
            this.images = images;
            this.backgrounds = backgrounds;
            this.langauges = languages;
        }
        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View v = layoutInflater.inflate(R.layout.slide_screen1, container, false);
            if ((langauges != null && langauges.length > position) &&
                    (images != null && images.length > position)) {
                ((ImageView) v.findViewById(R.id.language_image)).setImageResource(images[position]);
                ((TextView) v.findViewById(R.id.language)).setText(langauges[position]);
                v.findViewById(R.id.parent).setBackgroundResource(backgrounds[position]);
            }
            container.addView(v);
            return v;
        }

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            View v = (View)object;
            container.removeView(v);
        }
    }

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

    private void setFullScreen(){
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}
