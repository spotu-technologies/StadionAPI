package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.WodItemOneRmData;
import com.stadion.api.mapper.WodItemOneRmDataMapper;


@Service
public class WodItemOneRmDataService {
	@Autowired
	private WodItemOneRmDataMapper wodItemOneRmDataMapper;
	
	
	public WodItemOneRmData getWodItemOneRmData(int idx) {
		if(wodItemOneRmDataMapper==null) {return null;}
		
		WodItemOneRmData wodItemOneRmData = wodItemOneRmDataMapper.getWodItemOneRmData(idx);
		
		return wodItemOneRmData;
	}
	
}
