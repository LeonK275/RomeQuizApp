package com.leon.romequizapp;

import java.util.ArrayList;
import java.util.List;

public class QuizQuestion {

    private int questionID;
    private String question;
    private List<String> options = new ArrayList<>();
    private int correct;

    public QuizQuestion(int questionID, String question, List<String> options, int correct) {
        this.questionID = questionID;
        this.question = question;
        this.options = options;
        this.correct = correct;
    }


    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public int getCorrect() {
        return correct;
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }


}
