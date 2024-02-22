//package com.ncs.customerservice.config;
//
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@EnableWebSecurity
//
//public class MySecurity2 extends WebSecurityConfigurerAdapter {
//
//    protected void configure(HttpSecurity http) throws Exception{
//        http.csrf().disable();
//        http.authorizeRequests().antMatchers("/").permitAll(); //if u dont want to access any
//        http.authorizeRequests().anyRequest().authenticated();
//        http.formLogin();
//    }
//}
