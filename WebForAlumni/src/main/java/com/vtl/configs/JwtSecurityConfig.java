/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtl.configs;

import com.vtl.filter.CustomAccessDeniedHandler;
import com.vtl.filter.JwtAuthenticationTokenFilter;
import com.vtl.filter.RestAuthenticationEntryPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author Thuy Linh
 */
@Configuration
@EnableWebSecurity
@EnableTransactionManagement
@ComponentScan(basePackages = {
    "com.vtl.controller",
    "com.vtl.repository",
    "com.vtl.service",
    "com.vtl.component",
    "com.vtl.mail"})
@Order(1)
public class JwtSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter() throws Exception {
        JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter = new JwtAuthenticationTokenFilter();
        jwtAuthenticationTokenFilter.setAuthenticationManager(authenticationManager());
        return jwtAuthenticationTokenFilter;
    }

    @Bean
    public RestAuthenticationEntryPoint restServicesEntryPoint() {
        return new RestAuthenticationEntryPoint();
    }

    @Bean
    public CustomAccessDeniedHandler customAccessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().ignoringAntMatchers("/api/**");
        http.authorizeRequests().antMatchers("/api/login/**").permitAll();
        http.authorizeRequests().antMatchers("/api/Post/**").permitAll();
        http.authorizeRequests().antMatchers("/api/Post/").permitAll();
        http.authorizeRequests().antMatchers("/api/Comment/**").permitAll();
        http.authorizeRequests().antMatchers("/api/Notification/**").permitAll();
        http.authorizeRequests().antMatchers("/api/Topic/**").permitAll();
        http.authorizeRequests().antMatchers("/api/Major/**").permitAll();
         http.authorizeRequests().antMatchers("/api/Account/**").permitAll();
         http.authorizeRequests().antMatchers("/api/AddPost/**").permitAll();
          http.authorizeRequests().antMatchers("/api/AddComment/**").permitAll();
           http.authorizeRequests().antMatchers("/api/LikeHaha/**").permitAll();
           http.authorizeRequests().antMatchers("/api/Like/**").permitAll();
            http.authorizeRequests().antMatchers("/api/Users/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_STUDENT')");
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/**/Comment/").permitAll();
        http.antMatcher("/api/**").httpBasic().authenticationEntryPoint(restServicesEntryPoint()).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_STUDENT')")
                .antMatchers(HttpMethod.POST, "/api/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_STUDENT')")
                .antMatchers(HttpMethod.DELETE, "/api/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_STUDENT')").and()
                .addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling().accessDeniedHandler(customAccessDeniedHandler());
    }
}
