package com.iyzico.challenge.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.iyzico.challenge.configuration.ChallengeServerProperties;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	ChallengeServerProperties properties;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().headers().frameOptions().disable();
		// http.authorizeRequests().antMatchers("/static/**").permitAll();
		// // other antMatchers can follow here
		// http.authorizeRequests().antMatchers("/login").permitAll().anyRequest().fullyAuthenticated().and().formLogin().loginPage("/login")
		// .failureUrl("/login?error").and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser(properties.getServerUserName()).password(properties.getServerPassword()).roles(properties.getServerRole());
	}

}