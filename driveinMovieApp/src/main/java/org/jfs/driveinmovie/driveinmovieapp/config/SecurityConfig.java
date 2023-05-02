package org.jfs.driveinmovie.driveinmovieapp.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@AllArgsConstructor
public class SecurityConfig {

	private ClientRegistrationRepository clientRegistrationRepository;

	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(AbstractHttpConfigurer::disable)
			.authorizeHttpRequests()
			.requestMatchers("/addMovie" , "/adminCatalog" , "/addSchedule" ,
					"/viewSchedule" , "/updateSchedule" , "/deleteSchedule" ,
					"/saveMovie" , "/updateMovie" , "/deleteMovie").authenticated()
			.anyRequest().permitAll()
			.and()
			.oauth2Login(withDefaults()).logout().logoutUrl("/logout").logoutSuccessUrl("http://localhost:7080/realms/test/protocol/openid-connect/logout");
		return http.build();
	}



}
