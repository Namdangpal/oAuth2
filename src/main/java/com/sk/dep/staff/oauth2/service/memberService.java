package com.sk.dep.staff.oauth2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sk.dep.staff.oauth2.entity.member;
import com.sk.dep.staff.oauth2.repository.memberRepository;

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
@Service
public class memberService {
	@Autowired
	private memberRepository objMemberRepo;
	
	public member memberOne(String staffId){		
		return objMemberRepo.findOne(staffId);
	}	
	public boolean memberExists(String staffId){		
		return objMemberRepo.exists(staffId);
	}
}
