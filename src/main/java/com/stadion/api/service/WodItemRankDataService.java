package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.WodItemRankData;
import com.stadion.api.mapper.WodItemRankDataMapper;


@Service
public class WodItemRankDataService {
	@Autowired
	private WodItemRankDataMapper wodItemRankDataMapper;
	
	
	public WodItemRankData getWodItemRankData(long idx) {
		if(wodItemRankDataMapper==null) {return null;}
		
		WodItemRankData wodItemRankData = wodItemRankDataMapper.getWodItemRankData(idx);
		
		return wodItemRankData;
	}
	
}
