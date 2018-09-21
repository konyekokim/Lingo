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

import com.example.konye.lingo.utils.QuizType1;
import com.example.konye.lingo.R;
import com.example.konye.lingo.adapters.QuizViewPagerAdapter;

import java.util.ArrayList;

public class QuizViewActivity extends AppCompatActivity {

    ArrayList<QuizType1> quizType1list;
    //ArrayList<QuizType2> quizType2list;
    ViewPager quizViewPager;
    ImageView nextQuizButton;
    int totalNumPages;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_view);
        //changeWidgetsFont();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.lang_action_bar_layout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TextView actionBarTextView = findViewById(R.id.my_text);
        actionBarTextView.setText(String.valueOf("Quiz"));
        quizType1s();
        totalNumPages = quizType1list.size();

        nextQuizButton = findViewById(R.id.quiz_view_next_butn);
        quizViewPager = findViewById(R.id.quiz_view_pager);
        PagerAdapter quizViewPagerAdapter = new QuizViewPagerAdapter(this, quizType1list);
        quizViewPager.setAdapter(quizViewPagerAdapter);
        quizViewPager.addOnPageChangeListener(viewPageChangeListener);
        nextQuizButton.setVisibility(View.VISIBLE);

        nextQuizButton.setOnClickListener(v -> {
            int nextPageNum = getItem(+1);
            if(nextPageNum < totalNumPages){
                quizViewPager.setCurrentItem(nextPageNum);
            }
        });
    }

    private ArrayList<QuizType1> quizType1s(){
        quizType1list = new ArrayList<>();
        quizType1list.add(new QuizType1("Which language is the most renowned and occupies your heart?",
                R.drawable.question_img,  R.drawable.question_img, R.drawable.question_img, R.drawable.question_img));
        quizType1list.add(new QuizType1("what is growth process and how can it affect our economy?",
                R.drawable.question_img, R.drawable.question_img, R.drawable.question_img, R.drawable.question_img));
        quizType1list.add(new QuizType1("what is the left side of the right over grown plantain? and" +
                "how many times will i eat cow?", R.drawable.question_img, R.drawable.question_img, R.drawable.question_img,
                R.drawable.question_img));
        return quizType1list;
    }

    private int getItem(int i){
        return quizViewPager.getCurrentItem() + 1;
    }

    ViewPager.OnPageChangeListener viewPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
           if(position == totalNumPages-1){
               nextQuizButton.setVisibility(View.GONE);
           }else{
               nextQuizButton.setVisibility(View.VISIBLE);
           }
        }

        @Override
        public void onPageScrollStateChanged(int state){

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

   /* private ArrayList<QuizType2> quizType2s(){
        quizType2list = new ArrayList<>();
        quizType2list.add(new QuizType2(R.drawable.nigeria,"why shall man not live by bread alone?","to eat",
                "to die","to live longer", "to buy tooth paste"));
        quizType2list.add(new QuizType2(R.drawable.nigeria,"why shall man not live by bread alone?","to eat",
                "to die","to live longer", "to tooth paste"));
        quizType2list.add(new QuizType2(R.drawable.nigeria,"why shall girls not live by bread alone?","to eat",
                "to die","to no longer", "to buy tooth paste"));
        quizType2list.add(new QuizType2(R.drawable.nigeria,"why shall boys not live by bread alone?","to eat",
                "to fly","to live longer", "to buy tooth paste"));
        return quizType2list;
    }*/
}
