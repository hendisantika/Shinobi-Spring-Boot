package com.santika.hendi.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/webjars/**", "/css/**", "/js/**", "/images/**").permitAll()
                        .requestMatchers("/", "/shinobis", "/shinobis/**", "/shinobi/**").permitAll()
                        .requestMatchers("/h2/console/**").permitAll());
        httpSecurity.csrf(AbstractHttpConfigurer::disable);
        httpSecurity.headers().frameOptions().disable();
        return httpSecurity.build();
    }

}
