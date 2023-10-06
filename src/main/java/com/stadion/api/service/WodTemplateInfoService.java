package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.WodTemplateInfo;
import com.stadion.api.mapper.WodTemplateInfoMapper;


@Service
public class WodTemplateInfoService {
	@Autowired
	private WodTemplateInfoMapper wodTemplateInfoMapper;
	
	
	public WodTemplateInfo getWodTemplateInfo(long idx) {
		if(wodTemplateInfoMapper==null) {return null;}
		
		WodTemplateInfo wodTemplateInfo = wodTemplateInfoMapper.getWodTemplateInfo(idx);
		
		return wodTemplateInfo;
	}
	
}
