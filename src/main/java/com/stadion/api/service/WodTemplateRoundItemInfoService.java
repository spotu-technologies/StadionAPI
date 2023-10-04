package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.WodTemplateRoundItemInfo;
import com.stadion.api.mapper.WodTemplateRoundItemInfoMapper;
;

@Service
public class WodTemplateRoundItemInfoService {
	@Autowired
	private WodTemplateRoundItemInfoMapper wodTemplateRoundItemInfoMapper;
	
	
	public WodTemplateRoundItemInfo getWodTemplateRoundItemInfo(int idx) {
		if(wodTemplateRoundItemInfoMapper==null) {return null;}
		
		WodTemplateRoundItemInfo wodTemplateRoundItemInfo = wodTemplateRoundItemInfoMapper.getWodTemplateRoundItemInfo(idx);
		
		return wodTemplateRoundItemInfo;
	}
	
}
