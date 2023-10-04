package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.WodItem3RmData;
import com.stadion.api.mapper.WodItem3RmDataMapper;


@Service
public class WodItem3RmDataService {
	@Autowired
	private WodItem3RmDataMapper wodItem3RmDataMapper;
	
	
	public WodItem3RmData getWodItem3RmData(int idx) {
		if(wodItem3RmDataMapper==null) {return null;}
		
		WodItem3RmData wodItem3RmData = wodItem3RmDataMapper.getWodItem3RmData(idx);
		
		return wodItem3RmData;
	}
	
}
