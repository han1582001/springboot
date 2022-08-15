package com.example.mybook.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.mybook.service.CustomSuccessHandler;
import com.example.mybook.service.CustomUserDetailService;

@Configuration
@EnableWebSecurity
public class Webconfig extends WebSecurityConfigurerAdapter {

	@Autowired
	CustomUserDetailService ctmuser;
	@Autowired
	CustomSuccessHandler customhandler;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();

		http.authorizeRequests().antMatchers("/404error/**","/json","/json/**","/admin", "/admin/**","/","/mybook", "/mybook/**", "/dangky","/images","/images/**", "/adminx", "/adminx/**", "/clientx/**", "/dangky/**",
				"/dangnhap/**", "/dangxuat").permitAll();
		//http.authorizeRequests().antMatchers("/admin", "/admin/**").access("hasRole('ADMIN')");
		http.authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage("/dangnhap").permitAll()
				.successHandler(customhandler).failureUrl("/dangnhap?success=fail")
				.loginProcessingUrl("/j_spring_security_check");
		http.logout(logout -> logout.logoutUrl("/dangxuat").logoutSuccessUrl("/dangnhap").invalidateHttpSession(true));
		// Rememberme
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(ctmuser).passwordEncoder(passwordEncoder());
	}

}
