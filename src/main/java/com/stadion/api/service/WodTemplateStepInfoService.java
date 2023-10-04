package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.WodTemplateStepInfo;
import com.stadion.api.mapper.WodTemplateStepInfoMapper;


@Service
public class WodTemplateStepInfoService {
	@Autowired
	private WodTemplateStepInfoMapper wodTemplateStepInfoMapper;
	
	
	public WodTemplateStepInfo getWodTemplateStepInfo(String userId) {
		if(wodTemplateStepInfoMapper==null) {return null;}
		
		WodTemplateStepInfo wodTemplateStepInfo = wodTemplateStepInfoMapper.getWodTemplateStepInfo(userId);
		
		return wodTemplateStepInfo;
	}
	public WodTemplateStepInfo getWodTemplateStepInfoByEmail(String emailAddress) {
		if(wodTemplateStepInfoMapper==null) {return null;}
		
		WodTemplateStepInfo wodTemplateStepInfo = wodTemplateStepInfoMapper.getWodTemplateStepInfoByEmail(emailAddress);
		
		return wodTemplateStepInfo;
	}

}
