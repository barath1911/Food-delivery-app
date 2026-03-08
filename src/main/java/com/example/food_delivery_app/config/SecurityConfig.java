package com.example.food_delivery_app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

	 private final JwtAuthenticationFilter jwtFilter;
	 private final CustomAccessDeniedHandler accessDeniedHandler;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http.csrf(csrf -> csrf.disable())
		.authorizeHttpRequests(auth-> auth
				.requestMatchers("/api/users/register","/api/users/login").permitAll()
				.requestMatchers("/restaurants/**").hasRole("OWNER")
				.requestMatchers("/foodmenu/**").hasRole("OWNER")
				.requestMatchers("/orders/**").hasRole("USER")
				.requestMatchers("/payments/**").hasRole("USER")
				.anyRequest().authenticated()
				)
		.exceptionHandling(ex -> ex
		        .accessDeniedHandler(accessDeniedHandler)) //custom errors
		.addFilterBefore(jwtFilter,
                UsernamePasswordAuthenticationFilter.class)
		.formLogin(form -> form.disable())
		.httpBasic(httpBasic->httpBasic.disable());

		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
}
