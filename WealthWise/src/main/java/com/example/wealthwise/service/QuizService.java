package com.example.wealthwise.service;

import com.example.wealthwise.model.QuizResponse;
import com.example.wealthwise.model.User;
import com.example.wealthwise.repo.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class QuizService {

    private final UserRepository userRepository;

    public QuizService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public int calculateScore(QuizResponse response) {
        int score = 0;

        // Correct answers
        if ("b".equals(response.getQ1())) score++; // Stock definition
        if ("b".equals(response.getQ2())) score++; // 50/30/20 rule
        if ("a".equals(response.getQ3())) score++; // Bitcoin as digital gold

        // Save score to database for logged-in user
        saveScoreForUser(score);
        return score;
    }
    private void saveScoreForUser(int score) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.getPrincipal() instanceof org.springframework.security.core.userdetails.UserDetails userDetails) {
            String username = userDetails.getUsername(); // Get the username from Spring Security

            User user = userRepository.findByUsername(username); // Fetch the actual User entity
            if (user != null) {
                user.setScore(score);
                userRepository.save(user); // Save the updated score
            }
        }
    }
}
