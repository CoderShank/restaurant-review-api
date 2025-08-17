package com.hotel.restaurant_review_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    http.csrf(csrf -> csrf.disable())
	        .authorizeHttpRequests(auth -> auth
	            // Permit Swagger/OpenAPI endpoints and H2 console
	        	.requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui/index.html", "/h2-console/**").permitAll()

	            // Allow GET requests to /api/** without auth
	            .requestMatchers(HttpMethod.GET, "/api/**").permitAll()
	            // All other requests need authentication
	            .anyRequest().authenticated()
	        )
	        .httpBasic(Customizer.withDefaults());

	    // Disable frame options to allow H2 console
	    http.headers(h -> h.frameOptions(f -> f.disable()));

	    return http.build();
	}


@Bean
UserDetailsService users(PasswordEncoder enc){
 return new InMemoryUserDetailsManager(
   User.withUsername("user").password(enc.encode("user123")).roles("USER").build(),
   User.withUsername("admin").password(enc.encode("admin123")).roles("ADMIN").build()
 );
}

@Bean PasswordEncoder passwordEncoder(){ return PasswordEncoderFactories.createDelegatingPasswordEncoder(); }
}

