package com.sk.dep.staff.oauth2.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
		return "login";
	} 
	
	@RequestMapping(value="/loginCheck", method=RequestMethod.POST) 
	public String loginCheckView(@PathVariable String staffId,@PathVariable String staffPwd,Model model) throws Exception{ 
		return "loginCheck";
	}
	
	@RequestMapping(value="/userAccount") 
	public String loginCheckView(Model model) throws Exception{ 
		return "userAccount";
	}
	
}
