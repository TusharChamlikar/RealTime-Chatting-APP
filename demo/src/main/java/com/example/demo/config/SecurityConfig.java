package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.example.demo.security.JwtFilter;

@Configuration
public class SecurityConfig {
    private final JwtFilter jwtFilter;

    public SecurityConfig(JwtFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }
   @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth

                 .requestMatchers("/messages/**").permitAll()
                .requestMatchers("/online/**").permitAll()
                .requestMatchers("/chat/**").permitAll()
                .requestMatchers("/users/**").permitAll()
                .requestMatchers("/auth/**").permitAll() // allow login
                .anyRequest().authenticated() // protect others
            )
            .addFilterBefore(jwtFilter, 
                org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}