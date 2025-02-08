package com.example.wealthwise.service;

import com.example.wealthwise.model.User;
import com.example.wealthwise.repo.UserRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//test
@Service
public class UserDetails implements UserDetailsService {
    private UserRepository userRepository;
    public UserDetails(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public org.springframework.security.core.userdetails.UserDetails
    loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return org.springframework.security.core.userdetails.User.
                withUsername(user.getUsername()).password(user.getPassword()).
                roles(user.getRole()).build();
    }
}
