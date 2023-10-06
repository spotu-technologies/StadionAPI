package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.WodRoundItemInfo;
import com.stadion.api.mapper.WodRoundItemInfoMapper;


@Service
public class WodRoundItemInfoService {
	@Autowired
	private WodRoundItemInfoMapper wodRoundItemInfoMapper;
	
	
	public WodRoundItemInfo getWodRoundItemInfo(long idx) {
		if(wodRoundItemInfoMapper==null) {return null;}
		
		WodRoundItemInfo wodRoundItemInfo = wodRoundItemInfoMapper.getWodRoundItemInfo(idx);
		
		return wodRoundItemInfo;
	}
	
}
