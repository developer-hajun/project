package com.health.project.Configuration;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@AllArgsConstructor
@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .httpBasic(AbstractHttpConfigurer::disable) // ui로 들어오는것
                .csrf(AbstractHttpConfigurer::disable) // 크로스 사이트
                .httpBasic(AbstractHttpConfigurer::disable) // 크로스 사이트
                .cors(Customizer.withDefaults())
                .authorizeHttpRequests((authorizeRequests)->
                        authorizeRequests
                        .requestMatchers("/login/join").permitAll()//login은 토근 없이 가능
                        .requestMatchers(HttpMethod.POST,"/check/**").authenticated()); // POST요청은 토큰 필요

        return http.build();
    }
}