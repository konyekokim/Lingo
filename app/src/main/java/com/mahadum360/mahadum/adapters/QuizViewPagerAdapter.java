package com.mahadum360.mahadum.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mahadum360.mahadum.R;
import com.mahadum360.mahadum.utils.QuizType1;

import java.util.ArrayList;

/**
 * Created by KONYE on 5/22/2017.
 */

public class QuizViewPagerAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private ArrayList<QuizType1> quizType1list;
    private ImageView imgAns1, imgAns2, imgAns3, imgAns4,ans1,ans2, ans3, ans4;
    private TextView quizViewTitle, questionItem1, questionItem2;
    private int quizPosition;
    private String quizNum;
   // ArrayList<QuizType2> quizType2list;

    public QuizViewPagerAdapter(Context context, ArrayList<QuizType1> quizType1ArrayList){
        this.context =  context;
        this.quizType1list = quizType1ArrayList;
      //this.quizType2list = quizType2ArrayList;
    }

    @Override
    public int getCount() {
        return quizType1list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        final View quizItemView;

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        quizItemView = layoutInflater.inflate(R.layout.quiz_view_item,container,false);
        quizViewTitle = quizItemView.findViewById(R.id.quiz_view_title);
        questionItem1 = quizItemView.findViewById(R.id.quiz_view_question);
        imgAns1 = quizItemView.findViewById(R.id.img_ans_1);
        imgAns2 = quizItemView.findViewById(R.id.img_ans_2);
        imgAns3 = quizItemView.findViewById(R.id.img_ans_3);
        imgAns4 = quizItemView.findViewById(R.id.img_ans_4);

        quizNumber(position);
        quizNum = Integer.toString(quizPosition);

        quizViewTitle.setText("Question " + quizNum);
        questionItem1.setText(quizType1list.get(position).getQuestion());
        imgAns1.setImageResource(quizType1list.get(position).getImgAns1());
        imgAns2.setImageResource(quizType1list.get(position).getImgAns2());
        imgAns3.setImageResource(quizType1list.get(position).getImgAns3());
        imgAns4.setImageResource(quizType1list.get(position).getImgAns4());

        imgAns1.setOnClickListener(v -> {
            ans1 = quizItemView.findViewById(R.id.ans1);
            ans2 = quizItemView.findViewById(R.id.ans2);
            ans3 = quizItemView.findViewById(R.id.ans3);
            ans4 = quizItemView.findViewById(R.id.ans4);
            ans1.setVisibility(View.VISIBLE);
            ans2.setVisibility(View.VISIBLE);
            ans3.setVisibility(View.VISIBLE);
            ans4.setVisibility(View.VISIBLE);
        });
        imgAns2.setOnClickListener(v -> {
            ans1 = quizItemView.findViewById(R.id.ans1);
            ans2 = quizItemView.findViewById(R.id.ans2);
            ans3 = quizItemView.findViewById(R.id.ans3);
            ans4 = quizItemView.findViewById(R.id.ans4);
            ans1.setVisibility(View.VISIBLE);
            ans2.setVisibility(View.VISIBLE);
            ans3.setVisibility(View.VISIBLE);
            ans4.setVisibility(View.VISIBLE);
        });
        imgAns3.setOnClickListener(v -> {
            ans1 = quizItemView.findViewById(R.id.ans1);
            ans2 = quizItemView.findViewById(R.id.ans2);
            ans3 = quizItemView.findViewById(R.id.ans3);
            ans4 = quizItemView.findViewById(R.id.ans4);
            ans1.setVisibility(View.VISIBLE);
            ans2.setVisibility(View.VISIBLE);
            ans3.setVisibility(View.VISIBLE);
            ans4.setVisibility(View.VISIBLE);
        });
        imgAns4.setOnClickListener(v -> {
            ans1 = quizItemView.findViewById(R.id.ans1);
            ans2 = quizItemView.findViewById(R.id.ans2);
            ans3 = quizItemView.findViewById(R.id.ans3);
            ans4 = quizItemView.findViewById(R.id.ans4);
            ans1.setVisibility(View.VISIBLE);
            ans2.setVisibility(View.VISIBLE);
            ans3.setVisibility(View.VISIBLE);
            ans4.setVisibility(View.VISIBLE);
        });

        container.addView(quizItemView);

        return quizItemView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout) object);
    }

    private int quizNumber(int pos){
            this.quizPosition = pos + 1;
        return quizPosition;
    }

    private ArrayList<QuizType1> quizType1s(){
        quizType1list = new ArrayList<>();
        quizType1list.add(new QuizType1("what is the process of fighting a cow? and also cheating",
                R.drawable.nigeria,  R.drawable.canada, R.drawable.japan, R.drawable.madagascar));
        quizType1list.add(new QuizType1("what is growth process and how can it affect our economy?",
                R.drawable.japan, R.drawable.switzerland, R.drawable.italy, R.drawable.france));
        quizType1list.add(new QuizType1("what is the left side of the right over grown plantain? and" +
                "how many times will i eat cow?", R.drawable.afghanistan, R.drawable.nigeria, R.drawable.italy,
                R.drawable.madagascar));
        return quizType1list;
    }

}
