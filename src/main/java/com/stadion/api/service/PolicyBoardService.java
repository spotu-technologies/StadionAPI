package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.PolicyBoard;
import com.stadion.api.mapper.PolicyBoardMapper;


@Service
public class PolicyBoardService {
	@Autowired
	private PolicyBoardMapper policyBoardMapper;
	
	
	public PolicyBoard getPolicyBoard(String userId) {
		if(policyBoardMapper==null) {return null;}
		
		PolicyBoard policyBoard = policyBoardMapper.getPolicyBoard(userId);
		
		return policyBoard;
	}
	public PolicyBoard getPolicyBoardByEmail(String emailAddress) {
		if(policyBoardMapper==null) {return null;}
		
		PolicyBoard policyBoard = policyBoardMapper.getPolicyBoardByEmail(emailAddress);
		
		return policyBoard;
	}

}
