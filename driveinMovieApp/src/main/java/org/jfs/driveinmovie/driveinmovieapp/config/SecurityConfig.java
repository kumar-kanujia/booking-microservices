package org.jfs.driveinmovie.driveinmovieapp.config;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(AbstractHttpConfigurer::disable)
			.authorizeHttpRequests()
			.requestMatchers("/addMovie" , "/adminCatalog" , "/addSchedule" ,
					"/viewSchedule" , "/updateSchedule" , "/deleteSchedule" ,
					"/saveMovie" , "/updateMovie" , "/deleteMovie").authenticated()
			.anyRequest().permitAll()
			.and()
			.oauth2Login(withDefaults());
		return http.build();
	}
}
