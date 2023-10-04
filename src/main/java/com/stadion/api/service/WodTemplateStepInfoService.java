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
	
	
	public WodTemplateStepInfo getWodTemplateStepInfo(int idx) {
		if(wodTemplateStepInfoMapper==null) {return null;}
		
		WodTemplateStepInfo wodTemplateStepInfo = wodTemplateStepInfoMapper.getWodTemplateStepInfo(idx);
		
		return wodTemplateStepInfo;
	}
	
}
