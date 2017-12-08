package com.example.konye.lingo;

/**
 * Created by KONYE on 5/22/2017.
 */

public class QuizType2 {
    private int imgQuestion;
    private String question;
    private String ans1, ans2, ans3, ans4;

    public QuizType2(int imgQuestion, String question, String ans1, String ans2, String ans3, String ans4){
        this.imgQuestion = imgQuestion;
        this.question = question;
        this.ans1 = ans1;
        this.ans2 = ans2;
        this.ans3 = ans3;
        this.ans4 = ans4;
    }

    public void setImgQuestion(int imgQuestion){
        this.imgQuestion = imgQuestion;
    }

    public void setQuestion(String question){
        this.question = question;
    }

    public void setans1(String ans1){
        this.ans1 = ans1;
    }

    public void setans2(String ans2){
        this.ans2 = ans2;
    }

    public void setans3(String ans3){
        this.ans3 = ans3;
    }

    public void setans4(String ans4){
        this.ans4 = ans4;
    }

    public int getImgQuestion(){
        return imgQuestion;
    }

    public String getQuestion(){
        return question;
    }

    public String getans1(){
        return ans1;
    }

    public String getans2(){
        return ans2;
    }

    public String getans3(){
        return ans3;
    }

    public String getans4(){
        return ans4;
    }
}
