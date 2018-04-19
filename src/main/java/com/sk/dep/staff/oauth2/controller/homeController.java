package com.sk.dep.staff.oauth2.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sk.dep.staff.oauth2.utils.WebUtils;
 

/*
 * ------------------------------------------------------------------------------
 * @Project     : SK Holdings DEP Project
 * @Summary  : Init Class       
 *
 * @Author  : Administrator
 * @Date     : 2018. 4. 2.
 * @Version : 1.0
 *------------------------------------------------------------------------------
 *                  REVISION HISTORY                    
 *------------------------------------------------------------------------------
 *    DATE     AUTHOR                      DESCRIPTION                        
 * ----------  ------        --------------------------------------------------
 * 2018. 4. 2.   Administrator       Init                                     
 *------------------------------------------------------------------------------
 * Copyright(c) 2018 SK Holdings All rights reserved 
 */
@Controller 
public class homeController {
	private static final Logger logger = LoggerFactory.getLogger(homeController.class);
	
	@RequestMapping(value="/") 
	public String indexView() throws Exception{
		logger.info("welcome");
		return "login";
	}
	
	@RequestMapping(value="/login") 
	public String loginView(Model model) throws Exception{ 
		String SALT = "TEST";
		byte[] key = SALT.getBytes("UTF-8");
		logger.info("/login : "  + key.toString() + " : " + new String(SALT.getBytes("UTF-8"), "utf-8")) ;
		return "login";
	} 
	
	@RequestMapping(value="/loginCheck", method=RequestMethod.POST) 
	public String loginCheckView(@PathVariable String staffId,@PathVariable String staffPwd,Model model) throws Exception{ 
		System.out.println("User Name: " + staffId + " :" + staffPwd); 
		return "loginCheck";
	}
	
	@RequestMapping(value="/member/userAccount") 
	public String loginCheckView(Model model,Principal principal) throws Exception{ 
		String userName = principal.getName(); 
		String userPwd =  Context.SECURITY_AUTHENTICATION;
        System.out.println("User Name: " + userName + " :" + userPwd); 
		return "userAccount";
	}
	
	@RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public String userInfo(Model model, Principal principal) {
 
        // After user login successfully.
        String userName = principal.getName(); 
        System.out.println("User Name: " + userName); 
        User loginedUser = (User) ((Authentication) principal).getPrincipal(); 
        String userInfo = WebUtils.toString(loginedUser);
        
        System.out.println("userInfo : " + userInfo ); 
        model.addAttribute("userInfo", userInfo);
 
        return "userInfoPage";
    }
 
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) { 
        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal(); 
            String userInfo = WebUtils.toString(loginedUser); 
            model.addAttribute("userInfo", userInfo); 
            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);
        }
 
        return "403Page";
    }
 
 
}
