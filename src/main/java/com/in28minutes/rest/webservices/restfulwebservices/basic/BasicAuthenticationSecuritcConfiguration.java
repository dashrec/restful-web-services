package com.in28minutes.rest.webservices.restfulwebservices.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
public class BasicAuthenticationSecuritcConfiguration {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http.authorizeHttpRequests(auth -> auth	
		.requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
				.anyRequest().authenticated() // it will allow only authenticated  users to make requests																

		)
				.httpBasic(Customizer.withDefaults()) // pop up sign in windows in browser
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS) // make session stateLess
																												
				).csrf().disable().build();

	}
}

// enable access to preflight request ->> requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()


// after this we will  be able to make post requests after spring security set up