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
	
	
	public WodTemplateRecordInfo getWodTemplateRecordInfo(long idx) {
		if(wodTemplateRecordInfoMapper==null) {return null;}
		
		WodTemplateRecordInfo wodTemplateRecordInfo = wodTemplateRecordInfoMapper.getWodTemplateRecordInfo(idx);
		
		return wodTemplateRecordInfo;
	}
	
}
