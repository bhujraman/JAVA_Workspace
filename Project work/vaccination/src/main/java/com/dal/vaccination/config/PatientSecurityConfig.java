package com.dal.vaccination.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity(debug = true)
public class PatientSecurityConfig {
	@Autowired
	PatientAuthProvider patientAuthProvider;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests().requestMatchers("/welcome/**").permitAll().requestMatchers("/addPatient/**")
				.permitAll().requestMatchers("/deletePatient/**").permitAll().requestMatchers("/updatePatient/**")
				.authenticated().requestMatchers("/welcomevaccinemaster/**").permitAll()
				.requestMatchers("/addPatientVaccination/**").authenticated()
				.requestMatchers("/getAllVaccinatedList/**").permitAll()
				.requestMatchers("/getVaccinationByPatientId/**").permitAll().requestMatchers("/addVaccineMaster/**")
				.permitAll()
				.requestMatchers("/v2/api-docs", "/v3/api-docs/**", "/swagger-resources/configuration/ui",
						"/swagger-resources/configuration/security", "/webjars/**", "/swagger-ui.html",
						"/swagger-ui/**")
				.permitAll();
		http.httpBasic();
		http.csrf().disable();
		http.cors();
		return http.build();
	}

	@Bean
	public AuthenticationManager authManager(HttpSecurity http) throws Exception {

		AuthenticationManagerBuilder authenticationManagerBuilder = http
				.getSharedObject(AuthenticationManagerBuilder.class);
		authenticationManagerBuilder.authenticationProvider(patientAuthProvider);
		return authenticationManagerBuilder.build();
	}
}
