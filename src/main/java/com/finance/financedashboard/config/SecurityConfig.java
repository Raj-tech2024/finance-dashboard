package com.finance.financedashboard.config;

import com.finance.financedashboard.security.JwtFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtFilter jwtFilter;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth

                        // 🔓 Public
                        .requestMatchers("/auth/**").permitAll()

                        // 🔓 Swagger access
                        .requestMatchers(
                                "/swagger-ui/**",
                                "/v3/api-docs/**"
                        ).permitAll()

                        // 👤 ADMIN only
                        .requestMatchers("/user/**").hasRole("ADMIN")

                        // 📊 Dashboard
                        .requestMatchers("/dashboard/**").hasAnyRole("ADMIN", "ANALYST")

                        // 💰 Records
                        .requestMatchers("/records/**").hasAnyRole("ADMIN", "ANALYST", "VIEWER")

                        // 🔒 Everything else
                        .anyRequest().authenticated()
                )

                // 🔥 JWT Filter
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
