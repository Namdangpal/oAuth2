package com.sk.dep.staff.oauth2.service;

import java.text.SimpleDateFormat;
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
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.sk.dep.staff.oauth2.entity.member;
 
 
@Component
public class UserDetailServiceImp implements UserDetailsService {
	private static final Logger logger = LoggerFactory.getLogger(UserDetailServiceImp.class);
    @Autowired
    memberService userRepository;
 
    @Override
    public UserDetails loadUserByUsername(String staffId) throws UsernameNotFoundException {
        member objMember = userRepository.memberOne(staffId);
        if(objMember == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
        logger.info("User Find: " + objMember.getStaffId());
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        logger.info("passwordEncoder : " + passwordEncoder.matches("11111111", objMember.getStaffPwd()));
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN")); 
        UserDetails userDetails = (UserDetails) new User(objMember.getStaffId(), objMember.getStaffPwd(),grantedAuthorities);
 
        return userDetails;
    }
}
 