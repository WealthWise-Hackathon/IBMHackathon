package com.example.wealthwise.model;


import jakarta.persistence.*;

@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String username;
    private String password;
    private String role;
    private int score;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
