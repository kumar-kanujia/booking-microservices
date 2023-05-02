package com.example.gateway.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        http.authorizeExchange(exchanges -> exchanges.pathMatchers("/TEST/admin/**").authenticated()
                        .pathMatchers("/TEST/hello/**").permitAll())
                .oauth2ResourceServer().jwt();
        http.csrf(ServerHttpSecurity.CsrfSpec::disable);
        return http.build();
    }

}
