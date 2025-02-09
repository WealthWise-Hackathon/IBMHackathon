package com.example.wealthwise.model;

public class QuizResponse {
    private String q1;
    private String q2;
    private String q3;

    public QuizResponse(String q1, String q2, String q3) {
        this.q1 = q1;
        this.q2 = q2;
        this.q3 = q3;
    }

    public String getQ1() {
        return q1;
    }

    public String getQ2() {
        return q2;
    }

    public String getQ3() {
        return q3;
    }
}
