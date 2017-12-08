package com.example.konye.lingo;

/**
 * Created by KONYE on 5/22/2017.
 */

public class QuizType1 {

    private String question;
    private int imgAns1, imgAns2, imgAns3, imgAns4;


    public QuizType1(String question, int imgAns1, int imgAns2, int imgAns3, int imgAns4){
        this.question = question;
        this.imgAns1 = imgAns1;
        this.imgAns2 = imgAns2;
        this.imgAns3 = imgAns3;
        this.imgAns4 = imgAns4;
    }

    public void setQuestion(String question){
        this.question = question;
    }

    public void setImgAns1(int imgAns1){
        this.imgAns1 = imgAns1;
    }

    public void setImgAns2(int imgAns2){
        this.imgAns2 = imgAns2;
    }

    public void setImgAns3(int imgAns3){
        this.imgAns3 = imgAns3;
    }

    public void setImgAns4(int imgAns4){
        this.imgAns4 = imgAns4;
    }

    public String getQuestion(){
        return question;
    }

    public int getImgAns1(){
        return imgAns1;
    }

    public int getImgAns2(){
        return imgAns2;
    }

    public int getImgAns3(){
        return imgAns3;
    }

    public int getImgAns4(){
        return imgAns4;
    }
}
