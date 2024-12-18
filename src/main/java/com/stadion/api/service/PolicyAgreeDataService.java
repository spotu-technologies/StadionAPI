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
	
	
	public PolicyAgreeData getPolicyAgreeData(long idx) {
		if(policyAgreeDataMapper==null) {return null;}
		
		PolicyAgreeData policyAgreeData = policyAgreeDataMapper.getPolicyAgreeData(idx);
		
		return policyAgreeData;
	}
	
	public int insertPolicyAgreeData(PolicyAgreeData arg) {
		if(policyAgreeDataMapper==null) {return 0;}		
		return policyAgreeDataMapper.insertPolicyAgreeData(arg);
	}
	
}
