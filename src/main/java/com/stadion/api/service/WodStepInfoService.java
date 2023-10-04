package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.WodStepInfo;
import com.stadion.api.mapper.WodStepInfoMapper;


@Service
public class WodStepInfoService {
	@Autowired
	private WodStepInfoMapper wodStepInfoMapper;
	
	
	public WodStepInfo getWodStepInfo(String userId) {
		if(wodStepInfoMapper==null) {return null;}
		
		WodStepInfo wodStepInfo = wodStepInfoMapper.getWodStepInfo(userId);
		
		return wodStepInfo;
	}
	public WodStepInfo getWodStepInfoByEmail(String emailAddress) {
		if(wodStepInfoMapper==null) {return null;}
		
		WodStepInfo wodStepInfo = wodStepInfoMapper.getWodStepInfoByEmail(emailAddress);
		
		return wodStepInfo;
	}

}
