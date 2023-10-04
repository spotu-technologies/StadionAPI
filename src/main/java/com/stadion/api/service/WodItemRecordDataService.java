package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.WodItemRecordData;
import com.stadion.api.mapper.WodItemRecordDataMapper;


@Service
public class WodItemRecordDataService {
	@Autowired
	private WodItemRecordDataMapper wodItemRecordDataMapper;
	
	
	public WodItemRecordData getWodItemRecordData(String userId) {
		if(wodItemRecordDataMapper==null) {return null;}
		
		WodItemRecordData wodItemRecordData = wodItemRecordDataMapper.getWodItemRecordData(userId);
		
		return wodItemRecordData;
	}
	public WodItemRecordData getWodItemRecordDataByEmail(String emailAddress) {
		if(wodItemRecordDataMapper==null) {return null;}
		
		WodItemRecordData wodItemRecordData = wodItemRecordDataMapper.getWodItemRecordDataByEmail(emailAddress);
		
		return wodItemRecordData;
	}

}
