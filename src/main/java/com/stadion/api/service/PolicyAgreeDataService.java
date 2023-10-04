package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.PolicyAgreeData;
import com.stadion.api.mapper.PolicyAgreeDataMapper;


@Service
public class PolicyAgreeDataService {
	@Autowired
	private PolicyAgreeDataMapper policyAgreeDataMapper;
	
	
	public PolicyAgreeData getPolicyAgreeData(String userId) {
		if(policyAgreeDataMapper==null) {return null;}
		
		PolicyAgreeData policyAgreeData = policyAgreeDataMapper.getPolicyAgreeData(userId);
		
		return policyAgreeData;
	}
	public PolicyAgreeData getPolicyAgreeDataByEmail(String emailAddress) {
		if(policyAgreeDataMapper==null) {return null;}
		
		PolicyAgreeData policyAgreeData = policyAgreeDataMapper.getPolicyAgreeDataByEmail(emailAddress);
		
		return policyAgreeData;
	}

}
