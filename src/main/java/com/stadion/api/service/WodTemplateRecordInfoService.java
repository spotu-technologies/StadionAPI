package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.WodTemplateRecordInfo;
import com.stadion.api.mapper.WodTemplateRecordInfoMapper;


@Service
public class WodTemplateRecordInfoService {
	@Autowired
	private WodTemplateRecordInfoMapper wodTemplateRecordInfoMapper;
	
	
	public WodTemplateRecordInfo getWodTemplateRecordInfo(String userId) {
		if(wodTemplateRecordInfoMapper==null) {return null;}
		
		WodTemplateRecordInfo wodTemplateRecordInfo = wodTemplateRecordInfoMapper.getWodTemplateRecordInfo(userId);
		
		return wodTemplateRecordInfo;
	}
	public WodTemplateRecordInfo getWodTemplateRecordInfoByEmail(String emailAddress) {
		if(wodTemplateRecordInfoMapper==null) {return null;}
		
		WodTemplateRecordInfo wodTemplateRecordInfo = wodTemplateRecordInfoMapper.getWodTemplateRecordInfoByEmail(emailAddress);
		
		return wodTemplateRecordInfo;
	}

}
