package com.pragma.powerup.traceability.configuration.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true)
public class MainSecurity {

    @Bean
    public AuthenticationManager authenticationManager(
            //To delete generated password.
            AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.cors().disable()
                .csrf().disable()
                .httpBasic().disable()
                .authorizeHttpRequests(auth ->
                        auth
                                .requestMatchers("/auth/login", "/swagger-ui.html", "/swagger-ui/**",
                                        "/v3/api-docs/**", "/actuator/health")
                                .permitAll()
                                .anyRequest()
                                .authenticated()
                )
                .formLogin().disable()
                .sessionManagement(session ->
                        session
                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .build();
    }
}