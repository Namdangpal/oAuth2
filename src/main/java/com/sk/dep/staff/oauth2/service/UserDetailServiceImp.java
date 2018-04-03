package com.sk.dep.staff.oauth2.service;

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
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.sk.dep.staff.oauth2.entity.member;
 
 
@Component
public class UserDetailServiceImp implements UserDetailsService {
    @Autowired
    memberService userRepository;
 
    @Override
    public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {
        member user = userRepository.memberOne(memberId);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN")); 
        return new org.springframework.security.core.userdetails.User(user.getStaffId(), 
                                                                      user.getStaffPwd(),
                                                                      grantedAuthorities);
    }
}
 