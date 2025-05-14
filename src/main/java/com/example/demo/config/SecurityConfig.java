package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(csrf -> csrf.disable()) // ⚠ Only for testing — remove in production!
//                .authorizeHttpRequests(requests -> requests
//                        .requestMatchers("/api/users/**").permitAll() // allow signup & login
//                        .requestMatchers("/courses/**").permitAll() // allow courses endpoints
//                        .anyRequest().authenticated())
//                .formLogin(login -> login.disable());
//
//        return http.build();
//    }
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeHttpRequests().anyRequest().permitAll();
        return http.build();
    }
}
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//@SuppressWarnings({ "deprecation", "removal" })
//@Override
//  protected void configure(HttpSecurity http) throws Exception {
//  http
//          .csrf(csrf -> csrf.disable())  // ⚠ disable CSRF only for testing!
//          .authorizeRequests(requests -> requests
//                  .requestMatchers("/api/users/**", "/courses/**").permitAll()
//                  .anyRequest().authenticated());
//  }
//}
//@Bean
//public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//  http
//      .csrf(csrf -> csrf.disable())  // ⚠ disable only for testing!
//      .authorizeHttpRequests(auth -> auth
//          .requestMatchers("/api/users/**", "/courses/**").permitAll()
//          .anyRequest().authenticated()
//      );
//  return http.build();
//}

