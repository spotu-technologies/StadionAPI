package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.PolicyHistory;
import com.stadion.api.mapper.PolicyHistoryMapper;


@Service
public class PolicyHistoryService {
	@Autowired
	private PolicyHistoryMapper policyHistoryMapper;
	
	
	public PolicyHistory getPolicyHistory(String userId) {
		if(policyHistoryMapper==null) {return null;}
		
		PolicyHistory policyHistory = policyHistoryMapper.getPolicyHistory(userId);
		
		return policyHistory;
	}
	public PolicyHistory getPolicyHistoryByEmail(String emailAddress) {
		if(policyHistoryMapper==null) {return null;}
		
		PolicyHistory policyHistory = policyHistoryMapper.getPolicyHistoryByEmail(emailAddress);
		
		return policyHistory;
	}

}
