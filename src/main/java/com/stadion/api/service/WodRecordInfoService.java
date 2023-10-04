package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.WodRecordInfo;
import com.stadion.api.mapper.WodRecordInfoMapper;


@Service
public class WodRecordInfoService {
	@Autowired
	private WodRecordInfoMapper wodRecordInfoMapper;
	
	
	public WodRecordInfo getWodRecordInfo(String userId) {
		if(wodRecordInfoMapper==null) {return null;}
		
		WodRecordInfo wodRecordInfo = wodRecordInfoMapper.getWodRecordInfo(userId);
		
		return wodRecordInfo;
	}
	public WodRecordInfo getWodRecordInfoByEmail(String emailAddress) {
		if(wodRecordInfoMapper==null) {return null;}
		
		WodRecordInfo wodRecordInfo = wodRecordInfoMapper.getWodRecordInfoByEmail(emailAddress);
		
		return wodRecordInfo;
	}

}
