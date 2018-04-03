package com.sk.dep.staff.oauth2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sk.dep.staff.oauth2.entity.member;
import com.sk.dep.staff.oauth2.service.memberService;

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
@RestController
@RequestMapping(value="/member")
public class memberController {
	
	@Autowired
	private memberService  objMemberService;
	
	@RequestMapping(value="/getMember/{staffId}", method=RequestMethod.GET, headers="Accept=application/json")
	@ResponseBody
	public member getMemberOne(@PathVariable String staffId) throws Exception{	
		 return  objMemberService.memberOne(staffId);
	}
	
	@RequestMapping(value="/memberExist/{staffId}", method=RequestMethod.GET, headers="Accept=application/json")
	@ResponseBody
	public boolean bloMemberExists(@PathVariable String staffId) throws Exception{	
		 return  objMemberService.memberExists(staffId);
	}
	 

}
