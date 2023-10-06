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
	
	
	public PolicyBoard getPolicyBoard(long idx) {
		if(policyBoardMapper==null) {return null;}
		
		PolicyBoard policyBoard = policyBoardMapper.getPolicyBoard(idx);
		
		return policyBoard;
	}
	
}
