package com.example.fromtui.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests()
				.requestMatchers("/admin", "/hello").authenticated()
                .anyRequest().permitAll()
                .and()
                .oauth2Login(Customizer.withDefaults());
        return httpSecurity.build();
    }


}
