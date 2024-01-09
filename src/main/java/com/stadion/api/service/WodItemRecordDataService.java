package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.MovementRecordData;
import com.stadion.api.entity.WodItemRecordData;
import com.stadion.api.mapper.WodItemRecordDataMapper;


@Service
public class WodItemRecordDataService {
	@Autowired
	private WodItemRecordDataMapper wodItemRecordDataMapper;
	
	public List<WodItemRecordData> getWodItemRecordDataRecent(long accountIdx) {
		if(wodItemRecordDataMapper==null) {return null;}
		
		List<WodItemRecordData> wodItemRecordDataList = wodItemRecordDataMapper.getWodItemRecordDataRecent(accountIdx);
		
		return wodItemRecordDataList;
	}
	
	
	public WodItemRecordData getWodItemRecordData(long idx) {
		if(wodItemRecordDataMapper==null) {return null;}
		
		WodItemRecordData wodItemRecordData = wodItemRecordDataMapper.getWodItemRecordData(idx);
		
		return wodItemRecordData;
	}
	
}
