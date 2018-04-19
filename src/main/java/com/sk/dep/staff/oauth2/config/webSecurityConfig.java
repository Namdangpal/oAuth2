package com.sk.dep.staff.oauth2.config;

import javax.sql.DataSource;

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
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

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
	 @Autowired 
	 DataSource dataSource;	  

	    // roles admin allow to access /admin/**
	    // roles user allow to access /user/**
	    // custom 403 access denied handler
	
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {

	        http.csrf().disable()
	                .authorizeRequests()
						.antMatchers("/", "/login", "/logout").permitAll()
						.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
						.antMatchers("/member/**").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
						.antMatchers("/user/**").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
						.anyRequest().authenticated()						
						.and()
	                .formLogin()
	                	.loginProcessingUrl("/loginCheck") // Submit URL
	                	.loginPage("/login")//
	                	.failureUrl("/login?error=true")//
	                	.usernameParameter("staffId")//
	                	.passwordParameter("staffPwd")
	                	.defaultSuccessUrl("/member/userAccount")//
	                	// Config for Logout Page
	                	.and()
	                	
	                .logout()
	                	.logoutUrl("/logout").logoutSuccessUrl("/logoutSuccessful") 
						.and()  
	                .exceptionHandling().accessDeniedHandler(accessDeniedHandler); 
	        http.authorizeRequests()
	        		.and() //
            		.rememberMe().tokenRepository(this.persistentTokenRepository()) //
            		.tokenValiditySeconds(1 * 24 * 60 * 60); // 24h
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
	    @Bean
	    public PersistentTokenRepository persistentTokenRepository() {
	        JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();	        
			db.setDataSource(dataSource);
	        return db;
	    }
}
