package com.sk.dep.staff.oauth2.utils;

/*
 * ------------------------------------------------------------------------------
 * @Project     : SK Holdings DEP Project
 * @Summary  : Init Class       
 *
 * @Author  : Administrator
 * @Date     : 2018. 4. 4.
 * @Version : 1.0
 *------------------------------------------------------------------------------
 *                  REVISION HISTORY                    
 *------------------------------------------------------------------------------
 *    DATE     AUTHOR                      DESCRIPTION                        
 * ----------  ------        --------------------------------------------------
 * 2018. 4. 4.   Administrator       Init                                     
 *------------------------------------------------------------------------------
 * Copyright(c) 2018 SK Holdings All rights reserved 
 */

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class WebUtils {

   public static String toString(User user) {
       StringBuilder sb = new StringBuilder();

       sb.append("UserName:").append(user.getUsername());

       Collection<GrantedAuthority> authorities = user.getAuthorities();
       if (authorities != null && !authorities.isEmpty()) {
           sb.append(" (");
           boolean first = true;
           for (GrantedAuthority a : authorities) {
               if (first) {
                   sb.append(a.getAuthority());
                   first = false;
               } else {
                   sb.append(", ").append(a.getAuthority());
               }
           }
           sb.append(")");
       }
       return sb.toString();
   }
    
}