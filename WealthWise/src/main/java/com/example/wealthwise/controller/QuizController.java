package com.example.wealthwise.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.wealthwise.model.QuizResponse;
import com.example.wealthwise.service.QuizService;

@Controller
public class QuizController {

    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping("/submit-quiz")
    public String submitQuiz(
            @RequestParam("q1") String q1,
            @RequestParam("q2") String q2,
            @RequestParam("q3") String q3,
            Model model) {

        QuizResponse response = new QuizResponse(q1, q2, q3);
        int score = quizService.calculateScore(response);

        model.addAttribute("score", score);
        return "quiz-results"; // Returns the results page
    }
}
