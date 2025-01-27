//package com.upskill.product.config;
////
////
//import static org.springframework.security.config.Customizer.withDefaults;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SpringSecurityConfiguration {
//	
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		
////		1) All requests should be authenticated
//		http.cors()
//		http.csrf().disable();
//		
//		return http.build();
//	}
//
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//	    http
//	            .cors().and()
//	            .authorizeRequests()
//	            .antMatchers("/admin/**").authenticated()//.hasAnyRole("ADMIN","USER")
//	            .and().formLogin().loginPage("/login").permitAll()
//	            .and().logout();
//	    http.csrf().disable();
//	    http.headers().frameOptions().disable();
//	}
//
//}




