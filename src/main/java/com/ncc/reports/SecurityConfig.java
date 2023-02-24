package com.ncc.reports;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {


//		http
//		.csrf().disable()
//		.authorizeHttpRequests((requests) -> requests
//
//				.requestMatchers("/").permitAll()
//				.requestMatchers("/login").permitAll()
//				.requestMatchers("/resources/**").permitAll()
//				
//				.anyRequest().authenticated()
//			)
//			.formLogin((form) -> form
//				.loginPage("/login")
//				.permitAll()
//			)
//			.logout((logout) -> logout.permitAll())
		
//		.loginPage("/login")
		
//		;

//		http
//		.csrf().disable()		
//		
//		.authorizeHttpRequests()
//        .requestMatchers("/login", "/**")
//        .permitAll() 
//        .anyRequest().authenticated()     		
//		
//		.and()
//        .formLogin()
//            .loginPage("/login")
//            .permitAll()            
//            .loginProcessingUrl("/login")
//        
//        ;
		
		http.authorizeHttpRequests(
				(requests) -> requests.requestMatchers("/**", "/login").permitAll().anyRequest().authenticated())
				.formLogin
				(
						(form) -> form.loginPage("/login").permitAll()
				)				
				.logout((logout) -> logout.permitAll());

		return http.build();
	}
 	@Bean
 	public UserDetailsService userDetailsService() {
 		UserDetails user = User.withDefaultPasswordEncoder()
 			.username("user")
 			.password("password")
 			.roles("USER")
 			.build();
 		UserDetails admin = User.withDefaultPasswordEncoder()
 			.username("admin")
 			.password("password")
 			.roles("ADMIN", "USER")
 			.build();
 		return new InMemoryUserDetailsManager(user, admin);
 	}	
//	@Bean
//	public UserDetailsService userDetailsService() {
//		UserDetails user =
//			 User.withDefaultPasswordEncoder()
//				.username("user")
//				.password("password")
//				.roles("USER")
//				.build();
//
//		return new InMemoryUserDetailsManager(user);
//	}
//	
	@Bean
	public WebSecurityCustomizer configure() throws Exception {
	    return (web) -> web.ignoring().requestMatchers("/login");
	}
}
