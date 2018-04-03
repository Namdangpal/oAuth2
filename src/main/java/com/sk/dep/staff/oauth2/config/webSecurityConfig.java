package com.sk.dep.staff.oauth2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

/*
 * ------------------------------------------------------------------------------
 * @Project     : SK Holdings DEP Project
 * @Summary  : Init Class       
 *
 * @Author  : Administrator
 * @Date     : 2018. 4. 3.
 * @Version : 1.0
 *------------------------------------------------------------------------------
 *                  REVISION HISTORY                    
 *------------------------------------------------------------------------------
 *    DATE     AUTHOR                      DESCRIPTION                        
 * ----------  ------        --------------------------------------------------
 * 2018. 4. 3.   Administrator       Init                                     
 *------------------------------------------------------------------------------
 * Copyright(c) 2018 SK Holdings All rights reserved 
 */
@Configuration
@EnableWebSecurity
public class webSecurityConfig extends WebSecurityConfigurerAdapter {

	 @Autowired
	    private AccessDeniedHandler accessDeniedHandler;
	 @Autowired 
	 UserDetailsService userDetailsService; 
	  

	    // roles admin allow to access /admin/**
	    // roles user allow to access /user/**
	    // custom 403 access denied handler
	
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {

	        http.csrf().disable()
	                .authorizeRequests()
						.antMatchers("/", "/login", "/about").permitAll()
						.antMatchers("/admin/**").hasAnyRole("ADMIN")
						.antMatchers("/member/**").hasAnyRole("ADMIN")
						.antMatchers("/user/**").hasAnyRole("USER")
						.anyRequest().authenticated()
	                .and()
	                .formLogin()
						.loginPage("/login")
						.permitAll()
						.and() 
	                .logout()
						.permitAll() 
					 	.and()
	                .exceptionHandling().accessDeniedHandler(accessDeniedHandler); 
	    }

	    // create two users, admin and user
	    @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	    	 auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	    }  
 
	    @Bean
	    public BCryptPasswordEncoder passwordEncoder() {
	        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	        return bCryptPasswordEncoder;
	    }
	    
}
