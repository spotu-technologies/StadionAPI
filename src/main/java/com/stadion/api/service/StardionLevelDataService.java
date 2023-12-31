package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.StardionLevelData;
import com.stadion.api.mapper.StardionLevelDataMapper;


@Service
public class StardionLevelDataService {
	@Autowired
	private StardionLevelDataMapper stardionLevelDataMapper;
	
	
	public StardionLevelData getStardionLevelData(long idx) {
		if(stardionLevelDataMapper==null) {return null;}
		
		StardionLevelData stardionLevelData = stardionLevelDataMapper.getStardionLevelData(idx);
		
		return stardionLevelData;
	}
	
}
