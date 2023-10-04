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
	
	
	public WodTemplateInfo getWodTemplateInfo(String userId) {
		if(wodTemplateInfoMapper==null) {return null;}
		
		WodTemplateInfo wodTemplateInfo = wodTemplateInfoMapper.getWodTemplateInfo(userId);
		
		return wodTemplateInfo;
	}
	public WodTemplateInfo getWodTemplateInfoByEmail(String emailAddress) {
		if(wodTemplateInfoMapper==null) {return null;}
		
		WodTemplateInfo wodTemplateInfo = wodTemplateInfoMapper.getWodTemplateInfoByEmail(emailAddress);
		
		return wodTemplateInfo;
	}

}
