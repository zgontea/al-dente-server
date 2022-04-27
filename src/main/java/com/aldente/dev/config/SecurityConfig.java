package com.aldente.dev.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.aldente.dev.repo.UserRepo;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private final ObjectMapper objectMapper;
	private final RestAuthenticationSuccessHandler successHandler;
	private final RestAuthenticationFailureHandler failureHandler;
	private final UserRepo userRepo;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(username -> userRepo
				.findByEmail(username)
				.orElseThrow(
						() -> new UsernameNotFoundException(
                                String.format("User: %s, not found", username)
						)
				)).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http = http.cors().and().csrf().disable();
		http.httpBasic();
		http.authorizeRequests()
				.antMatchers("/swagger-ui/index.html#/").permitAll()
				.antMatchers("/webjars/**").permitAll()
				.antMatchers("/swagger-resources/**").permitAll()

				.antMatchers(HttpMethod.GET, "/api/users/id").hasAuthority("ADMIN")
				.antMatchers(HttpMethod.GET, "/api/users/").hasAuthority("ADMIN")
				.antMatchers(HttpMethod.GET, "/api/users/all").hasAuthority("ADMIN")
				.antMatchers(HttpMethod.GET, "/api/users/all").permitAll()
				.antMatchers(HttpMethod.POST, "/api/users/save").permitAll()
				.antMatchers(HttpMethod.DELETE, "/api/users/del").permitAll()

				.antMatchers(HttpMethod.GET, "/api/patients/id").permitAll()
				.antMatchers(HttpMethod.GET, "/api/patients/").permitAll()
				.antMatchers(HttpMethod.GET, "/api/patients/all").permitAll()
				.antMatchers(HttpMethod.POST, "/api/patients/save").permitAll()//hasAuthority("ADMIN")
				.antMatchers(HttpMethod.DELETE, "/api/patients/del").hasAuthority("ADMIN")

				.antMatchers(HttpMethod.GET, "/api/appointments/id").permitAll()
				.antMatchers(HttpMethod.GET, "/api/appointments/").permitAll()
				.antMatchers(HttpMethod.GET, "/api/appointments/all").permitAll()
				.antMatchers(HttpMethod.POST, "/api/appointments/save").permitAll()//hasAuthority("ADMIN")
				.antMatchers(HttpMethod.DELETE, "/api/appointments/del").hasAuthority("ADMIN")

				.antMatchers(HttpMethod.GET, "/api/toothings/id").permitAll()
				.antMatchers(HttpMethod.GET, "/api/toothings/").permitAll()
				.antMatchers(HttpMethod.GET, "/api/toothings/all").permitAll()
				.antMatchers(HttpMethod.POST, "/api/toothings/save").hasAuthority("ADMIN")
				.antMatchers(HttpMethod.DELETE, "/api/toothings/del").hasAuthority("ADMIN")

				.antMatchers(HttpMethod.POST, "/auth/login").permitAll()

				.and().addFilter(authenticationFilter())
				.exceptionHandling()
				.authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED));
	}

	public AuthenticationFilter authenticationFilter() throws Exception {
		AuthenticationFilter authenticationFilter = new AuthenticationFilter(objectMapper);
		authenticationFilter.setAuthenticationSuccessHandler(successHandler);
		authenticationFilter.setAuthenticationFailureHandler(failureHandler);
		authenticationFilter.setAuthenticationManager(super.authenticationManager());
		return authenticationFilter;
	}
}
