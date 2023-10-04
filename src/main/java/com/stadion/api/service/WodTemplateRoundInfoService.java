package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.WodTemplateRoundInfo;
import com.stadion.api.mapper.WodTemplateRoundInfoMapper;


@Service
public class WodTemplateRoundInfoService {
	@Autowired
	private WodTemplateRoundInfoMapper wodTemplateRoundInfoMapper;
	
	
	public WodTemplateRoundInfo getWodTemplateRoundInfo(int idx) {
		if(wodTemplateRoundInfoMapper==null) {return null;}
		
		WodTemplateRoundInfo wodTemplateRoundInfo = wodTemplateRoundInfoMapper.getWodTemplateRoundInfo(idx);
		
		return wodTemplateRoundInfo;
	}
	
}
