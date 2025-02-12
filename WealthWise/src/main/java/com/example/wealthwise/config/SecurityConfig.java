package com.example.wealthwise.config;

import com.example.wealthwise.service.UserDetails;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserDetails userDetails;

    public SecurityConfig(UserDetails UserDetails) {
        this.userDetails = UserDetails;
    }

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()).authorizeHttpRequests(request ->
                        request.requestMatchers("/register", "/login").permitAll().anyRequest().authenticated()).
                formLogin(form -> form.loginPage("/login").loginProcessingUrl("/login").
                        defaultSuccessUrl("/home", true).permitAll()).logout(logout ->
                        logout.logoutSuccessUrl("/login").permitAll()).userDetailsService(userDetails);
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
