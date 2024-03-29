package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.WodItem5RmData;
import com.stadion.api.entity.WodItemOneRmData;
import com.stadion.api.mapper.WodItem5RmDataMapper;


@Service
public class WodItem5RmDataService {
	@Autowired
	private WodItem5RmDataMapper wodItem5RmDataMapper;
	
	
	public WodItem5RmData getWodItem5RmData(long idx) {
		if(wodItem5RmDataMapper==null) {return null;}
		
		WodItem5RmData wodItem5RmData = wodItem5RmDataMapper.getWodItem5RmData(idx);
		
		return wodItem5RmData;
	}
	
	
	public List<WodItem5RmData> getWodItem5RmDataPersonalDetail(long accountIdx) {
		if(wodItem5RmDataMapper==null) {return null;}
		
		List<WodItem5RmData> wodItem5RmDataList = wodItem5RmDataMapper.getWodItem5RmDataPersonalDetail(accountIdx);
		
		return wodItem5RmDataList;
	}
	
}
