package com.example.wealthwise.service;

import com.example.wealthwise.model.QuizResponse;
import org.springframework.stereotype.Service;

@Service
public class QuizService {

    public int calculateScore(QuizResponse response) {
        int score = 0;

        // Correct answers
        if ("b".equals(response.getQ1())) score++; // Stock definition
        if ("b".equals(response.getQ2())) score++; // 50/30/20 rule
        if ("a".equals(response.getQ3())) score++; // Bitcoin as digital gold

        return score;
    }
}
